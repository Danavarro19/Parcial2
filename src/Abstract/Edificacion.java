package Abstract;

import Client.Raza.Raza;

import java.util.Map;
import Concrete.Edifiacion.TipoEdif;
import static Abstract.Recurso.CALIZA;
import static Abstract.Recurso.METALES;

public abstract class Edificacion extends Elemento{
    
    protected final TipoEdif tipo;
    protected Edificacion(Raza raza, TipoEdif tipo) {
        super(raza);
        this.tipo=tipo;

    }

    public TipoEdif getTipo() { return tipo; }
    
    
}
