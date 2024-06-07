package Practica2.eje7;

import clases_genericas.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;
    
    public ParcialArboles(BinaryTree<Integer> a){
        this.arbol = a;
    }
    
    public boolean isLeftTree(int num){
        if (this.arbol.isEmpty()) return false;
        else{
            BinaryTree<Integer> raiz = buscarRaiz( num,this.arbol);
            return raiz==null ? false : cumpleCondicion(raiz);  
        }
    }
    
    private boolean cumpleCondicion (BinaryTree<Integer> arbol){
        int subIzq = contarUnHijo(arbol.getHijoIZquierdo());
        int subDer = contarUnHijo(arbol.getHijoDerecho()); 
        return subIzq > subDer;
    }
    
    private int contarUnHijo (BinaryTree<Integer> arbol){
        if (arbol == null) return -1;
        else{
            int suma=0;
            if (arbol.tieneHijoIzq()){
                suma += contarUnHijo(arbol.getHijoIZquierdo());
                if (!arbol.tieneHijoDer()) 
                    suma++;
            }
            if (arbol.tieneHijoDer() ){
                suma+=contarUnHijo(arbol.getHijoDerecho());  
                if (!arbol.tieneHijoIzq())
                    suma++;
            } 
           return suma;
        }
    }
    
    private BinaryTree<Integer> buscarRaiz(int num,BinaryTree<Integer> a){
        if (a.getData() == num) return a;
        else{
            BinaryTree<Integer> result = null;
            if (a.tieneHijoIzq()) 
                result = buscarRaiz(num, a.getHijoIZquierdo());
            if (a.tieneHijoDer())
                result = buscarRaiz(num, a.getHijoDerecho());
            return result;
        }
    }
    
} 
