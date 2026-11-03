package src;

public class Krug extends Oblik implements IIspisDetaljaOblika
{
    private static int brojKruga = 0;

    private double r;

    public Krug()
    {
        r = 0;
        postaviID("Krug#" + brojKruga);
        brojKruga++;
    }

    public Krug(double r)
    {
        this.r = r;
        postaviID("Krug#" + brojKruga);
        brojKruga++;
    }

    public static boolean jeIspravan(double r)
    {
        if(r > 0)
        {
            return true;
        }
        else
        {
            System.out.println("Uneti poluprecnik nije ispravan (mora biti > 0).");
            return false;
        }
    }

    @Override
    public boolean jeIspravan()
    {
        return jeIspravan(r);
    }

    @Override
    public double povrsina()
    {
        if(jeIspravan())
            return r * r * Math.PI;
        return -1;
    }

    @Override
    public double obim()
    {
        if(jeIspravan())
            return 2 * r * Math.PI;
        return -1;
    }

    @Override
    public void ispisiPovrsinu()
    {
        double povrsina = povrsina();

        if(povrsina > 0)
            System.out.println("Povrsina kruga je " + povrsina);
    }

    @Override
    public void ispisiObim()
    {
        double obim = obim();

        if(obim > 0)
        {
            System.out.println("Obim kruga je " + obim);
        }
    }

    public double vratiPoluprecnik()
    {
        return r;
    }

    public void postaviPoluprecnik(double r)
    {
        if(!jeIspravan(r))
        {
            System.out.println("Greska! Poluprecnik mora biti veci od 0.");
            return;
        }

        this.r = r;
    }
}