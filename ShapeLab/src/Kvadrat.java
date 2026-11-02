package src;

public class Kvadrat extends Oblik implements IIspisDetaljaOblika
{
    private static int brojKvadrata;

    private double a;

    public Kvadrat()
    {
        a = 0;
        ID = "Kvadrat#" + brojKvadrata;
        brojKvadrata++;
    }

    public Kvadrat(double a)
    {
        this.a = a;
        ID = "Kvadrat#" + brojKvadrata;
        brojKvadrata++;
    }

    @Override
    public double povrsina()
    {
        if(!jeIspravan()) return -1;

        return a * a;
    }

    @Override
    public double obim()
    {
        if(!jeIspravan()) return -1;

        return 4 * a;
    }

    @Override
    public boolean jeIspravan()
    {
        if(a <= 0)
        {
            System.out.println("Stranica a nema validnu vrednost (> 0).");
            return false;
        }
        else
        {
            return true;
        }

    }

    @Override
    public void ispisiObim()
    {
        if(obim() > 0)
            System.out.println("Obim kvadrata je " + obim());
    }

    @Override
    public void ispisiPovrsinu()
    {
        if(povrsina() > 0)
            System.out.println("Povrsina kvadrata je " + povrsina());
    }

    public double vratiStranicu()
    {
        if(jeIspravan())
            return a;
        return -1;
    }

    public void postaviStranice(double a)
    {
        if(a > 0)
            this.a = a;
        else
            System.out.println("Greska! Stranica mora biti veca od 0.");
    }
}