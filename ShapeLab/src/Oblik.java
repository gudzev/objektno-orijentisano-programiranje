package src;

public abstract class Oblik
{
    private String ID;

    protected String vratiID()
    {
        return ID;
    }

    protected void postaviID(String ID)
    {
        this.ID = ID;
    }

    public abstract double povrsina();

    public abstract double obim();

    public abstract boolean jeIspravan();
}