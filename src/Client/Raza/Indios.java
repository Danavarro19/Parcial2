package Client.Raza;

import static Client.Raza.Nombre.INDIOS;

public class Indios extends Raza{

    public Indios() {
        super(INDIOS,3, 2, 1);
    }

    @Override
    void gritoGuerra() {
        System.out.println("Raza2 hasta la victoria");
    }
}
