package parciales.Parcial1;

import parciales.ClasesGenericas.BinaryTree;

public class Parcial {

    private BinaryTree<Integer> arbol;

    public Parcial(BinaryTree<Integer> a) {
        this.arbol = a;
    }

    public boolean resolver(int k) {
        return (this.arbol != null && !this.arbol.isEmpty()) ? helper(this.arbol, k, 0) : false;
    }

    private boolean helper(BinaryTree<Integer> a, int k, int sumaCamino) {
        boolean cumpleCondicion = true;
        int datoActual = a.getData();
        sumaCamino += datoActual;
        if (a.isLeaf() && sumaCamino != k) {
            return false; // no es Monodistante.
        } else {
            if (a.hasLeftChild()) {
                cumpleCondicion = helper(a.getLeftChild(), k, sumaCamino);
            }    
            if (a.hasRightChild() && cumpleCondicion) {
                cumpleCondicion = helper(a.getRightChild(), k, sumaCamino);
            }
        }
        return cumpleCondicion;
    }

    public static void main(String args[]) {
        BinaryTree<Integer> raiz = new BinaryTree<>(2);
        raiz.addLeftChild(new BinaryTree<>(1));
        raiz.addRightChild(new BinaryTree<>(2));

        //subarbol izq
        raiz.getLeftChild().addLeftChild(new BinaryTree<>(5));
        raiz.getLeftChild().addRightChild(new BinaryTree<>(5));

        //subarbol der
        raiz.getRightChild().addLeftChild(new BinaryTree<>(4));
        raiz.getRightChild().addRightChild(new BinaryTree<>(2));
        raiz.getRightChild().getRightChild().addRightChild(new BinaryTree<>(2));

        Parcial parcial1 = new Parcial(raiz);
        System.out.println(parcial1.resolver(8));
    }

}
