package Client;

import static Abstract.Recurso.METALES;
import Client.Raza.*;
import static Concrete.Edifiacion.TipoEdif.BASEAEREA;
import static Concrete.Edifiacion.TipoEdif.CUARTEL;
import static Concrete.Edifiacion.TipoEdif.GENERADOR_DE_RECURSOS;
import static Concrete.Edifiacion.TipoEdif.RECOLECTOR_DE_RECURSOS;



public class DanielNavarros_World {

    private static float fase;
    private static DanielNavarros_World juego;
    private static Jugador[] jugadores;
    private static boolean turno;
    
    private DanielNavarros_World() throws Exception{
        
        jugadores = new Jugador[2];
        turno=false;
        for (int i=0;i<2;i++ ){
            jugadores[i]=crearJugador();
            jugadores[i].iniciarPartida();
        }
        
    }

    public static synchronized DanielNavarros_World getJuego() throws Exception{
        if (juego==null)
            juego = new DanielNavarros_World();
        return juego;
    }
    
    public static Jugador[] getJugadores() { return jugadores; }
    
    public static float getFase() { return fase;}

    private Jugador crearJugador() throws Exception{
        String nombre = Menu.getNombre();
        return new Jugador(nombre, seleccionRaza());
    }

    public Raza seleccionRaza() throws Exception{

        int opcion=Menu.menuRaza();
        switch (opcion){
            case 1:
                return new Vaqueros();
            case 2:
                return new Indios();
            case 3:
                return new Aliens();
            }
        return null;
    }

    public void jugarTurno(Jugador jugador, Jugador jugador2) throws Exception{
        
        int opcion = Menu.menuTurno(jugador);
        switch(opcion){
            case 1:
                int op = Menu.menuConstruccion();
                
                switch(op){
                
                    case 1:
                        jugador.getTerritorio().construir(GENERADOR_DE_RECURSOS,
                                op);
                        break;
                    case 2:
                    case 3:
                        jugador.getTerritorio().construir(RECOLECTOR_DE_RECURSOS,
                                op);
                        break;
                    case 4:
                        jugador.getTerritorio().construir(CUARTEL,
                                op);
                        break;
                    case 5:
                        jugador.getTerritorio().construir(BASEAEREA,
                                op);
                        break;
                }
                break;

            case 2:
                int opcion2 =Menu.menuGuerra();
                switch(opcion2){
                    case 1:
                        jugador.getTerritorio().prepararEspecialista();
                        break;
                    case 2:
                        int op2=Menu.menuEscuadron(jugador.getTerritorio());
                        jugador.getTerritorio().entrenarTopa(op2-1);
                        break;
                    case 3:
                        int Op3=Menu.menuAvion(jugador.getTerritorio());
                        jugador.getTerritorio().preparaAvion(Op3-1);
                        break;
                    case 4:
                        int Op4=Menu.menuCarro(jugador.getTerritorio());
                        jugador.getTerritorio().preparaAvion(Op4-1);
                        break;
                    case 5:
                        int Op5=Menu.menuAtacar(jugador.getTerritorio());
                        
                        switch(Op5){
                            case 1:
                                jugador.getTerritorio().getEspecialista().
                                        setObejetivo(jugador2.getCentroDeMando().
                                                getVictima());
                                jugador.getTerritorio().getAtacantes().
                                        add(jugador.getTerritorio().getEspecialista());
                        
                                break;
                            case 2:
                                break;
                        }
                        break;
                }
                
                break;
            case 3:
                jugador.getCentroDeMando().recibir(jugador.getTerritorio().recolectar());
                break;
            case 4:
                terminarTurno(jugador);
                break;
        }
        Menu.Division2();        
        
        
    }
    
    private void terminarTurno(Jugador jugador) throws Exception{
        jugador.getCentroDeMando().recibir(METALES, 
                jugador.getTerritorio().generarRecursos()); 
        jugador.getTerritorio().producir();
        jugador.getTerritorio().atacar();
        DanielNavarros_World.fase+=0.5;
        Menu.Division();
        turno=!turno;
    }

   
    public static void main(String args[]) throws Exception{
        while(true){
            try {
                DanielNavarros_World jueguillo= DanielNavarros_World.getJuego();   
                Menu.Division();
                
                while(true){
                    Jugador jugador;
                    Jugador jugador1;
                    if(turno){
                        jugador = jugadores[0];
                        jugador1 = jugadores[1];
                    }else{    
                        jugador = jugadores[1];
                        jugador1 = jugadores[0];
                    }
                    Menu.Dashboard(jugador);
                    jueguillo.jugarTurno(jugador,jugador1);
                    
                }
            }catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
        }
    }
}
