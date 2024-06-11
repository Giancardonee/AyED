package practicandoparcialayed.Arboles;

import practicandoparcialayed.BinaryTree;


/*
Recibe un arbol binario de enteros y un valor entero. 
Suma y retorna todos los numeros impares que son mayores al valor pasado por parametro.
Realizar en un recorrido posOrden.
*/
public class Parcial1 {
    public Integer sumaImparesPosOrdenMayorA (BinaryTree<Integer> arbol , int limite)
    {
        return arbol.isEmpty()? -1 : helper(arbol,limite);
    }
    
    private Integer helper (BinaryTree<Integer> arbol , int limite)
    {
        int suma=0;
        if (arbol.hasLeftChild()) 
            suma += helper(arbol.getLeftChild(), limite);
        if (arbol.hasRightChild())
            suma += helper(arbol.getRightChild(),limite);
        int datoArbol = arbol.getData();
        if (datoArbol > limite  && datoArbol % 2 != 0)
            suma+= arbol.getData();
        return suma;
    }
    
     public static void main(String[] args) {
        System.out.println("Ejercicio Parcial 1: ");
        
        // creamos el arbol: 
        BinaryTree<Integer> raiz = new BinaryTree<>(200); 
        raiz.addLeftChild(new BinaryTree<>(100));
        raiz.addRightChild(new BinaryTree<>(300));
        // agrego hijos al subarbol izq
        raiz.getLeftChild().addLeftChild(new BinaryTree<>(50));
        raiz.getLeftChild().addRightChild(new BinaryTree<>(150));
        // agrego hijos al subarbol der
        raiz.getRightChild().addLeftChild(new BinaryTree<>(251));
        raiz.getRightChild().addRightChild(new BinaryTree<>(351));
        // este linea siguiente esta de mas. 
        raiz.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(30));
        /*
                           200  
                       /         \
                    100          300
                  /    \        /   \
                 50     150    251   351 
               /
             30     
        */
        Parcial1 p1 = new Parcial1();
         System.out.println(p1.sumaImparesPosOrdenMayorA(raiz, 240));

    }
}
