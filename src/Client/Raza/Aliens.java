package Client.Raza;

import static Client.Raza.Nombre.ALIENS;

public class Aliens extends Raza{

    public Aliens() {
        super(ALIENS,2, 1, 2);
    }

    @Override
    void gritoGuerra() {
        System.out.println("Morir o matar!!");
    }
}
