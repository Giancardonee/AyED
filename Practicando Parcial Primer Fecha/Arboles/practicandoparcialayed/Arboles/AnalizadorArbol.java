package practicandoparcialayed.Arboles;

import java.util.LinkedList;
import java.util.List;
import practicandoparcialayed.GeneralTree;
import practicandoparcialayed.Queue;

/*
    Este enunciado lo pense de la siguiente manera: 
    Primero crear la clase AreaEmpresa, con el constructor con parametros y getters.
    
    Despues, para la tecnica de recorridos, lo ideal seria usar un recorrido entre niveles,
    ya que queremos saber el promedio por nivel, y luego con ese promedio ir sacando el maximo promedio. 
    
Necesitariamos: Contar la cantidad de nodos por nivel y su suma por nivel. Con eso podemos sacar el promedio
Despues , necesitamos una variable max, para ir comparando. 
 */
public class AnalizadorArbol {

    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
        return (arbol == null || arbol.isEmpty()) ? -1 : promedioEntreNiveles(arbol);
    }

    private double promedioEntreNiveles(GeneralTree<AreaEmpresa> arbol) {
        double max = -1,promedioActual=0; int sumaNivel = 0,cantNodos = 0;
        GeneralTree<AreaEmpresa> aux;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            if (aux != null) {
                cantNodos++;
                sumaNivel += aux.getData().getTardanza();
                for (GeneralTree<AreaEmpresa> child : aux.getChildren()) {
                    cola.enqueue(child);
                }
            } else // aux es null ==> Estamos en un nuevo nivel
            {
                promedioActual= (sumaNivel / cantNodos);
                max = Math.max(max, promedioActual);
                cantNodos=0; sumaNivel=0;
                if (!cola.isEmpty()) {
                    cola.enqueue(null);      
                }
            }
        }
        return max;
    }
    
     public static void main(String[] args) {
        List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children1.add(new GeneralTree<>(new AreaEmpresa("A",4)));
        children1.add(new GeneralTree<>(new AreaEmpresa("B",7)));
        children1.add(new GeneralTree<>(new AreaEmpresa("C",5)));
        GeneralTree<AreaEmpresa> a1 = new GeneralTree<>(new AreaEmpresa("J",13), children1);
        
        List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<>();
        children2.add(new GeneralTree<>(new AreaEmpresa("D",6)));
        children2.add(new GeneralTree<>(new AreaEmpresa("E",10)));
        children2.add(new GeneralTree<>(new AreaEmpresa("F",18)));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<>(new AreaEmpresa("K",25), children2);
        
        List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<>();
        children3.add(new GeneralTree<>(new AreaEmpresa("G",9)));
        children3.add(new GeneralTree<>(new AreaEmpresa("H",12)));
        children3.add(new GeneralTree<>(new AreaEmpresa("I",19)));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<>(new AreaEmpresa("L",10), children3);
        
        List<GeneralTree<AreaEmpresa>> children4 = new LinkedList<>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<AreaEmpresa> a = new GeneralTree<>(new AreaEmpresa("M",14), children4);
        
        AnalizadorArbol arb = new AnalizadorArbol();
        System.out.println("El mayor promedio entre todos los valores promedios de los niveles es: " + arb.devolverMaximoPromedio(a));
    }

}
