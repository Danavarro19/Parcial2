package Client.Raza;

import static Client.Raza.Nombre.VAQUEROS;

public class Vaqueros extends Raza{


    public Vaqueros() {
        super(VAQUEROS,1, 2, 3);
    }

    @Override
    void gritoGuerra() {
        System.out.println("Raza1 hasta la muerte");
    }
}
