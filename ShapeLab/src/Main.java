package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private ArrayList<Oblik> listaOblika = new ArrayList<Oblik>();
    private Scanner skener = new Scanner(System.in);

    public void main(String[] args)
    {
        int opcija = 0;

        do
        {
            opcija = ispisiMeni();

            switch(opcija)
            {
                case 1:
                    dodajOblik();
                    break;
                case 2:
                    ispisiDetaljeSvihOblika();
                    break;
                case 3:
                    obrisiOblik();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Uneta opcija ne postoji.");
            }
        }
        while(opcija != 4);
    }

    private int ispisiMeni()
    {
        int opcija = 0;

        System.out.println("----------------------------------------");
        System.out.println("Unesi:");
        System.out.println("1. Za unos geometrijskog oblika");
        System.out.println("2. Za detaljan ispis svih geometrijskih oblika");
        System.out.println("3. Za brisanje geometrijskog oblika");
        System.out.println("4. Za kraj programa");
        System.out.println("----------------------------------------");

        opcija = skener.nextInt();

        return opcija;
    }

    private void dodajOblik()
    {
        System.out.println("----------------------------------------");
        System.out.println("Unesite broj oblika koji zelite da dodate");
        System.out.println("1. Kvadrat");
        System.out.println("2. Krug");
        System.out.println("3. Trougao");
        System.out.println("4. Trapez");

        int opcija = skener.nextInt();

        switch (opcija)
        {
            case 1:
                Kvadrat kvadrat = FabrikaOblika.napraviKvadrat();
                if(kvadrat != null)
                    listaOblika.add(kvadrat);
                else
                    System.out.println("Greska! Uneti kvadrat nije validan.");
                break;
            case 2:
                Krug krug = FabrikaOblika.napraviKrug();
                if(krug != null)
                    listaOblika.add(krug);
                else
                    System.out.println("Greska! Uneti krug nije validan.");
                break;
            case 3:
                Trougao trougao = FabrikaOblika.napraviTrougao();
                if(trougao != null)
                    listaOblika.add(trougao);
                else
                    System.out.println("Greska! Uneti trougao nije validan.");
                break;
            case 4:
                Trapez trapez = FabrikaOblika.napraviTrapez();
                if(trapez != null)
                    listaOblika.add(trapez);
                else
                    System.out.println("Greska! Uneti trapez nije validan.");
                break;
            default:
                System.out.println("Greska! Uneti broj nije validan.");
        }
    }

    private void obrisiOblik()
    {
        if(listaOblika.size() <= 0)
        {
            System.out.println("Lista oblika je prazna.");
            return;
        }

        System.out.print("Uneti ID oblika kojeg zelis da obrises: ");
        skener.nextLine(); // Zato sto se u Javi ucita i \n
        String ID = skener.nextLine();

        for(Oblik oblik : listaOblika)
        {
            if(ID.equals(oblik.vratiID())) // Mora ID.equals() jer == u Javi poredi reference na objekte, a ne vrednosti
            {
                listaOblika.remove(oblik);
                System.out.println("Oblik je uspesno obrisan!");
                return;
            }
        };

        System.out.println("Oblik nije pronadjen.");
    }

    private void ispisiDetaljeSvihOblika()
    {
        if(listaOblika.size() <= 0)
        {
            System.out.println("Lista oblika je prazna.");
            return;
        }
        System.out.println("----------------------------------------");
        for(Oblik oblik : listaOblika)
        {
            double obim = oblik.obim();
            double povrsina = oblik.povrsina();

            System.out.print(oblik.vratiID() + " | ");
            System.out.print(obim > 0 ? "O=" + obim + " | " : "GRESKA! Oblik nije validan" + " | ");
            System.out.print(povrsina > 0 ? "P=" + povrsina + " | " : "GRESKA! Oblik nije validan");
            System.out.println();
        };
    }
}
