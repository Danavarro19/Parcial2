package Client;

import Client.Raza.*;
import Concrete.Edifiacion.TipoEdif;
import static Concrete.Edifiacion.TipoEdif.GENERADOR_DE_RECURSOS;
import java.util.Scanner;



public class DanielNavarros_World {

    private static int fase;
    private static DanielNavarros_World juego;
    private static Jugador[] jugadores;

    


    private DanielNavarros_World() throws Exception{
        
        jugadores = new Jugador[2];
        
        for (int i=0;i<2;i++ ){
            jugadores[i]=crearJugador();
            jugadores[i].iniciarPartida();
        }
        Menu.Dashboard(jugadores);
    }


    public static synchronized DanielNavarros_World getJuego() throws Exception{
        if (juego==null)
            juego = new DanielNavarros_World();
        return juego;
    }
    
    
    public static Jugador[] getJugadores() { return jugadores; }

    public static int getFase() { return fase; }


    private Jugador crearJugador() throws Exception{
        String nombre = Menu.getNombre();
        return new Jugador(nombre, seleccionRaza());
    }


    public Raza seleccionRaza() throws Exception{

        int opcion=Menu.menuRaza();
        switch (opcion){
            case 1:
                return new Raza1();
            case 2:
                return new Raza2();
            case 3:
                return new Raza3();
            }
        return null;
    }


    public void jugarTurno(Jugador jugador) throws Exception{
        
        int opcion = Menu.menuTurno(jugador);
        switch(opcion){
            case 1:
                jugador.construir(GENERADOR_DE_RECURSOS);
                break;
            case 2:
                break;
        }
        Menu.Division();
        
    }

    
    public void Turno() throws Exception{
        while (fase < 6) {
            jugarTurno(jugadores[1]);
            jugarTurno(jugadores[0]);
            Menu.Dashboard(jugadores);
            DanielNavarros_World.fase++;
        }
    }


    public static void main(String args[]) {
        
        
        while(true){
            try {
                DanielNavarros_World jueguillo= DanielNavarros_World.getJuego();
                jueguillo.Turno();
                break;
            }catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
