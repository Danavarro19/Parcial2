package Abstract;

import Abstract.Guerra.Victima;
import Client.Raza.Raza;

import java.util.Map;
import Concrete.Edifiacion.TipoEdif;
import static Abstract.Recurso.CALIZA;
import static Abstract.Recurso.METALES;

public abstract class Edificacion extends Elemento implements Victima{
    
    protected final TipoEdif tipo;
    protected Edificacion(Raza raza, TipoEdif tipo) {
        super(raza);
        this.tipo=tipo;

    }

    public TipoEdif getTipo() { return tipo; }

    @Override
    public void sufrir(int danno) throws Exception {
        this.vida=this.vida=danno;
    }
    
    
}
