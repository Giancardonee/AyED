/*

a) ¿En qué casos ArrayList ofrece un mejor rendimiento que LinkedList?

ArrayList proporciona un acceso aleatorio rápido a sus elementos utilizando índices. 
Esto significa que se puede acceder rápidamente a cualquier elemento en la lista
mediante su posición usando el método get(index). 

Mientras que LinkedList requiere recorrer los elementos secuencialmente desde el principio 
o el final de la lista hasta llegar al índice deseado, lo que puede ser menos eficiente para grandes listas.

b) 

LinkedList es más eficiente que ArrayList en términos de inserción y eliminación 
en el principio, final o medio de la lista, así como en términos de uso de memoria para listas pequeñas. 
Sin embargo, ArrayList generalmente supera a LinkedList en términos de 
acceso aleatorio rápido y mejor rendimiento de iteración.

c) ¿Qué diferencia encuentra en el uso de la memoria en ArrayList y LinkedList?

ArrayList tiende a ser más eficiente en términos de uso de memoria para grandes colecciones de datos 
debido a su asignación de memoria contigua, mientras que LinkedList puede tener un uso de memoria 
ligeramente mayor debido a la sobrecarga asociada con la estructura de nodos enlazados
y la asignación dinámica de memoria para cada nodo. 
Sin embargo, LinkedList puede ser más eficiente en términos de memoria para listas pequeñas 
debido a que no desperdicia espacio como en el caso de ArrayList,
donde el arreglo subyacente puede tener una capacidad inicial mayor que el número de elementos.

d) 

 Si se necesita acceso aleatorio rápido y una buena eficiencia de iteración,
ArrayList puede ser la mejor opción. 

Si necesitas una alta eficiencia en operaciones de inserción y eliminación, 
especialmente al principio, al final o en el medio de la lista, LinkedList puede ser la mejor opcion.



*/