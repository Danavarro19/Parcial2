package Client;

import Abstract.AbstractFactory;
import Abstract.Edificacion;
import Client.Raza.Raza;
import Concrete.Edifiacion.*;

import java.util.ArrayList;

import static Client.Factories.*;
import static Concrete.Edifiacion.TipoEdif.*;

public class Jugador {

    private String nombre;
    private Raza raza;
    private AbstractFactory abstractFactory;
    private CentroMando centroMando;

    public Jugador(String nombre, Raza raza) {

        this.nombre = nombre;
        this.raza = raza;
    }


    public String getNombre() {
        return nombre;
    }


    public void iniciarPartida(){

        abstractFactory = FactoryProducer.getFactory(EDIFICACION);
        centroMando = (CentroMando) abstractFactory.getEdificacion
                (CENTRO_DE_MANDO,this.raza);
        centroMando.makeDisponible();
    }


    public Edificacion construir(TipoEdif tipoEdif) throws Exception{

        Edificacion edificacion;
        abstractFactory = FactoryProducer.getFactory(EDIFICACION);

        if(centroMando.verificarRecursos(abstractFactory.getEdificacion(tipoEdif,this.raza))){
            edificacion=abstractFactory.getEdificacion(tipoEdif,this.raza);
            centroMando.addEdificacion(edificacion);
            centroMando.pagar(edificacion.getCosto());
            return edificacion;

        }else {
            Exception e = new Exception("recursos insuficientes");
            throw e;
        }
    }


    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " Raza: "+ raza.getNombre()+
                "Centro de mando: "+centroMando;
    }
}
