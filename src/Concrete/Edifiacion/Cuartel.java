/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concrete.Edifiacion;

import Abstract.Edificacion;
import Abstract.Elemento;
import static Client.Factories.EDIFICACION;
import static Client.Factories.MILICIA;
import Client.FactoryProducer;
import Client.Raza.Raza;
import static Concrete.Edifiacion.TipoEdif.CUARTEL;
import Concrete.Milicia.Escuadron;
import Concrete.Milicia.Especialista;
import Concrete.Milicia.MiliciaAbstractFactory;
import Concrete.Milicia.TipoMilicia;
import static Concrete.Milicia.TipoMilicia.*;
import java.util.ArrayList;

/**
 *
 * @author intel
 */
public class Cuartel extends Edificacion implements ManejadordeRecursos {

    private Especialista especialista;
    private ArrayList<Escuadron> tropas;
    
    public Cuartel(Raza raza, TipoEdif tipo) {
        super(raza, tipo);
    }

    
    @Override
    public Elemento generarRecurso(Enum Recurso) {
       TipoMilicia tipo= (TipoMilicia) Recurso;
        switch(tipo){
           
           case ESPECIALISTA:
               if(especialista==null)
                    return  FactoryProducer.getFactory(MILICIA).
                            getMilicia(ESPECIALISTA,super.getRaza());
           
           case ESCUADRON:
               this.tropas.add((Escuadron)FactoryProducer.getFactory(MILICIA).
                            getMilicia(ESCUADRON,super.getRaza()));
           
               return null;
       }
      return null;  
    }

    @Override
    public int generarRecurso() {return 0;}
    
}
