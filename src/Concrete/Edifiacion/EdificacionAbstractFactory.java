package Concrete.Edifiacion;

import Abstract.Edificacion;
import Abstract.AbstractFactory;
import Abstract.Milicia;
import Abstract.Vehiculo;
import Client.Raza.Nombre;
import Client.Raza.Raza;
import Concrete.Milicia.TipoMilicia;
import Concrete.Vehiculo.TipoVehiculo;

public class EdificacionAbstractFactory implements AbstractFactory {

    @Override
    public Milicia getMilicia(TipoMilicia milicia,Raza raza) { return null; }

    @Override
    public Vehiculo getVehiculo(TipoVehiculo tipoVehiculo, Raza raza) { return null; }

    @Override
    public Edificacion getEdificacion(TipoEdif edif, Raza raza) {
        switch (edif){

            case CENTRO_DE_MANDO:
                return new CentroMando(raza);

            case GENERADOR_DE_RECURSOS:
                return new GeneradorRecurso(raza, edif);

            case REOLECTOR_DE_RECURSOS:
                return new RecolectorRecurso(raza, edif);
        }
        return null;
    }
}
