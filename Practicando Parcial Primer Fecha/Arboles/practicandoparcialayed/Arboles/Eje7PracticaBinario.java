package practicandoparcialayed.Arboles;

import practicandoparcialayed.BinaryTree;

public class Eje7PracticaBinario {

    private BinaryTree<Integer> arb;

    public Eje7PracticaBinario(BinaryTree<Integer> arbol) {
        this.arb = arbol;
    }

    
    public boolean isLeftTree(int num)
    {
        return arb.isEmpty() || arb == null ? false : helper(num);
    }
    
    
    private boolean helper (int num)
    {
        BinaryTree<Integer> raiz = buscarRaiz(arb, num);
        if (raiz != null) // si se encontro el valor, tendremos la raiz distinta de null 
        {
           int contadorHI = -1 , contadorHD = -1 ;
            if (raiz.hasLeftChild())
                contadorHI = contarUnicoHijo(raiz.getLeftChild());
    // Si contadorHI=-1, no tiene sentido evaluar el subarbol derecho porque nunca podria retornar true. 
            if (raiz.hasRightChild() && contadorHI > -1)        
                contadorHD = contarUnicoHijo(raiz.getRightChild());
            return contadorHI > contadorHD; 
        }
        else return false;
    }
   

    /*
        Esta busqueda no me gusto tanto, siento que se podria hacer mejor. 
    */
    private BinaryTree<Integer> buscarRaiz(BinaryTree<Integer> a, int valorBuscado) {
        if (a.getData().equals(valorBuscado)) {
            return a;
        } else {
            BinaryTree<Integer> arbolReturn = null;
            if (a.hasLeftChild()) {
                arbolReturn = buscarRaiz(a.getLeftChild(), valorBuscado);
            }
            if (a.hasRightChild() && (arbolReturn == null)) // si arbolReturn es null todavia, significa que no se encontro en el Hijo Izq
            {
                arbolReturn = buscarRaiz(a.getRightChild(), valorBuscado);
            }
            return arbolReturn;
        }
    }

    private int contarUnicoHijo(BinaryTree<Integer> a) {
        if (a.isLeaf()) {
            return 0;
        } else {
            int suma = 0;
            if (a.hasLeftChild() && (!a.hasRightChild())) // si tiene HI pero no HD
            {
                suma += contarUnicoHijo(a.getLeftChild()) + 1;
            } else if (a.hasRightChild() && (!a.hasLeftChild()))// si tiene HD pero no HI
            {
                suma += contarUnicoHijo(a.getRightChild()) + 1;
            } else {
                suma += contarUnicoHijo(a.getLeftChild()) + contarUnicoHijo(a.getRightChild());// sino es porque tiene los dos hijos
            }
            return suma;
        }
    }

    
    //===================================================================
    /* 
    Este para mi es mas eficiente. Es mas complicado de entenderlo.
    */
    public boolean isLeftTreeV2(int num) {
        if (arb.isEmpty() || arb == null) {
            return false;
        } else {
            BinaryTree<Integer> raizEncontrada = buscarRaiz(arb, num);
            if (raizEncontrada != null)// es porque encontre la raiz con el valor buscado
            {
                if (raizEncontrada.hasLeftChild()) {
                    int contadorHD = 0;
                    int contadorHI = 0;

                    contadorHI = contarUnicoHijo(arb.getLeftChild());
                    if (raizEncontrada.hasRightChild()) {
                        contadorHD = contarUnicoHijo(arb.getRightChild());
                    } else {
                        contadorHD = -1; // si no tiene subArbol derecho, retorna -1;
                    }
                    return contadorHI > contadorHD;
                } else {
                    return false; // si no tiene subarbol izquierdo siempre devuelve false, no tendria sentido evaluar el derecho.
                }
            } else {
                return false;
            }
        }
    }
    
        private int contarUnicoHijoV2(BinaryTree<Integer> a) {
        if (a.isLeaf()) {
            return 0;
        } else {
            int suma = 0;
            if (a.hasLeftChild() && (!a.hasRightChild())) // si tiene HI pero no HD
            {
                suma += contarUnicoHijo(a.getLeftChild()) + 1;
            } else if (a.hasRightChild() && (!a.hasLeftChild()))// si tiene HD pero no HI
            {
                suma += contarUnicoHijo(a.getRightChild()) + 1;
            } else {
                suma += contarUnicoHijo(a.getLeftChild()) + contarUnicoHijo(a.getRightChild());// sino es porque tiene los dos hijos
            }
            return suma;
        }
    }
    //===================================================================     
        
}
