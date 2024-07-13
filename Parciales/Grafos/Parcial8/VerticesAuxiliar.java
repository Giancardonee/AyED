package parcialesgrafos.Parcial8;

import parcialesgrafos.clasesGenericas.Vertex;

public class VerticesAuxiliar {
    private Vertex<Ciudad> vOrigen;
    private Vertex<Ciudad> vDestino;
    
    public VerticesAuxiliar()
    {
        
    }
    
    public VerticesAuxiliar(Vertex<Ciudad>vO, Vertex<Ciudad>vD)
    {
        this.vDestino = vD;
        this.vOrigen = vO;
    }

    public Vertex<Ciudad> getvOrigen() {
        return vOrigen;
    }

    public void setvOrigen(Vertex<Ciudad> vOrigen) {
        this.vOrigen = vOrigen;
    }

    public Vertex<Ciudad> getvDestino() {
        return vDestino;
    }

    public void setvDestino(Vertex<Ciudad> vDestino) {
        this.vDestino = vDestino;
    }
    
    public boolean encontreAmbosVertices()
    {
        return this.vDestino != null && this.vOrigen != null;
    }
    
}
