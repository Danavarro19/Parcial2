package Concrete.Edifiacion;

import Abstract.*;
import Client.Raza.Nombre;
import Client.Raza.Raza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Abstract.Recurso.*;

public class CentroMando extends Edificacion {


    private ArrayList<Edificacion> edificaciones;
    private int nivel;
    private Map<Recurso, Integer> inventarioRecursos;

    public CentroMando(Raza raza) {
        super(raza);
        this.edificaciones=new ArrayList<>();
        nivel=0;
        inventarioRecursos = new HashMap<>();
        inventarioRecursos.put(RECURSO1,10);
        inventarioRecursos.put(RECURSO2,5);
        inventarioRecursos.put(RECURSO3,3);
    }

    public ArrayList<Edificacion> getEdificaciones() {
        return edificaciones;
    }

    public int getNivel() {
        return nivel;
    }

    public Map<Recurso, Integer> getInventarioRecursos() {
        return inventarioRecursos;
    }

    public void setEdificaciones(ArrayList<Edificacion> edificaciones) {
        this.edificaciones = edificaciones;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setInventarioRecursos(Map<Recurso, Integer> inventarioRecursos) {
        this.inventarioRecursos = inventarioRecursos;
    }

    public boolean verificarRecursos(Elemento elemento){

        Map<Recurso,Integer> costo = elemento.getCosto();

        for (Map.Entry<Recurso,Integer> e: inventarioRecursos.entrySet()){

            if(costo.containsKey(e.getKey())){
                if(e.getValue() < costo.get(e.getKey())){
                    return false;
                }
            }
        }
        return true;
    }

    public void pagar(Map<Recurso, Integer> costo){

        for (Map.Entry<Recurso,Integer> e: costo.entrySet()){
            if(inventarioRecursos.containsKey(e.getKey())){
                inventarioRecursos.put(e.getKey(),e.getValue()-costo.get(e.getKey()));
            }
        }

    }

    public void addEdificacion(Edificacion edificacion){
        edificaciones.add(edificacion);

    }

    @Override
    public String toString() {
        return "//\nNivel: " + nivel +
                "\nEdificaciones: " + edificaciones.size() +
                "\nrecurso1:" + inventarioRecursos.get(RECURSO1)+
                "\nrecurso2:" + inventarioRecursos.get(RECURSO2)+
                "\nrecurso3:" + inventarioRecursos.get(RECURSO3);
    }
}
