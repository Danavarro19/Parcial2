package Client;

import Abstract.AbstractFactory;
import Abstract.Edificacion;
import Client.Raza.Raza;
import Concrete.Edifiacion.*;
import static Client.Factories.*;
import Client.Raza.Nombre;
import static Concrete.Edifiacion.TipoEdif.*;

public class Jugador {

    private final String nombre;
    private final Raza raza;
    private final Territorio territorio;
    private AbstractFactory abstractFactory;
    private CentroMando centroMando;

   
    public Jugador(String nombre, Raza raza) {
        this.nombre = nombre;
        this.raza = raza;
        this.territorio=new Territorio();
    }


    public String getNombre() { return nombre; }

    public Nombre getRaza() { return raza.getNombre(); }

    
    public void iniciarPartida(){
        abstractFactory = FactoryProducer.getFactory(EDIFICACION);
        centroMando = (CentroMando) abstractFactory.getEdificacion
                (CENTRO_DE_MANDO,this.raza);
        centroMando.makeDisponible();
    }


    public Edificacion construir(TipoEdif tipoEdif) throws Exception{
        Edificacion edificacion;
        abstractFactory = FactoryProducer.getFactory(EDIFICACION);
        edificacion=abstractFactory.getEdificacion(tipoEdif,this.raza);
        centroMando.pagar(edificacion.getCosto());
        centroMando.addEdificacion(edificacion);
        return edificacion;
    }


    @Override
    public String toString() {
        return "Jugador: " + nombre +
                "// Raza: "+ raza.getNombre()+
                "\nCentro de mando: "+centroMando+
                "\n********************************";
    }
}
