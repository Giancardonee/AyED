package parciales.Parcial2;

import java.util.LinkedList;
import java.util.List;
import parciales.ClasesGenericas.BinaryTree;

public class auxiliar {
    private List<BinaryTree<Integer>> listaCondicion;
    private int cantPares;
    
    public auxiliar()
    {
        listaCondicion = new LinkedList<>();
        cantPares = 0;
    }
    
    public void incrementarCantPares()
    {
        this.cantPares++;
    }
    
    public void agregarEnLista(BinaryTree<Integer> nodo)
    {
        listaCondicion.add(nodo);
    }

    public List<BinaryTree<Integer>> getListaCondicion() {
        return listaCondicion;
    }

    public int getCantPares() {
        return cantPares;
    }


    
    
}
