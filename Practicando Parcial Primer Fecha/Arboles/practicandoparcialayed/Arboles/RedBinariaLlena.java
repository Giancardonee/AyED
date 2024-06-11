/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandoparcialayed.Arboles;

import practicandoparcialayed.BinaryTree;

public class RedBinariaLlena {
    BinaryTree<Integer> red; 

    public RedBinariaLlena (BinaryTree<Integer> arbol)
    {
        this.red = arbol;
    }
    
    public int RetardoReenvio ()
    {
        return this.red.isEmpty() ? 0 : calcularRecursivo(this.red);
    }
    
    private int calcularRecursivo (BinaryTree<Integer> red)
    {
        int datoActual = red.getData();
        if (red.isLeaf()) return datoActual;
        else
        {
            int HD = 0;
            int HI = 0;
            if (red.hasLeftChild())
                HI = calcularRecursivo(red.getLeftChild());
            if (red.hasRightChild())
                HD = calcularRecursivo(red.getRightChild()); 
            return datoActual + (Math.max(HI, HD));
        }
    }
    
}
