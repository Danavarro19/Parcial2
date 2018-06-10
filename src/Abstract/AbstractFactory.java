package Abstract;

import Client.Raza.Raza;
import Concrete.Edifiacion.TipoEdif;
import Concrete.Milicia.TipoMilicia;
import Concrete.Vehiculo.TipoVehiculo;

public interface AbstractFactory {

    Milicia getMilicia(TipoMilicia milicia,Raza raza);
    Vehiculo getVehiculo(TipoVehiculo vehiculo,Raza raza);
    Edificacion getEdificacion(TipoEdif edif, Raza raza);

}
