package parcialesgrafos.Parcial1;
public class Ciudad {
    private String nombre;
    private int dias;
    
    public Ciudad (int dias,String nombre)
    {
        this.nombre = nombre;
        this.dias = dias;
    }
    
    public int getDias()
    {
        return this.dias;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
}
