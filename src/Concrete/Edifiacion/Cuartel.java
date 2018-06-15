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
import static Client.Factories.EDIFICACION;
import static Client.Factories.MILICIA;
import Client.FactoryProducer;
import Client.Raza.Raza;
import Client.Territorio;
import static Concrete.Edifiacion.TipoEdif.CUARTEL;
import Concrete.Milicia.Escuadron;
import Concrete.Milicia.Especialista;
import Concrete.Milicia.MiliciaAbstractFactory;
import Concrete.Milicia.TipoMilicia;
import static Concrete.Milicia.TipoMilicia.*;
import Concrete.Vehiculo.Aereo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author intel
 */
public class Cuartel extends Edificacion implements ManejadordeRecursos {

    private ArrayList<Escuadron> tropas=new ArrayList<>();

    public ArrayList<Escuadron> getTropas() {return tropas;}
    
    
    
    public Cuartel(Raza raza, TipoEdif tipo) {
        super(raza, tipo);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(CALIZA,super.getRaza().getRazaRecoleccion()*5);
        costo.put(METALES,super.getRaza().getRazaRecoleccion()*6);
        super.setCosto(costo);
        super.setTiempo_espera(2);
        super.setVida(4);
    
    }

    
    @Override
    public Elemento generarRecurso(Elemento escuadron) throws Exception {
        if(this.tropas.size()<10)
           this.tropas.add((Escuadron)escuadron);
       else{
           Exception e= new Exception("Cuartel lleno de tropas");
           throw e;
       }
       return escuadron;
    }
    
    @Override
    public int getCantRecurso() {
        int cantidad=0;
        for(Escuadron a:tropas){
            if(Territorio.verificarDisponibilidad(a))
                cantidad++;
        }
        return cantidad;
    }
    

    @Override
    public int generarRecurso() {return 0;}

    
}
