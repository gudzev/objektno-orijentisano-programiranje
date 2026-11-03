package src;

public class Trapez extends Oblik implements IIspisDetaljaOblika
{
    private static int brojTrapeza = 0;

    private double a;
    private double b;
    private double c;
    private double d;

    public Trapez()
    {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        postaviID("Trapez#" + brojTrapeza);
        brojTrapeza++;
    }

    public Trapez(double a, double b, double c, double d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        postaviID("Trapez#" + brojTrapeza);
        brojTrapeza++;
    }

    public static boolean jeIspravan(double a, double b, double c, double d)
    {
        if(Math.abs(b - d) < Math.abs(a - c) && Math.abs(a - c) < (b + d) && a > 0 && b > 0 && c > 0 && d > 0)
        {
            return true;
        }

        System.out.println("Oblik sa unetim stranicama nije validan trapez.");
        return false;
    }

    @Override
    public boolean jeIspravan()
    {
        return jeIspravan(a, b, c, d);
    }

    @Override
    public double povrsina()
    {
        if(!jeIspravan())
            return -1;

        double x = (Math.pow((a - c), 2) + b * b - d * d) / (2 * (a - c));
        double visinaTrapeza = Math.sqrt(b * b - x * x);
        return ((a + c) / 2) * visinaTrapeza;
    }

    @Override
    public double obim()
    {
        if(!jeIspravan())
            return -1;

        return a + b + c + d;
    }

    @Override
    public void ispisiPovrsinu()
    {
        double povrsina = povrsina();
        if(povrsina > 0)
            System.out.println("Povrsina trapeza je " + povrsina);
    }

    @Override
    public void ispisiObim()
    {
        double obim = obim();
        if(obim > 0)
        {
            System.out.println("Obim trapeza je " + obim);
        }
    }

    public void postaviStranice(double a, double b, double c, double d)
    {
        if(!jeIspravan(a, b, c, d))
        {
            System.out.println("Unete stranice trapeza nisu ispravne.");
        }
        else
        {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    public double[] vratiStranice()
    {
        return new double[] {a, b, c, d};
    }

}