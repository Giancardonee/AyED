package Parcial1;

import parciales.BinaryTree;

public class Parcial1 {
    BinaryTree<String> arbol;
    public Parcial1 (BinaryTree<String> arb){
        this.arbol = arb;
    }
    
    
    public BinaryTree<String> princesaAccesible()
    {
        return (arbol == null || arbol.isEmpty())? null : helper(arbol);
    }
    
    private BinaryTree<String> helper (BinaryTree<String> arbol)
    {
        BinaryTree<String> arbolReturn = null;
        if (esPrincesa(arbol.getData()))
            arbolReturn = arbol;
        else if (!arbol.isLeaf() && !esDragon(arbol.getData()))
        {
            if (arbol.hasLeftChild())
                arbolReturn = helper(arbol.getLeftChild());
            if (arbol.hasRightChild() && arbolReturn == null)
                arbolReturn = helper(arbol.getRightChild());
        }
        return arbolReturn;
    }
    
    private boolean esDragon (String st)
    {
        return st.equals("Dragon");
    }
    
    private boolean esPrincesa (String st)
    {
        return st.equals("Princesa");
    }
    
    
    
    // testing
    
     public static void main(String[] args) {
         BinaryTree<String> raiz = new BinaryTree ("A");
         
         BinaryTree<String> subIzq = new BinaryTree ("Dragon");
         subIzq.addLeftChild(new BinaryTree<>("Princesa"));
         subIzq.addRightChild(new BinaryTree<>("Y"));
         raiz.addLeftChild(subIzq);
         
         BinaryTree<String> subDer = new BinaryTree<>("Z");
         subDer.addRightChild(new BinaryTree<>("Z"));
         subDer.getRightChild().addRightChild(new BinaryTree<>("W"));
         subDer.getRightChild().getRightChild().addRightChild(new BinaryTree<>("Princesa"));
         raiz.addRightChild(subDer);
         
         // Ya creamos el arbol del enunciado. Ahora queda testearlo a ver que devuelve.
         
         Parcial1 enunciado = new Parcial1(raiz);
         BinaryTree<String> resultado = enunciado.princesaAccesible();
         if (resultado != null) 
             System.out.println("Se encontro a la princesa");
         else 
             System.out.println("La princesa no se encontro en el arbol.");
    }
}
