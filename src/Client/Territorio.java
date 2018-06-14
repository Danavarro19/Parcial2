/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Abstract.Edificacion;
import Abstract.Elemento;
import Abstract.Recurso;
import static Abstract.Recurso.*;
import static Client.Factories.EDIFICACION;
import Concrete.Edifiacion.Cuartel;
import Concrete.Edifiacion.GeneradorRecurso;
import Concrete.Edifiacion.ManejadordeRecursos;
import Concrete.Edifiacion.RecolectorRecurso;
import Concrete.Edifiacion.TipoEdif;
import Concrete.Milicia.Especialista;
import static Concrete.Milicia.TipoMilicia.ESPECIALISTA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author intel
 */
public class Territorio {
    
    private final Jugador jugador;
    public  ArrayList<RecolectorRecurso> recolectorCaliza= new ArrayList<>();
    public ArrayList<RecolectorRecurso> recolectorComida= new ArrayList<>();
    public ArrayList<GeneradorRecurso> generadoresMetales= new ArrayList<>();
    public ArrayList<ManejadordeRecursos> cuarteles= new ArrayList<>();
    public Especialista especialista;
    
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
                generadoresMetales.add(generador.setRecurso(METALES));
                break;
                
            case RECOLECTOR_DE_RECURSOS:
                
                RecolectorRecurso recolector= (RecolectorRecurso) edificacion;
                if(opc==2){
                    System.out.println("Recolector "+COMIDA+"1 agregado"
                            + "en jugador "+jugador.getNombre());
                    recolectorCaliza.add(recolector.setRecurso(CALIZA));
                }
                else if(opc==3){
                    System.out.println("Cantera de "+CALIZA+""
                            + "en jugador "+jugador.getNombre());
                    recolectorComida.add(recolector.setRecurso(COMIDA));
                }
                break;    
            
            case CUARTEL:
                Cuartel cuartel= (Cuartel) edificacion;
                cuarteles.add(cuartel);
        }
    }
    
    
    public static boolean verificarDisponibilidad(Elemento elemento){
        return (elemento.getTiempo_espera()+elemento.getFASE_CREACION()<=
                    DanielNavarros_World.getFase());
    }
    
    
    public int generarRecursos(){
        int cosecha=0;
        for (GeneradorRecurso generador: generadoresMetales){ 
            if(verificarDisponibilidad(generador))
                cosecha+=generador.generarRecurso();
        }
        System.out.println("Cosecha = "+cosecha);
        return cosecha;
    }
    
    public void producirRecursos(ArrayList<RecolectorRecurso> recolectores){
        for(RecolectorRecurso recolector: recolectores){
            if(verificarDisponibilidad(recolector))
                recolector.generarRecurso();
        }
    }
    
    public void producir(){
        producirRecursos(recolectorCaliza);
        producirRecursos(recolectorComida); 
    }
    
    public int recolectarRecurso(ArrayList<RecolectorRecurso> recolectores){
        int cosecha=0;
        for (RecolectorRecurso recolector: recolectores){
            cosecha+=recolector.getCant();
        }
        System.out.println("Cosecha = "+cosecha);
        return cosecha;
    }
    
    public Map<Recurso, Integer> recolectar(){
        Map<Recurso, Integer> recoleccion = new HashMap<>();
        recoleccion.put(CALIZA,recolectarRecurso(recolectorCaliza));
        recoleccion.put(COMIDA,recolectarRecurso(recolectorComida));
        return recoleccion;
    }
    
    public Especialista getEspecialista(){
    //    if (!this.cuarteles.isEmpty())
      //      return this.cuarteles[0].generarRecurso(ESPECIALISTA);
        return null;
    }
    
    
    
    
}
