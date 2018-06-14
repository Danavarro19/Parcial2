package Client;

import Abstract.Recurso;
import Client.Raza.*;
import Concrete.Edifiacion.TipoEdif;
import static Concrete.Edifiacion.TipoEdif.GENERADOR_DE_RECURSOS;
import static Concrete.Edifiacion.TipoEdif.REOLECTOR_DE_RECURSOS;



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

    public void jugarTurno(Jugador jugador) throws Exception{
        
        Menu.Dashboard(jugador);
        int opcion = Menu.menuTurno(jugador);
        switch(opcion){
            case 1:
                int op = Menu.menuConstruccion();
                
                switch(op){
                
                    case 1:
                    case 2:
                        jugador.getTerritorio().construir(GENERADOR_DE_RECURSOS,
                                op);
                        break;
                    case 3:
                        jugador.getTerritorio().construir(REOLECTOR_DE_RECURSOS,
                                op);
                        break;
                    case 4:
                        jugador.getTerritorio().construir(REOLECTOR_DE_RECURSOS,
                                op);
                        break;
                    case 5:
                        jugador.getTerritorio().construir(REOLECTOR_DE_RECURSOS,
                                op);
                        break;
                }
                break;

            case 2:
                int opcion2 =Menu.menuGuerra();
                switch(opcion2){
                    case 1:
                        
                    case 2:
                    case 3:
                }
                
                break;
            case 3:
                
        }
        terminarTurno(jugador);
        Menu.Division();        
        
        
    }
    
    private void terminarTurno(Jugador jugador){
        jugador.getCentroDeMando().recibir(Recurso.CALIZA, 
                jugador.getTerritorio().generarRecursos());    
        turno=!turno;
    }

   
    public static void main(String args[]) throws Exception{
        while(true){
            try {
                DanielNavarros_World jueguillo= DanielNavarros_World.getJuego();   
            
                while(true){
                
                    Menu.Division();
                    Jugador jugador;
                    if(turno)
                        jugador = jugadores[0];
                    else    
                        jugador = jugadores[1];
                    jueguillo.jugarTurno(jugador);
                    DanielNavarros_World.fase+=0.5;

                }
            }catch (Exception ex) {
                    System.err.println(ex);
                }
        }
    }
}
