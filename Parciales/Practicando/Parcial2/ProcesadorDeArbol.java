package parciales.Parcial2;

import parciales.ClasesGenericas.BinaryTree;

public class ProcesadorDeArbol {
    private BinaryTree<Integer> arbol;
    
    
    public ProcesadorDeArbol (BinaryTree<Integer> ar)
    {
        this.arbol = ar;
    }
    
    public auxiliar procesar ()
    {
        auxiliar aux = new auxiliar ();
        if (this.arbol != null && !this.arbol.isEmpty())
            helper(aux,this.arbol);
        return aux;
    }
    
    private void helper (auxiliar aux, BinaryTree<Integer>a)
    {
        if (esPar(a.getData()))
        {
            aux.incrementarCantPares();
            if (cumpleCondicionLista(a))
                aux.agregarEnLista(a);
        }
        if (a.hasLeftChild())
            helper(aux,a.getLeftChild());
        if (a.hasRightChild())
            helper(aux,a.getRightChild());
    }
    
    private boolean cumpleCondicionLista (BinaryTree<Integer> nodo)
    {
        return nodo.hasLeftChild() && nodo.hasRightChild();
    }
    
    private boolean esPar(int numero)
    {
        return numero % 2 == 0;
    }
    
     public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(9));
        ab.getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(16));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(18));
        ab.getRightChild().getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(24));
        
        ProcesadorDeArbol p = new ProcesadorDeArbol(ab);
        auxiliar parc = p.procesar();
        
        System.out.println("");
        
        System.out.println(parc.getListaCondicion());
        System.out.println(parc.getCantPares());
    }
    
}
