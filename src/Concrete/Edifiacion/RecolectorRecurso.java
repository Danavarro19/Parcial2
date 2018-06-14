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
    private int cant;
    
    protected RecolectorRecurso(Raza raza, TipoEdif tipo) {
        super(raza, tipo);
        Map<Recurso,Integer> costo = new HashMap<>();
        costo.put(CALIZA,super.getRaza().getRazaRecoleccion()*2);
        costo.put(METALES,super.getRaza().getRazaRecoleccion()*3);
        super.setCosto(costo);    
        super.setTiempo_espera(1);
    }

    public Enum getRecurso() { return recurso; }
    
    public int getCant(){ return this.cant; }


    public RecolectorRecurso setRecurso(Enum recurso){
        this.recurso=recurso;
        return this;
    }

    @Override
    public Elemento generarRecurso(Enum Recurso) { return null;}

    @Override
    public int generarRecurso() {
        if (this.cant <10){
            this.cant+=2;
            System.out.println("Se recolecto "+2+" unidades de "+recurso);
        }
        return 0;
    }
    
}