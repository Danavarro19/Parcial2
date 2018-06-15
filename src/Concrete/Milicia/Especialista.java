package Concrete.Milicia;

import Abstract.Guerra.Atacante;
import Abstract.Guerra.Victima;
import Abstract.Milicia;
import Abstract.Recurso;
import static Abstract.Recurso.*;
import Client.Raza.Raza;
import java.util.HashMap;
import java.util.Map;

public class Especialista extends Milicia implements Atacante, Victima{
    
    private Victima objetivo;
    
    public Especialista(Raza raza) {
        super(raza);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(METALES,super.getRaza().getRazaRecoleccion()*2);
        costo.put(COMIDA,super.getRaza().getRazaRecoleccion()*1);
        super.setCosto(costo);
        super.setTiempo_espera(3);
        super.setDanio_ataque(4);
        super.setVida(5);
    }

}
