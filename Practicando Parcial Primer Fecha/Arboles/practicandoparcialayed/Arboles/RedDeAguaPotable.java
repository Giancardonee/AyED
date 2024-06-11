  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandoparcialayed.Arboles;

import java.util.LinkedList;
import java.util.List;
import practicandoparcialayed.GeneralTree;

/**
 *
 * @author Usuario
 */
public class RedDeAguaPotable {
    GeneralTree<Character> arbol;
    
    public RedDeAguaPotable (GeneralTree<Character> a)
    {
        this.arbol = a;
    }
    
    public double minimoCaudal (double caudal)
    {
        if (arbol.isEmpty() || arbol == null) return -1;
        else if (arbol.isLeaf()) return caudal;
        else return caudalHelper(caudal,this.arbol);      
    }
    
    private double caudalHelper (double valorCaudal, GeneralTree<Character> arbol)
    {
        double min = Double.MAX_VALUE;
        if (arbol.isLeaf()) min = Math.min(valorCaudal,min);
        else
        {
            double caudalRecursion=0;
            for (GeneralTree<Character> child : arbol.getChildren()){
               caudalRecursion = caudalHelper((valorCaudal/arbol.getChildren().size()), child);
               min = Math.min(min, caudalRecursion);
            }
        }
        return min;
    }
    
      public static void main(String[] args) {
        GeneralTree<Character> ab1 = new GeneralTree<>('B');
        
        List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
        subChildren1.add(new GeneralTree<Character>('L'));
        GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('F'));
        subChildren2.add(subAb1);
        GeneralTree<Character> ab2 = new GeneralTree<Character>('C', subChildren2);
        
        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(new GeneralTree<Character>('M'));
        subChildren3.add(new GeneralTree<Character>('N'));
        GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
        List<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
        subChildren4.add(new GeneralTree<Character>('H'));
        subChildren4.add(new GeneralTree<Character>('I'));
        subChildren4.add(subAb2);
        subChildren4.add(new GeneralTree<Character>('K'));
        subChildren4.add(new GeneralTree<Character>('P'));
        GeneralTree<Character> ab3 = new GeneralTree<Character>('D', subChildren4);
        
        GeneralTree<Character> ab4 = new GeneralTree<Character>('E');
        
        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(ab1);
        arbol.add(ab2);
        arbol.add(ab3);
        arbol.add(ab4);
        GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
        
        RedDeAguaPotable eje6 = new RedDeAguaPotable(ab);
        
          System.out.println(eje6.minimoCaudal(1000.0));
      }
}


   