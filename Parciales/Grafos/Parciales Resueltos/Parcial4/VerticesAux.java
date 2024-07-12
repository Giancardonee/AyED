package parcialesgrafos.Parcial4;

import parcialesgrafos.clasesGenericas.Vertex;

public class VerticesAux {
    Vertex<String> origen;
    Vertex<String> destino;
    
    public VerticesAux ()
    {
        origen = null;
        destino = null;
    }

    public Vertex<String> getOrigen() {
        return origen;
    }

    public Vertex<String> getDestino() {
        return destino;
    }

    public void setOrigen(Vertex<String> origen) {
        this.origen = origen;
    }

    public void setDestino(Vertex<String> destino) {
        this.destino = destino;
    }
    
    public boolean verticesEncontrados ()
    {
        return origen!= null && destino != null;
    }
}
