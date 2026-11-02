package src;

import java.util.ArrayList;

public class Main
{
    ArrayList<Oblik> listaOblika = new ArrayList<Oblik>();

    public void main(String[] args)
    {
        Kvadrat k = new Kvadrat(3);
        Krug _k = new Krug(5);

        listaOblika.add(k);
        listaOblika.add(_k);

        for(Oblik o : listaOblika)
        {
            System.out.println(o.ID);
            System.out.println("Obim je " + o.obim());
            System.out.println("Povrsina je " + o.povrsina());
        }
    }
}
