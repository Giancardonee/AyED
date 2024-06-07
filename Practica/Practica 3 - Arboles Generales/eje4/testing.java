package Practica3.eje4;

import clases_genericas.GeneralTree;

public class testing {
    public static void main(String[] args) {
    GeneralTree<AreaEmpresa> raiz = new GeneralTree<>(new AreaEmpresa("M", 14));

    // Agregar hijos a la raíz
    raiz.addChild(new GeneralTree<>(new AreaEmpresa("J", 13))); // Primer hijo de la raíz
    raiz.addChild(new GeneralTree<>(new AreaEmpresa("K", 25))); // Segundo hijo de la raíz
    raiz.addChild(new GeneralTree<>(new AreaEmpresa("L", 10))); // Tercer hijo de la raíz

    // Agregar hijos al primer hijo de la raíz
    raiz.getChildren().get(0).addChild(new GeneralTree<>(new AreaEmpresa("A", 4)));
    raiz.getChildren().get(0).addChild(new GeneralTree<>(new AreaEmpresa("B", 7)));
    raiz.getChildren().get(0).addChild(new GeneralTree<>(new AreaEmpresa("C", 5)));

    // Agregar hijos al segundo hijo de la raíz
    raiz.getChildren().get(1).addChild(new GeneralTree<>(new AreaEmpresa("D", 6)));
    raiz.getChildren().get(1).addChild(new GeneralTree<>(new AreaEmpresa("E", 10)));
    raiz.getChildren().get(1).addChild(new GeneralTree<>(new AreaEmpresa("F", 18)));

    // Agregar hijos al tercer hijo de la raíz
    raiz.getChildren().get(2).addChild(new GeneralTree<>(new AreaEmpresa("G", 9)));
    raiz.getChildren().get(2).addChild(new GeneralTree<>(new AreaEmpresa("H", 12)));
    raiz.getChildren().get(2).addChild(new GeneralTree<>(new AreaEmpresa("I", 19)));

        System.out.println("El mayor promedio es: "+AnalizadorArbol.devolverMaximoPromedio(raiz));
    }
    
}
