package practica1.eje9Prac1;
public class Sequence {
    private int size; 
    private boolean isEmpty; 

    public Sequence() {
        this.size=0;
    }    
    
    public int getSize() {
        return size;
    }
    
    public void incSize(){
        this.size++;
    }
    
    public void decSize (){
        this.size--;
    }
    public boolean isEmpty() {
        return getSize() == 0;
    }

}
