package Practica3.eje8;

import clases_genericas.GeneralTree;
import java.util.List;

public class Navidad {

    GeneralTree<Integer> abeto;

    public Navidad(GeneralTree<Integer> ab) {
        this.abeto = ab;
    }

    public String esAbetoNavidenio() {  
        if ((this.abeto.isEmpty()) || (this.abeto == null) || this.abeto.isLeaf())  return "No";
        else return esAbetoAux(this.abeto) == true ? "Si" : "No";   
    }

    private boolean esAbetoAux(GeneralTree<Integer> abeto) {
        int cantHojas = 0;
        List<GeneralTree<Integer>> children = abeto.getChildren();
        for (GeneralTree<Integer> child : children) {
             if (child.isLeaf())  cantHojas++;
             else if (!esAbetoAux(child)) return false; 
        }
        return cantHojas >= 3;
    }

}
