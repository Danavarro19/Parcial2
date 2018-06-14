package Concrete.Edifiacion;

import Abstract.Edificacion;
import Abstract.Elemento;
import Abstract.Recurso;
import Client.Raza.Nombre;
import Client.Raza.Raza;

import java.util.HashMap;
import java.util.Map;

import Client.DanielNavarros_World;
import static Abstract.Recurso.CALIZA;
import static Abstract.Recurso.METALES;

public class GeneradorRecurso extends Edificacion implements ManejadordeRecursos{
    private Enum recurso;
    
    public Enum getRecurso(){return this.recurso;}
    
    public GeneradorRecurso(Raza raza, TipoEdif tipo) {
        super(raza, tipo);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(CALIZA,10);
        costo.put(METALES,3);
        super.setCosto(costo);
        super.setTiempo_espera(2);
    }
    

    @Override
    public int generarRecurso() {
        int generado=0;
        generado+=3;
        System.out.println("Generando recurso, cantidad "+generado);
        return generado;
    };

    @Override
    public Elemento generarRecurso(Enum Recurso) {
        return null;
    }
}
