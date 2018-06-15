package Abstract;

import Abstract.Guerra.*;
import Client.Raza.Raza;

public abstract class Vehiculo extends Elemento implements Atacante, Victima {
    
    private Victima objetivo;
    
    protected Vehiculo(Raza raza) {
        super(raza);
    }

    @Override
    public void atacar() throws Exception {
        this.objetivo.sufrir(super.getDanio_ataque());
    }

    @Override
    public void sufrir(int danno) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
