package src;

public class Kvadrat extends Oblik implements IStranica
{
    private double a;

    public Kvadrat()
    {
        a = 0;
    }

    public Kvadrat(double a)
    {
        this.a = a;
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
            System.out.println("Stranica a nema validnu vrednost. Oblik nije ispravan");
            return false;
        }
        else
        {
            return true;
        }

    }

    public double[] vratiStranice()
    {
        return new double[] { a };
    }
}