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
import Client.DanielNavarros_World;

public class GeneradorRecurso extends Edificacion {
    
    private Enum recurso;
    private int inventario;
    
    protected GeneradorRecurso(Raza raza, TipoEdif tipo) {
        super(raza, tipo);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(RECURSO1,10);
        costo.put(RECURSO3,3);
        super.setCosto(costo);
    }

    public Enum getRecurso() { return recurso; }

    public int getInventario() { return inventario; }
    
    
    
    public int generarRecurso() {
        if(super.isDisponible()){
            inventario+=3;
        }
        return inventario;
    };
}
