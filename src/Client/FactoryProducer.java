package Client;

import Abstract.AbstractFactory;
import Concrete.Edifiacion.EdificacionAbstractFactory;
import Concrete.Milicia.MiliciaAbstractFactory;
import Concrete.Vehiculo.VehiculoAbstractFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(Factories factories){

        switch (factories){

            case MILICIA:
                return new MiliciaAbstractFactory();
            case VEHICULO:
                return new VehiculoAbstractFactory();
            case EDIFICACION:
                return new EdificacionAbstractFactory();
        }
        return null;
    }
}
