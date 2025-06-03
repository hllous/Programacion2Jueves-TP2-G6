package interfaces;

public interface IArbol<T> {
    /// Comentario para el profe:
    /// No sabemos que poner en los axiomas, quisimos hacerlos para ir practicando pero no se nos
    /// ocurre una manera de usarlos bien.

    /// Pre: El dato no debe ser null
    /// Post: Ingresa el dato al arbol
    /// Axi: ---
    void insertar(T dato);

    /// Pre: El dato no debe ser null
    /// Post: Se elimina el nodo con ese dato
    /// Axi: ---
    void eliminar(T dato);

    /// Pre: El dato no debe ser null
    /// Post: Devuelve el nodo donde esta el dato
    /// Axi: ---
    INodo buscar(T dato);

    /// Pre: Tiene que existir al menos un nodo
    /// Post: Imprime el arbol en preOrder
    /// Axi: ---
    void preOrden();

    /// Pre: Tiene que existir al menos un nodo
    /// Post: Imprime el arbol en inOrder
    /// Axi: ---
    void inOrden();

    /// Pre: Tiene que existir al menos un nodo
    /// Post: Imprime el arbol en postOrder
    /// Axi: ---
    void postOrden();

}