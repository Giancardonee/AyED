package practica1.eje9Prac1;

import java.util.LinkedList;
import java.util.List;

public class Stack extends Sequence{
private List<Character> pila;

    public Stack() {
        pila = new LinkedList<Character>();
    }
    
    public void push(char c) {
        pila.add(c);
        super.incSize();
    }
    
    public Character pop() {
        super.decSize();
        if (!super.isEmpty()) {
            char c = pila.get(pila.size() - 1);
            pila.remove(pila.size() - 1);
            return c;
        } else {
            return null; // Devolver null si la pila está vacía
        }
    }
}
