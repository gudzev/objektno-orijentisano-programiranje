package src;

public class Trougao extends Oblik implements IIspisDetaljaOblika
{
    private static int brojTrouglova = 0;

    private double a;
    private double b;
    private double c;

    public Trougao()
    {
        a = 0;
        b = 0;
        c = 0;
        postaviID("Trougao#" + brojTrouglova);
        brojTrouglova++;
    }

    public Trougao(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        postaviID("Trougao#" + brojTrouglova);
        brojTrouglova++;
    }

    public static boolean jeIspravan(double a, double b, double c)
    {
        return a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0;
    }

    @Override
    public boolean jeIspravan()
    {
        return jeIspravan(a, b, c);
    }

    @Override
    public double povrsina()
    {
        if(!jeIspravan())
            return -1;

        double s = (a + b + c ) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double obim()
    {
        if(!jeIspravan())
        {
            System.out.println("Uneti trougao nije validan; nije ga moguce formirati");
            return -1;
        }

        return a + b + c;
    }

    @Override
    public void ispisiPovrsinu()
    {
        double povrsina = povrsina();

        if(povrsina > 0)
            System.out.println("Povrsina trougla je " + povrsina);
    }

    @Override
    public void ispisiObim()
    {
        double obim = obim();

        if(obim > 0)
            System.out.println("Obim trougla je " + obim);
    }

    public double[] vratiStranice()
    {
        return new double[] {a, b, c};
    }

    public void postaviStranice(double a, double b, double c)
    {
        if(!jeIspravan(a, b, c))
        {
            System.out.println("Unete stranice trougla nisu validne.");
        }
        else
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}