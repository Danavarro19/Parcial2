package Client;

import Abstract.AbstractFactory;
import Abstract.Edificacion;
import Abstract.Recurso;
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
        this.territorio=new Territorio(this);
    }

    public String getNombre() { return nombre; }

    public Raza getRaza() { return raza; }

    public Territorio getTerritorio() { return territorio; }

    public CentroMando getCentroDeMando(){ return this.centroMando;}
    
    public void iniciarPartida(){
        abstractFactory = FactoryProducer.getFactory(EDIFICACION);
        centroMando = (CentroMando) abstractFactory.getEdificacion
                (CENTRO_DE_MANDO,this.raza);
        centroMando.makeDisponible();
    }
    
    
    @Override
    public String toString() {
        return  raza.getNombre()+
                "\nCentro de mando: |"+centroMando+
                "\nTerritorio: |"+territorio;
    }
}
