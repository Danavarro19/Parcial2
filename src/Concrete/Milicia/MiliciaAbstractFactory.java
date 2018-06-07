package Concrete.Milicia;

import Abstract.Edificacion;
import Abstract.AbstractFactory;
import Abstract.Milicia;
import Abstract.Vehiculo;
import Client.Raza.Nombre;
import Client.Raza.Raza;
import Concrete.Edifiacion.TipoEdif;
import Concrete.Vehiculo.TipoVehiculo;

public class MiliciaAbstractFactory implements AbstractFactory {


    @Override
    public Milicia getMilicia(TipoMilicia milicia, Raza raza) {

        switch (milicia){

            case ESCUADRON:
                return new Escuadron(raza);

            case ESPECIAISTA:
                return new Especialista(raza);
        }

        return null;
    }



    @Override
    public Vehiculo getVehiculo(TipoVehiculo tipoVehiculo, Raza raza) {
        return null;
    }

    @Override
    public Edificacion getEdificacion(TipoEdif edif, Raza raza) {
        return null;
    }
}
