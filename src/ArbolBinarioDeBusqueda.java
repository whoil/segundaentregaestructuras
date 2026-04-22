public class ArbolBinarioDeBusqueda<T extends Comparable<T>>{
    private Nodo<T> raiz;


    public ArbolBinarioDeBusqueda(Nodo<T> raiz){
        this.raiz=raiz;
    }


    public boolean isEmpty(){
        return raiz==null; // devuelve true si no hay nodo raiz ( el árbol es vacío)
    }





    // Inserta un dato en el árbol de forma recursiva
    protected Nodo<T> addNodo(Nodo<T> actual,T dato){
        //Si no exise ningún nodo se crea la raiz
        if(actual==null){

            return new  Nodo<>(dato);

        }
        //Comparamos de forma recursiva para decidir en qué dirección irá el dato

        //Si es menor irá a la derecha
        if(actual.dato.compareTo(dato)>0){
            actual.izquierda=addNodo(actual.izquierda, dato);

        }
        //Si es mayor irá a la izquierda
        else if (actual.dato.compareTo(dato)<0){
            actual.derecha=addNodo(actual.derecha, dato);
        }
        return actual;

    }


    //Inserta la raiz del árbol binario
    public void add(T dato){
        raiz = addNodo(raiz, dato);
    }






}
