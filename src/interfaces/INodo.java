package interfaces;

public interface INodo<T> {

    /// Comentario para el profe:
    /// No sabemos que poner en los axiomas, quisimos hacerlos para ir practicando pero no se nos
    /// ocurre una manera de usarlos bien.

    /// Pre: Crear nodo
    /// Post: Devuelve el dato
    /// Axi: ---
    T getDato();

    /// Pre: Crear nodo
    /// Post: Se setea el dato en el nodo
    /// Axi: ---
    void setDato(T dato);

    /// Pre: ---
    /// Post: Devuelve el hijo izquierdo, sea null o no.
    /// Axi: ---
    INodo<T> getHijoIzquierdo();

    /// Pre: ---
    /// Post: Se setea el nodo como hijo izquierdo
    /// Axi: ---
    void setHijoIzquierdo(INodo<T> nodo);

    /// Pre: ---
    /// Post: Devuelve el hijo derecho, sea null o no.
    /// Axi: ---
    INodo<T> getHijoDerecho();

    /// Pre: ---
    /// Post: Se setea el nodo como hijo derecho
    /// Axi: ---
    void setHijoDerecho(INodo<T> nodo);


}
