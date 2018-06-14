package Concrete.Edifiacion;

import Abstract.Edificacion;
import Abstract.Elemento;
import Abstract.Recurso;
import Client.Raza.Nombre;
import Client.Raza.Raza;
import java.util.HashMap;
import java.util.Map;
import static Abstract.Recurso.CALIZA;
import static Abstract.Recurso.METALES;

public class RecolectorRecurso extends  Edificacion implements ManejadordeRecursos {

    private Enum recurso;
    
    protected RecolectorRecurso(Raza raza, TipoEdif tipo) {
        super(raza, tipo);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(CALIZA,10);
        costo.put(METALES,3);
        super.setCosto(costo);
    
    }

    public Enum getRecurso() { return recurso; }

    @Override
    public Elemento generarRecurso(Enum Recurso) {
        return null;
    }

    @Override
    public int generarRecurso() {
        return 5;
    }
    
}