package Concrete.Edifiacion;

import Abstract.*;
import Client.Raza.Raza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Abstract.Recurso.*;
import Client.Jugador;
import Client.Territorio;
import static Concrete.Edifiacion.TipoEdif.CENTRO_DE_MANDO;

public class CentroMando extends Edificacion {


    private ArrayList<Edificacion> edificaciones;
    private int nivel;
    private Map<Recurso, Integer> inventarioRecursos;

    public CentroMando(Raza raza) {
        super(raza, CENTRO_DE_MANDO);
        this.edificaciones=new ArrayList<>();
        nivel=0;
        inventarioRecursos = new HashMap<>();
        inventarioRecursos.put(CALIZA,super.getRaza().getRazaVelocidad()*10);
        inventarioRecursos.put(COMIDA,super.getRaza().getRazaFuerza()*12);
        inventarioRecursos.put(METALES,super.getRaza().getRazaRecoleccion()*6);
        super.setVida(12);
    
    }

    public ArrayList<Edificacion> getEdificaciones() { return edificaciones; }

    public int getNivel() { return nivel; }

    public Map<Recurso, Integer> getInventarioRecursos() { return inventarioRecursos; }

    public void setEdificaciones(ArrayList<Edificacion> edificaciones) { this.edificaciones = edificaciones; }

    public void setNivel(int nivel) { this.nivel = nivel; }

    public void setInventarioRecursos(Map<Recurso, Integer> inventarioRecursos) { this.inventarioRecursos = inventarioRecursos; }

    public void addEdificacion(Edificacion edificacion){edificaciones.add(edificacion);}
    
    public void recibir(Recurso recurso, int n){
        inventarioRecursos.put(recurso, inventarioRecursos.get(recurso)+n);
    }
    
    public void recibir(Map<Recurso, Integer> pago){
        for (Map.Entry<Recurso,Integer> r: pago.entrySet()){
        
            inventarioRecursos.put(r.getKey(), 
                    inventarioRecursos.get(r.getKey())+pago.get(r.getKey()));
        }
    }
    
    public boolean verificarRecursos(Map<Recurso, Integer> costo){
        for (Map.Entry<Recurso,Integer> r: costo.entrySet()){
                if(inventarioRecursos.get(r.getKey())<r.getValue()){
                    return false;
                }
        }
        return true;
        
    }
    
    
    public void pagar(Map<Recurso, Integer> costo) throws Exception{
        if(verificarRecursos(costo)){
            for (Map.Entry<Recurso,Integer> r: costo.entrySet()){
                inventarioRecursos.put(r.getKey(),
                        inventarioRecursos.get(r.getKey())-costo.get(r.getKey())); 
            }
        }else{
            Exception e= new Exception("Recursos insuficientes");
            throw e;
        }
    }
    
    public Edificacion getVictima(){
        for (Edificacion e: edificaciones){
            if(Territorio.verificarDisponibilidad(e))
                return e;
        }
        return null;
    }
    

    
    
    @Override
    public String toString() {
        return "Nivel: " + nivel +
                  "| Edificaciones: " + edificaciones.size() +
                  "| "+CALIZA +" "+ inventarioRecursos.get(CALIZA)+
                  "| "+COMIDA+" "+ inventarioRecursos.get(COMIDA)+
                  "| "+METALES+" " + inventarioRecursos.get(METALES);
        }
}
