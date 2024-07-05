package SegundaFecha2024_Arboles;

import parciales.ClasesGenericas.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;
    
    
    public ParcialArboles(BinaryTree<Integer> a)
    {
        this.arbol = a;
    }
    
    public BinaryTree<Integer> nuevoTree()
    {
        BinaryTree<Integer> nuevoArbol = null;
        if (this.arbol != null && !this.arbol.isEmpty())
        {
            nuevoArbol = new BinaryTree<>(this.arbol.getData());
            crearArbol(this.arbol,nuevoArbol);
        }
        return nuevoArbol;
    }
    
    private void crearArbol(BinaryTree<Integer> arb, BinaryTree<Integer> nuevoArbol)
    {
        if (arb.hasLeftChild())
        {
            nuevoArbol.addLeftChild(new BinaryTree<>(arb.getData() + arb.getLeftChild().getData()));
            crearArbol(arb.getLeftChild(),nuevoArbol.getLeftChild());
        }
        if (arb.hasRightChild())
        {
            nuevoArbol.addRightChild(new BinaryTree<>(arb.getRightChild().getData()));
            crearArbol(arb.getRightChild(), nuevoArbol.getRightChild());
        }
    }
    
    
     public static void main(String args[]) {
         // hice el mismo arbol que el parcial. 
         BinaryTree<Integer> raiz = new BinaryTree<>(1);
         
         BinaryTree<Integer> subarbolIzq = new BinaryTree<>(2);
         subarbolIzq.addLeftChild(new BinaryTree<>(4));
         
         BinaryTree<Integer> subarbolDer = new BinaryTree<>(3);
         subarbolDer.addLeftChild(new BinaryTree<>(5));
         subarbolDer.getLeftChild().addLeftChild(new BinaryTree<>(7));
         
         subarbolDer.addRightChild(new BinaryTree<>(6));
         
         
         raiz.addLeftChild(subarbolIzq);
         raiz.addRightChild(subarbolDer);
         
         imprimirInorden(raiz);
         
         ParcialArboles ParcialSegundaFecha = new ParcialArboles(raiz);
         BinaryTree<Integer> nuevoArbol = ParcialSegundaFecha.nuevoTree();
         
         
         System.out.println("Nuevo arbol: ");
         imprimirInorden(nuevoArbol);
     }
     
     
     private static void imprimirInorden(BinaryTree<Integer> a)
     {
         System.out.println(a.getData()+" ");
         if (a.hasLeftChild()) imprimirInorden(a.getLeftChild());
         
         if (a.hasRightChild()) imprimirInorden(a.getRightChild());
     }
}
