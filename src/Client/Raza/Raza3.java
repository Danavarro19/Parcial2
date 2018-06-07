package Client.Raza;

import static Client.Raza.Nombre.RAZA3;

public class Raza3 extends Raza{


    public Raza3() {
        super(RAZA3,2, 1, 3);
    }

    @Override
    void gritoGuerra() {
        System.out.println("Morir o matar!!");
    }
}
