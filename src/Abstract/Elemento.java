package Abstract;

import Client.DanielNavarros_World;
import Client.Raza.Raza;

import java.util.Map;

public abstract class Elemento  {


    private final int FASE_CREACION;
    private boolean disponible;
    private final Raza raza;
    private  Map<Recurso,Integer> costo;
    protected int vida;
    private int tiempo_espera;
    private float danio_ataque;

    protected Elemento(Raza raza) {

        this.raza=raza;
        this.FASE_CREACION=DanielNavarros_World.getFase();
        this.disponible=false;
    }


    public void makeDisponible(){ this.disponible = true; }

    public boolean isDisponible() { return disponible; }

    public int getVida() {
        return vida;
    }

    public int getFASE_CREACION() {
        return FASE_CREACION;
    }

    public int getTiempo_espera() {
        return tiempo_espera;
    }

    public float getDanio_ataque() {
        return danio_ataque;
    }

    public Map<Recurso, Integer> getCosto() { return costo; }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setTiempo_espera(int tiempo_espera) {
        this.tiempo_espera = tiempo_espera;
    }

    public void setDanio_ataque(float danio_ataque) {
        this.danio_ataque = danio_ataque;
    }

    public void setCosto(Map<Recurso, Integer> costo) { this.costo = costo; }
}
