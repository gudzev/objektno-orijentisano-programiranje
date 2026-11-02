package src;

public class Krug extends Oblik implements IIspisDetaljaOblika
{
    private static int brojKruga;

    private double r;

    public Krug()
    {
        r = 0;
        ID = "Krug#" + brojKruga;
        brojKruga++;
    }

    public Krug(double r)
    {
        this.r = r;
        ID = "Krug#" + brojKruga;
        brojKruga++;
    }

    public boolean jeIspravan()
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
        if(povrsina() > 0)
            System.out.println("Povrsina kruga je " + povrsina());
    }

    @Override
    public void ispisiObim()
    {
        if(obim() > 0)
        {
            System.out.println("Obim kruga je " + obim());
        }
    }

    public double vratiPoluprecnik()
    {
        if(jeIspravan())
            return r;
        return -1;
    }

    public void postaviPoluprecnik(double r)
    {
        if(jeIspravan())
            this.r = r;
        System.out.println("Greska! Poluprecnik mora biti veci od 0.");
    }
}