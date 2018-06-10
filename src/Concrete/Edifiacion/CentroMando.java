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
        inventarioRecursos.put(RECURSO1,10);
        inventarioRecursos.put(RECURSO2,5);
        inventarioRecursos.put(RECURSO3,3);
    }

    public ArrayList<Edificacion> getEdificaciones() { return edificaciones; }

    public int getNivel() { return nivel; }

    public Map<Recurso, Integer> getInventarioRecursos() { return inventarioRecursos; }

    public void setEdificaciones(ArrayList<Edificacion> edificaciones) { this.edificaciones = edificaciones; }

    public void setNivel(int nivel) { this.nivel = nivel; }

    public void setInventarioRecursos(Map<Recurso, Integer> inventarioRecursos) { this.inventarioRecursos = inventarioRecursos; }


    public void pagar(Map<Recurso, Integer> costo) throws Exception{
        for (Map.Entry<Recurso,Integer> r: costo.entrySet()){
            if(inventarioRecursos.get(r.getKey())>=r.getValue()){
                inventarioRecursos.put(r.getKey(),r.getValue()-costo.get(r.getKey())); 
            }else{
                Exception e= new Exception("Recursos insuficientes");
                throw e;
            }
        }
    }

    
    public void addEdificacion(Edificacion edificacion){
        edificaciones.add(edificacion); 
    }

    
    @Override
    public String toString() {
        return "\nNivel: " + nivel +
                  "\nEdificaciones: " + edificaciones.size() +
                  "\nrecurso1:" + inventarioRecursos.get(RECURSO1)+
                  "\nrecurso2:" + inventarioRecursos.get(RECURSO2)+
                  "\nrecurso3:" + inventarioRecursos.get(RECURSO3);
        }
}
