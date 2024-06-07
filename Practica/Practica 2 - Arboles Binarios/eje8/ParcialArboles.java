package Practica2.eje8;

import clases_genericas.BinaryTree;

    public class ParcialArboles {
    public static boolean esPrefijo (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        
          if (arbol2.isEmpty() && !arbol1.isEmpty()) return false;
          else if (arbol1.isEmpty() && arbol2.isEmpty()) return true; 
          else return helper(arbol1, arbol2);
    }
    
    private static boolean helper(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if (!arbol1.getData().equals(arbol2.getData())) 
            return false;
        else{
            boolean resultado = true;
            if (arbol1.tieneHijoIzq()){
                if (arbol2.tieneHijoIzq()){
                    resultado = helper(arbol1.getHijoIZquierdo(), arbol2.getHijoIZquierdo());
                }
                else return false; // el arbol 2 no coincide con el arbol1
            }
            if (arbol1.tieneHijoDer()){
                if (arbol2.tieneHijoDer()){
                    resultado = helper(arbol1.getHijoDerecho(), arbol2.getHijoDerecho());
                }
                else return false; // el arbol 2 no coincide con el arbol1
            }
            return resultado;
        }
    }
    
    
    
    
    }