package src;

import java.util.Scanner;

public class FabrikaOblika
{
    private static Scanner skener = new Scanner(System.in);

    private FabrikaOblika()
    {

    }

    public static Krug napraviKrug()
    {
        System.out.print("Unesi poluprecnik kruga: ");
        double r = skener.nextInt();

        if(Krug.jeIspravan(r))
        {
            return new Krug(r);
        }
        else
        {
            return null;
        }
    }

    public static Kvadrat napraviKvadrat()
    {
        System.out.print("Unesi stranicu kvadrata: ");
        double a = skener.nextInt();

        if(Kvadrat.jeIspravan(a))
        {
            return new Kvadrat(a);
        }
        else
        {
            return null;
        }
    }

    public static Trougao napraviTrougao()
    {
        System.out.print("Unesi stranicu a trougla: ");
        double a = skener.nextInt();

        System.out.print("Unesi stranicu b trougla: ");
        double b = skener.nextInt();

        System.out.print("Unesi stranicu c trougla: ");
        double c = skener.nextInt();

        if(Trougao.jeIspravan(a, b, c))
        {
            return new Trougao(a, b, c);
        }
        else
        {
            return null;
        }
    }

    public static Trapez napraviTrapez()
    {
        System.out.print("Unesi stranicu a trapeza: ");
        double a = skener.nextInt();

        System.out.print("Unesi stranicu b trapeza: ");
        double b = skener.nextInt();

        System.out.print("Unesi stranicu c trapeza: ");
        double c = skener.nextInt();

        System.out.print("Unesi stranicu d trapeza: ");
        double d = skener.nextInt();

        if(Trapez.jeIspravan(a, b, c, d))
        {
            return new Trapez(a, b, c, d);
        }
        else
        {
            return null;
        }
    }
}
