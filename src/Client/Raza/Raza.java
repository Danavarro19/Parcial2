package Client.Raza;

public abstract class Raza {

    private Nombre nombre;
    private final int razaFuerza;
    private final int razaVelocidad;
    private final int razaRecoleccion;

    public int getRazaFuerza() {return razaFuerza;}

    public int getRazaVelocidad() {return razaVelocidad;}

    public int getRazaRecoleccion() {return razaRecoleccion;}

    
    protected Raza(Nombre nombre, int razaFuerza, int razaVelocidad, int razaRecoleccion) {
        this.razaFuerza = razaFuerza;
        this.razaVelocidad = razaVelocidad;
        this.razaRecoleccion = razaRecoleccion;
        this.nombre=nombre;
    }

    public Nombre getNombre() { return nombre; }

    abstract void gritoGuerra();
}
