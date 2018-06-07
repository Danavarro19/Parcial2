package Client.Raza;

import static Client.Raza.Nombre.RAZA1;

public class Raza1 extends Raza{


    public Raza1() {
        super(RAZA1,1, 2, 3);
    }


    @Override
    void gritoGuerra() {
        System.out.println("Raza1 hasta la muerte");
    }
}
