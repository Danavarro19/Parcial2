package Abstract;

import Client.Raza.Raza;

import java.util.Map;
import static Abstract.Recurso.RECURSO1;
import static Abstract.Recurso.RECURSO3;
import Concrete.Edifiacion.TipoEdif;

public abstract class Edificacion extends Elemento{
    
    protected final TipoEdif tipo;
    protected Edificacion(Raza raza, TipoEdif tipo) {
        super(raza);
        this.tipo=tipo;

    }

    public TipoEdif getTipo() { return tipo; }
    
    
}
