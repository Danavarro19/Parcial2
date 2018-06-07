package Concrete.Edifiacion;

import Abstract.Edificacion;
import Abstract.Elemento;
import Abstract.Recurso;
import Client.Raza.Nombre;
import Client.Raza.Raza;

import java.util.HashMap;
import java.util.Map;

import static Abstract.Recurso.RECURSO1;
import static Abstract.Recurso.RECURSO3;

public class GeneradorRecurso extends Edificacion {

    protected GeneradorRecurso(Raza raza) {
        super(raza);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(RECURSO1,10);
        costo.put(RECURSO3,3);
        super.setCosto(costo);
    }
}
