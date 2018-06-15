package Concrete.Milicia;

import Abstract.Elemento;
import Abstract.Milicia;
import Abstract.Recurso;
import static Abstract.Recurso.*;
import Client.Raza.Nombre;
import Client.Raza.Raza;
import java.util.HashMap;
import java.util.Map;

public class Escuadron extends Milicia {

    public Escuadron(Raza raza) {
        super(raza);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(COMIDA,super.getRaza().getRazaRecoleccion()*4);
        costo.put(METALES,super.getRaza().getRazaRecoleccion()*5);
        super.setCosto(costo);
        super.setTiempo_espera(2);
        System.out.println("tropa creada");
    

    }
}
