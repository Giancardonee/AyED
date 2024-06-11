package practicandoparcialayed.Arboles;

import practicandoparcialayed.BinaryTree;

public class ParcialArboles {

    public ParcialArboles() {

    }

    public static boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
        return (a1.isEmpty() || a2.isEmpty()) ? false : helper(a1, a2);
    }

    private static boolean helper(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
        if (!(a1.getData().equals(a2.getData()))) {
            return false;
        } else {
            boolean ok = true;
            if (a1.hasLeftChild()) {
                if (a2.hasLeftChild()) {
                    ok = helper(a1.getLeftChild(), a2.getLeftChild());
                } else {
                    return false;
                }
            }
            if (a1.hasRightChild()) {
                if (a2.hasRightChild()) {
                    ok = ok && helper(a1.getRightChild(), a2.getRightChild());
                } else {
                    return false;
                }
            }
            return ok;
        }
    }
  
    public static void main(String[] args) {
        System.out.println("Test Ejercicio8");
        ParcialArboles parcialArboles = new ParcialArboles();

        BinaryTree<Integer> ab1 = new BinaryTree<Integer>(4);
        ab1.addLeftChild(new BinaryTree<Integer>(2));
        ab1.addRightChild(new BinaryTree<Integer>(6));
        ab1.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab1.getLeftChild().addRightChild(new BinaryTree<Integer>(3));

        BinaryTree<Integer> ab2 = new BinaryTree<Integer>(4);
        ab2.addLeftChild(new BinaryTree<Integer>(2));
        ab2.addRightChild(new BinaryTree<Integer>(6));
        ab2.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab2.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab2.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab2.getRightChild().addRightChild(new BinaryTree<Integer>(8));

        BinaryTree<Integer> ab3 = new BinaryTree<Integer>(4);
        ab3.addLeftChild(new BinaryTree<Integer>(2));
        ab3.addRightChild(new BinaryTree<Integer>(6));
        ab3.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab3.getLeftChild().addRightChild(new BinaryTree<Integer>(3));

        BinaryTree<Integer> ab4 = new BinaryTree<Integer>(4);
        ab4.addLeftChild(new BinaryTree<Integer>(2));
        ab4.addRightChild(new BinaryTree<Integer>(6));
        ab4.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab4.getRightChild().addLeftChild(new BinaryTree<Integer>(5));

        BinaryTree<Integer> ab5 = new BinaryTree<Integer>();
        BinaryTree<Integer> ab6 = new BinaryTree<Integer>();

        BinaryTree<Integer> ab7 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> ab8 = new BinaryTree<Integer>();

        BinaryTree<Integer> ab9 = new BinaryTree<Integer>();
        BinaryTree<Integer> ab10 = new BinaryTree<Integer>(3);

        System.out.println("Ab1 es prefijo de ab2? " + parcialArboles.esPrefijo(ab1, ab2));
        System.out.println("Ab3 es prefijo de ab4? " + parcialArboles.esPrefijo(ab3, ab4));
        System.out.println("Ab5 es prefijo de ab6? " + parcialArboles.esPrefijo(ab5, ab6));
        System.out.println("Ab7 es prefijo de ab8? " + parcialArboles.esPrefijo(ab7, ab8));
        System.out.println("Ab9 es prefijo de ab10? "+ parcialArboles.esPrefijo(ab9, ab10));
        System.out.println("Ab7 es prefijo de ab10? "+ parcialArboles.esPrefijo(ab7, ab10) );
    }
}
