package grafos.Eje3;

import java.util.LinkedList;
import java.util.List;

public class AuxMin {
    private List<String> ciudades;
    private int distancia;
    
    public AuxMin (List<String> ciudades, int distancia)
    {
        this.ciudades = ciudades;
        this.distancia = distancia;
    }
    
    public AuxMin()
    {
        this.ciudades = new LinkedList<>();
        distancia = Integer.MAX_VALUE;
    }
    
    
    
    public List<String> getCiudades() {
        return ciudades;
    }

    public void actualizarLista(List<String> nuevaLista) {
        this.ciudades.clear();
        this.ciudades.addAll(nuevaLista);
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
}
