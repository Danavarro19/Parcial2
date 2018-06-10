package Concrete.Edifiacion;

import Abstract.Edificacion;
import Abstract.Elemento;
import Client.Raza.Nombre;
import Client.Raza.Raza;

public class RecolectorRecurso extends  Edificacion {

    protected RecolectorRecurso(Raza raza, TipoEdif tipo) {
        super(raza, tipo);
    }
}