package Concrete.Vehiculo;

import Abstract.Recurso;
import static Abstract.Recurso.COMIDA;
import static Abstract.Recurso.METALES;
import Abstract.Vehiculo;
import Client.Raza.Raza;
import java.util.HashMap;
import java.util.Map;

public class Aereo extends Vehiculo{

    public Aereo(Raza raza) {
        super(raza);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(COMIDA,super.getRaza().getRazaRecoleccion()*4);
        costo.put(METALES,super.getRaza().getRazaRecoleccion()*5);
        super.setCosto(costo);
        super.setTiempo_espera(3);
       
    }
}
