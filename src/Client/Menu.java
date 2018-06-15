/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Abstract.Elemento;
import static Abstract.Recurso.*;
import static Client.Raza.Nombre.*;
import Concrete.Edifiacion.BaseAerea;
import Concrete.Edifiacion.BaseTerrestre;
import Concrete.Edifiacion.Cuartel;
import Concrete.Edifiacion.ManejadordeRecursos;
import static Concrete.Milicia.TipoMilicia.ESCUADRON;
import java.util.ArrayList;
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
        System.out.println("*************************************************************"
                + "*****************************************************************");
    }

    public static void Division2(){
        System.out.println("-----------------------------------------------------------"
                + "----------------------------------------------------------------");
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
                        + "\n3-Recolectar recursos"
                        + "\n4-Pasar");
        opcion=scanner.nextInt();
        if(opcion >=1 && opcion <=4)
            return opcion;
        else{
                Exception e=new Exception("Opcion no valida");
                throw e;
        } 
    }
    
    public static int menuConstruccion() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("QUE QUIERES CONSTRUIR?"
                +"\n1-Mina de "+METALES
                + "\n2-Recolector "+COMIDA
                + "\n3-Cantera de "+CALIZA
                + "\n4-Cuartel de Milicia"
                + "\n5-Base Aerea"
                + "\n6-Base terrestre");
        
        opcion=scanner.nextInt();
        if(opcion >=1 && opcion <=6)
            return opcion;
        else{
                Exception e=new Exception("Opcion no valida");
                throw e;
        } 
    }
     public static int menuGuerra() throws Exception{
         Scanner scanner = new Scanner(System.in);
         int opcion;
         System.out.println("QUE ACCION DESEAS TOMAR?"
                 +"\n1-Entrenar un espcialista"
                 + "\n2-Entrenar un escuadron"
                 + "\n3-Preparar avion"
                 + "\n4-Preparar carro"
                 + "\n5-Atacar");
         opcion = scanner.nextInt();
         
        if(opcion >=1 && opcion <=5)
            return opcion;
        else{
                Exception e=new Exception("Opcion no valida");
                throw e;
        }
     }
     
     
     public static int menuAtacar(Territorio territorio) throws Exception{
         Scanner scanner = new Scanner(System.in);
         int opcion;
         System.out.println("CON QUIEN QUIERES ATACAR"
                 + "\n1-Especialista"
                 + "\n2-Tropa "+territorio.getTropasDisponibles()
                 + "\n3-Vehiculo terrestre "+territorio.getCarrosDisponibles()
                 + "\n4-Avion "+territorio.getAvionesDisponibles());
         opcion= scanner.nextInt();
         if (opcion>=1 && opcion <=4)
             return opcion;
         else{
             Exception e=new Exception("Opcion no valida");
             throw e;
         }
     } 
     
     
     public static int menuEscuadron(Territorio territorio) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int opcion;
        if(!territorio.getCuarteles().isEmpty()){
            System.out.println("SELECCIONA UN CUARTEL");
            for (int i =0; i<territorio.getCuarteles().size();i++){
                Cuartel cuartel = (Cuartel) territorio.getCuarteles().get(i);
                System.out.println("Cuartel "+(i+1)+", "+
                        "tropas "+cuartel.getTropas().size());
            }
             System.out.print("Cuartel: ");
            opcion=scanner.nextInt();
            if (opcion>=1 && opcion <=territorio.getCuarteles().size())
                 return opcion;
             else{
                 Exception e=new Exception("Opcion no valida");
                 throw e;
             }
        }else{
            throw new Exception("No hay cuarteles");
        }
     }
     
     public static int menuAvion(Territorio territorio) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int opcion;
        if(!territorio.getBasesAereas().isEmpty()){
            System.out.println("SELECCIONA UNA BASE AEREA");
            for (int i =0; i<territorio.getBasesAereas().size();i++){
                BaseAerea base = (BaseAerea) territorio.getBasesAereas().get(i);
                System.out.println("Base "+(i+1)+", "+
                        "Aviones "+base.getAviones().size());
            }
             System.out.print("Base: ");
            opcion=scanner.nextInt();
            if (opcion>=1 && opcion <=territorio.getBasesAereas().size())
                 return opcion;
             else{
                 Exception e=new Exception("Opcion no valida");
                 throw e;
             }
        }else{
            throw new Exception("No hay bases aereas");
        }
     }
     
     public static int menuCarro(Territorio territorio) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int opcion;
        if(!territorio.getBasesTerrestres().isEmpty()){
            System.out.println("SELECCIONA UNA BASE TERRESTRE");
            for (int i =0; i<territorio.getBasesTerrestres().size();i++){
                BaseTerrestre base = (BaseTerrestre) territorio.getBasesTerrestres().get(i);
                System.out.println("Base "+(i+1)+", "+
                        "Carros "+base.getCarros().size());
            }
             System.out.print("Base: ");
            opcion=scanner.nextInt();
            if (opcion>=1 && opcion <=territorio.getBasesTerrestres().size())
                 return opcion;
             else{
                 Exception e=new Exception("Opcion no valida");
                 throw e;
             }
        }else{
            throw new Exception("No hay bases terrestres");
        }
     }
     
     
}
