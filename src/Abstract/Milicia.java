package Abstract;

import Client.Raza.Raza;
import Abstract.Guerra.*;

public abstract class Milicia extends Elemento implements Atacante, Victima{
    
    private Victima objetivo;

    public void setObejetivo(Victima objetivo) {this.objetivo = objetivo;}
    
    protected Milicia(Raza raza) {
        super(raza);
    }
    
    @Override
    public void atacar() throws Exception{
        this.objetivo.sufrir(super.getDanio_ataque());
    }
    
    @Override
    public void sufrir(int danno)throws Exception{
        if(this.vida!=0)
            this.vida=this.vida-danno;
        else 
            throw new Exception("Murio");
    }
    
}
