/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Abstract.Edificacion;
import Abstract.Elemento;
import static Abstract.Recurso.*;
import static Client.Factories.EDIFICACION;
import Concrete.Edifiacion.GeneradorRecurso;
import Concrete.Edifiacion.RecolectorRecurso;
import Concrete.Edifiacion.TipoEdif;
import java.util.ArrayList;

/**
 *
 * @author intel
 */
public class Territorio {
    
    private final Jugador jugador;
    public static ArrayList<RecolectorRecurso> recolectorRecurso1= new ArrayList<>();
    public static ArrayList<RecolectorRecurso> recolectorRecurso2= new ArrayList<>();
    public static ArrayList<GeneradorRecurso> generadores= new ArrayList<>();
    public static ArrayList<RecolectorRecurso> cuarteles= new ArrayList<>();
    
    public Territorio(Jugador jugador){ this.jugador=jugador;}
    
    public Edificacion construir(TipoEdif tipoEdif,int opc) throws Exception{
        Edificacion edificacion= FactoryProducer.getFactory(EDIFICACION).
                getEdificacion(tipoEdif, jugador.getRaza());
        jugador.getCentroDeMando().pagar(edificacion.getCosto());
        jugador.getCentroDeMando().addEdificacion(edificacion);
        System.out.println("Edificacion agregada en centro de mando de jugador "
                +jugador.getNombre());
        agregarEdificacion(edificacion,tipoEdif, opc);
        return edificacion;
    }
    
    public void agregarEdificacion(Edificacion edificacion, TipoEdif tipoEdif, int opc){
        switch (tipoEdif){
        
            case GENERADOR_DE_RECURSOS:
                
                GeneradorRecurso generador = (GeneradorRecurso) edificacion;
                generadores.add(generador);
                break;
                
            case REOLECTOR_DE_RECURSOS:
                
                RecolectorRecurso recolector= (RecolectorRecurso) edificacion;
                if(opc==2){
                    System.out.println("Recolector recurso 1 agregado"
                            + "en jugador "+jugador.getNombre());
                    recolectorRecurso1.add(recolector);
                }
                else if(opc==3){
                    System.out.println("Recolector recurso 2"
                            + "en jugador "+jugador.getNombre());
                    recolectorRecurso2.add(recolector);
                }
                break;    
        }
    }
    
    
    public static boolean verificarDisponibilidad(Elemento elemento){
        return (elemento.getTiempo_espera()+elemento.getFASE_CREACION()<=
                    DanielNavarros_World.getFase());
    }
    
    
    public int generarRecursos(){
        int cosecha=0;
        for (GeneradorRecurso generador: generadores){ 
            if(verificarDisponibilidad(generador))
                cosecha+=generador.generarRecurso();
        }
        System.out.println("Cosecha = "+cosecha);
        return cosecha;
    }
    
    public int generarRecursos(Enum tipo, int opc){
        
        //for(){}
        
        return 0;
    }
    
    
    
}
