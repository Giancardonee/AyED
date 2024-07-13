package parcialesgrafos.ParcialSegundaFechaTema1;
public class auxiliar {
    private String nombre;
    private int distancia; 

    public auxiliar(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    public String toString()
    {
        return "("+this.nombre+","+this.getDistancia()+")";
    }
}
