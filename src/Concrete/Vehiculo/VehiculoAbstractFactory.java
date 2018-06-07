package Concrete.Vehiculo;

import Abstract.Edificacion;
import Abstract.AbstractFactory;
import Abstract.Milicia;
import Abstract.Vehiculo;
import Client.Raza.Raza;
import Concrete.Edifiacion.TipoEdif;
import Concrete.Milicia.TipoMilicia;

public class VehiculoAbstractFactory implements AbstractFactory {
    @Override
    public Milicia getMilicia(TipoMilicia milicia, Raza raza) {
        return null;
    }

    @Override
    public Vehiculo getVehiculo(TipoVehiculo vehiculo, Raza raza) {

        switch (vehiculo){

            case AEREO:
                return new Aereo(raza);
            case TERRESTRE:
                return new Terrestre(raza);
        }
        return null;
    }

    @Override
    public Edificacion getEdificacion(TipoEdif edif, Raza raza) {
        return null;
    }
}
