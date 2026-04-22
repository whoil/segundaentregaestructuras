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
        // Si no hay nodo en esta posición, se crea uno nuevo
        if(actual==null){

            return new  Nodo<>(dato);

        }
        //Comparamos de forma recursiva para decidir en qué dirección irá el dato

        // Si el dato es menor, irá a la izquierda
        if(actual.dato.compareTo(dato)>0){
            actual.izquierda=addNodo(actual.izquierda, dato);

        }
        // Si el dato es mayor, irá a la derecha
        else if (actual.dato.compareTo(dato)<0){
            actual.derecha=addNodo(actual.derecha, dato);
        }
        return actual;

    }

    //Inserta la raiz del árbol binario
    public void add(T dato){
        raiz = addNodo(raiz, dato);
    }


    protected int getAltura(Nodo<T> actual){
        if (actual==null){
            return 0;
        }
        int alturaIzquierda=getAltura(actual.izquierda);
        int alturaDerecha=getAltura(actual.derecha);
        return 1 + Math.max(alturaDerecha,alturaIzquierda);
    }



    public int getAlturaRaiz(){
        return getAltura(raiz);
    }


    protected  ListaSimplementeEnlazada<T> getListaPreOrden(){
        ListaSimplementeEnlazada<T> datos=new ListaSimplementeEnlazada<>();
        return getListaPreOrden(raiz, datos);
    }

   protected ListaSimplementeEnlazada<T> getListaPreOrden(Nodo<T> actual, ListaSimplementeEnlazada<T> datos){
        if(actual==null){
            return datos;
        }
        datos.add(actual.getDato());
        getListaPreOrden(actual.getIzquierda(), datos);
        getListaPreOrden(actual.getDerecha(), datos);
        return datos;

   }


}
