package Practica3.eje6;

import clases_genericas.GeneralTree;
import java.util.List;

public class RedDeAguaPotable {
    private GeneralTree<Character> red;
    
    public RedDeAguaPotable(GeneralTree<Character> red){
        this.red = red;
    }
    
    public double minimoCaudal (double Caudal){
        if  ((this.red == null) || (this.red.isEmpty())) return -1;
        else return helperMinimoCaudal(Caudal,this.red);
    }
    
    
    private double helperMinimoCaudal (double caudal,GeneralTree<Character> nodo){
        double min = Double.MAX_VALUE;
        if (nodo.isLeaf()){
            return caudal;
        }
        else{
            int cantHijos = nodo.getChildren().size();
            double caudalHijos = (caudal / cantHijos); 
            List<GeneralTree<Character>> children = nodo.getChildren();
            for (GeneralTree<Character> child : children){
               double caudalActual = helperMinimoCaudal(caudalHijos, child); 
               min = Math.min(min, caudalActual);
            }
        }
        return min;
    } 
}
