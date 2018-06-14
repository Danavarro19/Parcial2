package Concrete.Edifiacion;

import Abstract.*;
import Client.Raza.Raza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Abstract.Recurso.*;
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
        inventarioRecursos.put(CALIZA,1000);
        inventarioRecursos.put(COMIDA,500);
        inventarioRecursos.put(METALES,300);
    }

    public ArrayList<Edificacion> getEdificaciones() { return edificaciones; }

    public int getNivel() { return nivel; }

    public Map<Recurso, Integer> getInventarioRecursos() { return inventarioRecursos; }

    public void setEdificaciones(ArrayList<Edificacion> edificaciones) { this.edificaciones = edificaciones; }

    public void setNivel(int nivel) { this.nivel = nivel; }

    public void setInventarioRecursos(Map<Recurso, Integer> inventarioRecursos) { this.inventarioRecursos = inventarioRecursos; }

    public void addEdificacion(Edificacion edificacion){
        
        edificaciones.add(edificacion); 
    }
    
    public void recibir(Recurso recurso, int n){
        inventarioRecursos.put(recurso, inventarioRecursos.get(recurso)+n);
    }
    
    public void pagar(Map<Recurso, Integer> costo) throws Exception{
        for (Map.Entry<Recurso,Integer> r: costo.entrySet()){
            if(inventarioRecursos.get(r.getKey())>=r.getValue()){
                inventarioRecursos.put(r.getKey(),
                        inventarioRecursos.get(r.getKey())-costo.get(r.getKey())); 
            }else{
                Exception e= new Exception("Recursos insuficientes");
                throw e;
            }
        }
    }

    
    
    @Override
    public String toString() {
        return "\nNivel: " + nivel +
                  "| Edificaciones: " + edificaciones.size() +
                  "| recurso1:" + inventarioRecursos.get(CALIZA)+
                  "| recurso2:" + inventarioRecursos.get(COMIDA)+
                  "| recurso3:" + inventarioRecursos.get(METALES);
        }
}
