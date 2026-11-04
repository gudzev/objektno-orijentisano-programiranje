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
                    izmeniOblik();
                    break;
                case 4:
                    obrisiOblik();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Uneta opcija ne postoji.");
            }
        }
        while(opcija != 5);
    }

    private int ispisiMeni()
    {
        int opcija = 0;

        System.out.println("----------------------------------------");
        System.out.println("Unesi:");
        System.out.println("1. Za unos geometrijskog oblika");
        System.out.println("2. Za detaljan ispis svih geometrijskih oblika");
        System.out.println("3. Za izmenu geometrijskog oblika");
        System.out.println("4. Za brisanje geometrijskog oblika");
        System.out.println("5. Za kraj programa");
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

    private void izmeniOblik()
    {
        if(listaOblika.size() <= 0)
        {
            System.out.println("Lista oblika je prazna.");
            return;
        }

        System.out.print("Uneti ID oblika: ");
        skener.nextLine(); // Zato sto se u Javi ucita i \n
        String ID = skener.nextLine();

        for(Oblik o : listaOblika)
        {
            if(ID.equals(o.vratiID()))
            {
                izmeniOblik(o);
                return;
            }
        }
    }

    private void izmeniOblik(Oblik o)
    {
        if (o instanceof Kvadrat)
        {
            double aStaro = ((Kvadrat) o).vratiStranicu();
            System.out.print("Trenutno je a=" + aStaro + ". Unesite novu vrednost: ");
            double aNovo = skener.nextDouble();

            if (((Kvadrat) o).postaviStranice(aNovo)) {
                System.out.println("Stranica je uspesno postavljena");
            }
        }
        else if (o instanceof Krug)
        {
            double rStaro = ((Krug) o).vratiPoluprecnik();
            System.out.print("Trenutno je r=" + rStaro + ". Unesite novu vrednost: ");
            double rNovo = skener.nextDouble();

            if (((Krug) o).postaviPoluprecnik(rNovo))
                System.out.println("Poluprecnik je uspesno postavljen");
        }
        else if (o instanceof Trougao)
        {
            double[] stranice = ((Trougao) o).vratiStranice();
            int opcija = 0;

            System.out.println("Uneti: ");
            System.out.println("1. za izmenu stranice a: ");
            System.out.println("2. za izmenu stranice b: ");
            System.out.println("3. za izmenu stranice c: ");
            System.out.println("Bilo koji drugi broj za kraj programa");

            opcija = skener.nextInt();

            switch (opcija)
            {
                case 1:
                    System.out.print("Trenutno je a=" + stranice[0] + ". Unesite novu vrednost:");
                    double aNovo = skener.nextDouble();

                    if (((Trougao) o).postaviStranice(aNovo, stranice[1], stranice[2]))
                        System.out.println("Stranica je uspesno postavljena");
                    break;
                case 2:
                    System.out.print("Trenutno je b=" + stranice[1] + ". Unesite novu vrednost:");
                    double bNovo = skener.nextDouble();

                    if (((Trougao) o).postaviStranice(stranice[0], bNovo, stranice[2]))
                        System.out.println("Stranica je uspesno postavljena");
                    break;
                case 3:
                    System.out.print("Trenutno je c=" + stranice[2] + ". Unesite novu vrednost:");
                    double cNovo = skener.nextDouble();

                    if (((Trougao) o).postaviStranice(stranice[0], stranice[1], cNovo))
                        System.out.println("Stranica je uspesno postavljena");
                    break;
                default:
                    System.out.println("Izabrana opcija ne postoji.");
            }
        }
        else
        {
            double[] stranice = ((Trapez) o).vratiStranice();
            int opcija = 0;

            System.out.println("Uneti: ");
            System.out.println("1. za izmenu stranice a: ");
            System.out.println("2. za izmenu stranice b: ");
            System.out.println("3. za izmenu stranice c: ");
            System.out.println("4. za izmenu stranice d: ");
            System.out.println("Bilo koji drugi broj za kraj programa");

            opcija = skener.nextInt();

            switch (opcija)
            {
                case 1:
                    System.out.print("Trenutno je a=" + stranice[0] + ". Unesite novu vrednost:");
                    double aNovo = skener.nextDouble();

                    if (((Trapez) o).postaviStranice(aNovo, stranice[1], stranice[2], stranice[3]))
                        System.out.println("Stranica je uspesno postavljena");
                    break;
                case 2:
                    System.out.print("Trenutno je b=" + stranice[1] + ". Unesite novu vrednost:");
                    double bNovo = skener.nextDouble();

                    if (((Trapez) o).postaviStranice(stranice[0], bNovo, stranice[2], stranice[3]))
                        System.out.println("Stranica je uspesno postavljena");
                    break;
                case 3:
                    System.out.print("Trenutno je c=" + stranice[2] + ". Unesite novu vrednost:");
                    double cNovo = skener.nextDouble();

                    if (((Trapez) o).postaviStranice(stranice[0], stranice[1], cNovo, stranice[3]))
                        System.out.println("Stranica je uspesno postavljena");
                    break;
                case 4:
                    System.out.print("Trenutno je d=" + stranice[3] + ". Unesite novu vrednost:");
                    double dNovo = skener.nextDouble();

                    if (((Trapez) o).postaviStranice(stranice[0], stranice[1], stranice[2], dNovo))
                        System.out.println("Stranica je uspesno postavljena");
                    break;
                default:
                    System.out.println("Izabrana opcija ne postoji.");
            }
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

            if(!(obim != -1 && povrsina != -1))
            {
                System.out.println(oblik.vratiID() + " nema ispravne dimenzije, pa obim i povrsina ne mogu biti izracunate.");
                continue;
            }

            System.out.println(oblik.vratiID() + " | " + "O=" + obim + " | " + "P=" + povrsina);
        };
    }
}
