/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import static Abstract.Recurso.*;
import static Client.Raza.Nombre.*;
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
        System.out.println("****************************************"
                + "**************************************");
    }

    public static void Division2(){
        System.out.println("////////////////////////////////"
                + "///////////////////////////////");
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
                "1-"+VAQUEROS+" |" +
                "2-"+INDIOS+" | " +
                "3-"+ALIENS);
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
        Division2();
        System.out.println(jugadores[1].toString());
        Division2();
    }
    
    public static void Dashboard(Jugador jugador){
        System.out.println(jugador.toString());
        Division2();
    }
    
    public static int menuTurno(Jugador jugador) throws Exception{
        System.out.println("Turno "+jugador.getNombre()+
                "| Fase "+(int) DanielNavarros_World.getFase());
        
        int opcion;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Que deseas hacer en el reino "+jugador.getRaza().getNombre()+
                "\n1-Construir"
                        + "\n2-Ir a la guerra"
                        + "'n3-Recolectar recursos");
        opcion=scanner.nextInt();
        if(opcion >=1 && opcion <=3)
            return opcion;
        else{
                Exception e=new Exception("Opcion no valida");
                throw e;
        } 
    }
    
    public static int menuConstruccion() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("1-Mina de "+METALES
                + "\n2-Recolector "+COMIDA
                + "\n3-Cantera de "+CALIZA
                + "\n4-Cuartel de Milicia"
                + "\n5-Fabrica de vehiculos");
        opcion=scanner.nextInt();
        if(opcion >=1 && opcion <=5)
            return opcion;
        else{
                Exception e=new Exception("Opcion no valida");
                throw e;
        } 
    }
     public static int menuGuerra() throws Exception{
         Scanner scanner = new Scanner(System.in);
         int opcion;
         System.out.println("1-Entrenar un espcialista"
                 + "\n2-Entrenar un escuadron"
                 + "\n3-Atacar");
         opcion = scanner.nextInt();
         
        if(opcion >=1 && opcion <=3)
            return opcion;
        else{
                Exception e=new Exception("Opcion no valida");
                throw e;
        }
     }
}
