package models;

import interfaces.INodo;

public class Nodo<T> implements INodo<T> {

    private T dato;
    private INodo<T> hijoIzquierdo;
    private INodo<T> hijoDerecho;

    public Nodo(T dato) {
        this.dato = dato;
        this.hijoIzquierdo =null;
        this.hijoDerecho =null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) { this.dato = dato; }

    public INodo<T> getHijoIzquierdo() { return hijoIzquierdo; }

    public void setHijoIzquierdo(INodo<T> hijoIzquierdo) { this.hijoIzquierdo = hijoIzquierdo; }

    public INodo<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(INodo<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
