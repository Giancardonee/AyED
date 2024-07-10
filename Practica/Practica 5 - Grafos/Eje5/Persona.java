package grafos.Eje5;
public class Persona {
    private String nombre;
    private boolean cobro; 
    private String tipo; // Empleado o Jubilado 
    private String domicilio;
    
    public Persona(String tipo,String nombre, String domicilio,boolean cobro)
    {
        this.nombre = nombre;
        this.cobro = cobro;
        this.tipo = tipo;
        this.domicilio = domicilio; 
    }   
    
    public boolean cobroSueldo(){
        return cobro;
    }
    
    public boolean esEmpleado()
    {
        return tipo.equals("Empleado");
    }
    
    public boolean esJubilado()
    {
        return tipo.equals("Jubilado");
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDomicilio() {
        return domicilio;
    }
    @Override
    public String toString()
    {
        String str = "Nombre "+this.getNombre()+ " es "+this.getTipo()+ " cobro? "+this.cobroSueldo()+"\n";
        return str;
    }
    
}
