/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.util.Scanner;

/**
 *
 * @author intel
 */
public class Menu {
    
    private static Menu menu;
    
    private Menu(){}
    
    public Menu getInstance(){
        if(menu==null){
            menu= new Menu();
        }
        return menu;
    }
    
    public static void Division(){
        System.out.println("\n****************************************\n");
    }
    
    public static String getNombre(){
        if(DanielNavarros_World.getJugadores()[0]==null)
            System.out.println("Jugador 1");
        else
            System.out.println("Jugador 2");
        
        System.out.print("Ingrese su nombre de jugador: ");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        return nombre;
    }
    
    public static int menuRaza() throws Exception{
        int opcion;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una raza:\n" +
                "1-Raza1\n" +
                "2-Raza2\n" +
                "3-Raza3");
        opcion=scanner.nextInt();
        if(opcion >=1 && opcion <=3)
            return opcion;
        else{
            Exception e= new Exception("Opcion no valida");
            throw e;
        }
    }
    
    public static void Dashboard(Jugador[] jugadores){
        System.out.println(jugadores[0].toString());
        System.out.println(jugadores[1].toString());
    }
    
    public static int menuTurno(Jugador jugador) throws Exception{
        System.out.println("Turno "+jugador.getNombre()+
                "\nFase "+DanielNavarros_World.getFase());
        
        int opcion;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Que deseas hacer en el reino "+jugador.getRaza()+
                "\n1-Construir"
                        + "\n2-Ir a la guerra");
        opcion=scanner.nextInt();
        if(opcion >=1 && opcion <=2)
            return opcion;
        else{
                Exception e=new Exception("Opcion no valida");
                throw e;
        } 
    }
    
}
