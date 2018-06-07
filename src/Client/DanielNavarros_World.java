package Client;

import Client.Raza.*;
import java.util.Scanner;
import static Concrete.Edifiacion.TipoEdif.*;


public class DanielNavarros_World {

    private static int fase;
    private static DanielNavarros_World juego;
    private static Jugador[] jugadores;


    private DanielNavarros_World(){
        jugadores = new Jugador[]{crearJugador(), crearJugador()};
        jugadores[0].iniciarPartida();
        jugadores[1].iniciarPartida();
    }


    public static synchronized DanielNavarros_World getJuego(){

        if (juego==null){
            juego = new DanielNavarros_World();
        }

        return juego;
    }


    public static int getFase() {
        return fase;
    }


    private Jugador crearJugador(){

        System.out.print("Ingrese su nombre de jugador: ");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();

        return new Jugador(nombre, seleccionRaza());
    }


    public Raza seleccionRaza(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una raza:\n" +
                "1-Raza1\n" +
                "2-Raza2\n" +
                "3-Raza3");
        int opcion = scanner.nextInt();

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


    public void verDetalleJugadores(){

        for (Jugador j: jugadores){
            System.out.println("Jugador "+j.toString());
        }
    }

    public void dashboard(){

        System.out.println(jugadores[0].toString());
        System.out.println(jugadores[1].toString());

    }


    public void jugarTurno(Jugador jugador){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Fase "+this.fase);
        System.out.println("Turno " + jugador.getNombre());
        System.out.println(jugador.getNombre()+" presione cualquier tecla " +
                "y luego enter");
        scanner.next();
        try{
        jugador.construir(GENERADOR_DE_RECURSOS);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }


    public void Turno(){

        while (fase < 6) {
            this.fase++;
            jugarTurno(jugadores[1]);
            jugarTurno(jugadores[0]);
            juego.verDetalleJugadores();

        }
    }


    public static void main(String args[]){

        DanielNavarros_World juego= DanielNavarros_World.getJuego();
        juego.Turno();
     }
}
