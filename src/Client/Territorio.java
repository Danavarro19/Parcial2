/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Abstract.Edificacion;
import Abstract.Elemento;
import Abstract.Guerra.Atacante;
import Abstract.Recurso;
import static Abstract.Recurso.*;
import static Client.Factories.EDIFICACION;
import static Client.Factories.MILICIA;
import static Client.Factories.VEHICULO;
import Concrete.Edifiacion.BaseAerea;
import Concrete.Edifiacion.BaseTerrestre;
import Concrete.Edifiacion.Cuartel;
import Concrete.Edifiacion.GeneradorRecurso;
import Concrete.Edifiacion.ManejadordeRecursos;
import Concrete.Edifiacion.RecolectorRecurso;
import Concrete.Edifiacion.TipoEdif;
import Concrete.Milicia.Escuadron;
import Concrete.Milicia.Especialista;
import static Concrete.Milicia.TipoMilicia.ESCUADRON;
import static Concrete.Milicia.TipoMilicia.ESPECIALISTA;
import Concrete.Vehiculo.Aereo;
import Concrete.Vehiculo.Terrestre;
import static Concrete.Vehiculo.TipoVehiculo.AEREO;
import static Concrete.Vehiculo.TipoVehiculo.TERRESTRE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author intel
 */
public class Territorio {
    
    private final Jugador jugador;
    private  ArrayList<RecolectorRecurso> recolectorCaliza= new ArrayList<>();
    private ArrayList<RecolectorRecurso> recolectorComida= new ArrayList<>();
    private ArrayList<GeneradorRecurso> generadoresMetales= new ArrayList<>();
    private ArrayList<ManejadordeRecursos> cuarteles= new ArrayList<>();
    private ArrayList<ManejadordeRecursos> basesAereas= new ArrayList<>();
    private ArrayList<ManejadordeRecursos> basesTerrestres= new ArrayList<>();
    private ArrayList<Atacante> atacantes=new ArrayList<>();
    private Especialista especialista;
    

    public Jugador getJugador() {return jugador;}

    public ArrayList<RecolectorRecurso> getRecolectorCaliza() {return recolectorCaliza;}

    public ArrayList<RecolectorRecurso> getRecolectorComida() {return recolectorComida;}

    public ArrayList<GeneradorRecurso> getGeneradoresMetales() {return generadoresMetales;}

    public ArrayList<ManejadordeRecursos> getCuarteles() {return cuarteles;}
    
    public ArrayList<ManejadordeRecursos> getBasesAereas() {return basesAereas;}
    
    public ArrayList<ManejadordeRecursos> getBasesTerrestres() {return basesTerrestres;}

    public Especialista getEspecialista() {return especialista;}

    public ArrayList<Atacante> getAtacantes() {return atacantes;}
    
    
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
                    recolectorComida.add(recolector.setRecurso(COMIDA));
                }
                else if(opc==3){
                    System.out.println("Cantera de "+CALIZA+" "
                            + "en jugador "+jugador.getNombre());
                    recolectorCaliza.add(recolector.setRecurso(CALIZA));
                }
                break;    
            
            case CUARTEL:
                Cuartel cuartel= (Cuartel) edificacion;
                cuarteles.add(cuartel);
                break;
               
            case BASEAEREA:
                BaseAerea base =(BaseAerea) edificacion;
                basesAereas.add(base);
                break;
                
            case BASETERRESTRE:
                BaseTerrestre base1 =(BaseTerrestre) edificacion;
                basesTerrestres.add(base1);
                break;
                
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
    
    public void prepararEspecialista() throws Exception{
        if (this.especialista==null){
            Especialista espec= (Especialista) FactoryProducer.getFactory(MILICIA).getMilicia(ESPECIALISTA, 
                    this.jugador.getRaza());
            jugador.getCentroDeMando().pagar(espec.getCosto());
            this.especialista=espec;
        }else
            throw new Exception("Ya hay un especialista");
    }
    
    public void entrenarTopa(int cuartel) throws Exception{
        Escuadron tropa= (Escuadron) FactoryProducer.getFactory(MILICIA).
                getMilicia(ESCUADRON, jugador.getRaza());
        jugador.getCentroDeMando().pagar(tropa.getCosto());
        cuarteles.get(cuartel).generarRecurso(tropa);
    }
    
    public void preparaAvion(int base) throws Exception{
        Aereo avion= (Aereo) FactoryProducer.getFactory(VEHICULO).
                getVehiculo(AEREO, jugador.getRaza());
        jugador.getCentroDeMando().pagar(avion.getCosto());
        basesAereas.get(base).generarRecurso(avion);
    }
    public void preparaCarro(int base) throws Exception{
        Terrestre carro= (Terrestre) FactoryProducer.getFactory(VEHICULO).
                getVehiculo(TERRESTRE, jugador.getRaza());
        jugador.getCentroDeMando().pagar(carro.getCosto());
        basesTerrestres.get(base).generarRecurso(carro);
    }
    
    public int getTropasDisponibles(){
        int cantidad=0;
        for(ManejadordeRecursos m:cuarteles){
            Cuartel n=(Cuartel) m;
            cantidad+=n.getCantRecurso();
        }
        return cantidad;
    }
    
    
    public int getAvionesDisponibles(){
        int cantidad=0;
        for(ManejadordeRecursos m:basesAereas){
            BaseAerea n=(BaseAerea) m;
            cantidad+=n.getCantRecurso();
        }
        return cantidad;
    }
    
    
    public int getCarrosDisponibles(){
        int cantidad=0;
        for(ManejadordeRecursos m:basesTerrestres){
            BaseTerrestre n=(BaseTerrestre) m;
            cantidad+=n.getCantRecurso();
        }
        return cantidad;
    }
    
    public void atacar() throws Exception{
        for(Atacante a:atacantes){
            a.atacar();
        }
    }

    @Override
    public String toString() {
        String espec;
        if(especialista!=null)
             espec=" si";
        else
            espec=" no";
        return "Canteras de Caliza " + recolectorCaliza.size() +
                " | Recolectores de Comida " + recolectorComida.size() + 
                " | Minas de Metales " + generadoresMetales.size() + 
                " | Cuarteles " + cuarteles.size()+
                " | BasesAereas "+basesAereas.size()+
                " | BasesTerrestres "+basesTerrestres.size()+
                " | Especialista "+espec;
        
    }

    
    
    
    
    
}
