package practicandoparcialayed;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> extends Sequence<T> {
     List<T> data;
     public Queue() {
        this.data = new ArrayList<T>();
     }
     // encolar
     public void enqueue(T dato) {
        data.add(dato);
     }
     // desencolar
     public T dequeue() {
        return data.remove(0);
     }
     
     public T primero() {
        return data.get(0);
     } 
     
     @Override
 public int size() {
    return data.size();
 }
 
 @Override
 public boolean isEmpty() {
    return data.size()==0;
 }
 
 @Override
 public String toString() {
    String str = "[";
    for(T d: data)
    str = str + d +", ";
    str = str.substring(0, str.length()-2)+"]";
 return str;
 }
}

