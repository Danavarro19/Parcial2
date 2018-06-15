/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concrete.Edifiacion;

import Abstract.Edificacion;
import Abstract.Elemento;
import Abstract.Recurso;
import static Abstract.Recurso.CALIZA;
import static Abstract.Recurso.METALES;
import Client.Raza.Raza;
import Client.Territorio;
import Concrete.Milicia.Escuadron;
import Concrete.Vehiculo.Aereo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author intel
 */
public class BaseAerea extends Edificacion implements ManejadordeRecursos{

    private ArrayList<Aereo> aviones=new ArrayList<>();

    public ArrayList<Aereo> getAviones() {return aviones;}
    
    
    
    public BaseAerea(Raza raza, TipoEdif tipo) {
        super(raza, tipo);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(CALIZA,super.getRaza().getRazaRecoleccion()*5);
        costo.put(METALES,super.getRaza().getRazaRecoleccion()*6);
        super.setCosto(costo);
        super.setTiempo_espera(2);
        super.setVida(6);
    }

    
    @Override
    public Elemento generarRecurso(Elemento avion) throws Exception {
        if(this.aviones.size()<10)
           this.aviones.add((Aereo)avion);
       else{
           Exception e= new Exception("Base aerea llena de aviones");
           throw e;
       }
       return avion;
    }

    @Override
    public int getCantRecurso() {
        int cantidad=0;
        for(Aereo a:aviones){
            if(Territorio.verificarDisponibilidad(a))
                cantidad++;
        }
        return cantidad;
    }
    
    

    @Override
    public int generarRecurso() {return 0;}

    
}

    

