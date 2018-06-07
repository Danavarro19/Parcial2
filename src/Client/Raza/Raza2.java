package Client.Raza;

import static Client.Raza.Nombre.RAZA2;

public class Raza2 extends Raza{


    public Raza2() {
        super(RAZA2,3, 2, 1);
    }

    @Override
    void gritoGuerra() {
        System.out.println("Raza2 hasta la victoria");
    }
}
