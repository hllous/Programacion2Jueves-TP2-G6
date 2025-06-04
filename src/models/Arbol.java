package models;

import interfaces.IArbol;
import interfaces.INodo;

public class Arbol implements IArbol {

    private INodo<Persona> raiz;

    // Metodos insertar recursivo

    @Override
    public void insertar(Persona dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private INodo<Persona> insertarRecursivo(INodo<Persona> actual, Persona persona) {
        if (actual == null) return new Nodo<>(persona);

        int dniNuevo = persona.getDni();
        int dniActual = actual.getDato().getDni();

        if (dniNuevo < dniActual) {
            actual.setHijoIzquierdo(insertarRecursivo(actual.getHijoIzquierdo(), persona));
        } else if (dniNuevo > dniActual) {
            actual.setHijoDerecho(insertarRecursivo(actual.getHijoDerecho(), persona));
        } else {
            System.out.println("DNI duplicado: " + persona);
            return actual;
        }

        return balancear(actual);
    }

    // Metodos eliminar

    @Override
    public void eliminar(Persona dato) {
        raiz = eliminarRec(raiz, dato.getDni());
    }

    private INodo eliminarRec(INodo<Persona> nodo, int dni) {
        if (nodo == null) return null;

        int dniActual = nodo.getDato().getDni();

        if (dni < dniActual) {
            nodo.setHijoIzquierdo(eliminarRec(nodo.getHijoIzquierdo(), dni));
        } else if (dni > dniActual) {
            nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), dni));
        } else {
            // Caso 1: sin hijos
            if (nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null) {
                return null;
            }

            // Caso 2: un hijo
            if (nodo.getHijoIzquierdo() == null) return nodo.getHijoDerecho();
            if (nodo.getHijoDerecho() == null) return nodo.getHijoIzquierdo();

            // Caso 3: dos hijos
            INodo<Persona> sucesor = obtenerMinimo(nodo.getHijoDerecho());
            nodo.setDato(sucesor.getDato());
            nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), sucesor.getDato().getDni()));
        }
        return nodo;
    }

    private INodo<Persona> obtenerMinimo(INodo nodo) {
        while (nodo.getHijoIzquierdo() != null) {
            nodo = nodo.getHijoIzquierdo();
        }
        return nodo;
    }

    // Metodos Buscar
    //      Buscar por dni recursivo

    @Override
    public Persona buscarPorDni(int dato) {
        return buscarDniRec(raiz, dato);
    }

    private Persona buscarDniRec(INodo<Persona> actual, int dni) {
        if (actual == null) return null;
        int dniActual = actual.getDato().getDni();

        if (dni == dniActual) {
            return actual.getDato();
        }
        if (dni < dniActual) {
            return buscarDniRec(actual.getHijoIzquierdo(), dni);
        }
        else {
            return buscarDniRec(actual.getHijoDerecho(), dni);
        }
    }

    //      Buscar por nombre recursivo

    @Override
    public Persona buscarPorNombre(String nombre) {
        return buscarNombreRec(raiz, nombre);
    }

    private Persona buscarNombreRec(INodo<Persona> actual, String nombre) {
        if (actual == null) return null;

        if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
            return actual.getDato();
        }

        Persona izq = buscarNombreRec(actual.getHijoIzquierdo(), nombre);
        if (izq != null) return izq;

        return buscarNombreRec(actual.getHijoDerecho(), nombre);
    }

    // Procedimientos inOrden, preOrden y postOrden recursivos

    @Override
    public void preOrden() {
        preordenRec(raiz);
    }

    private void preordenRec(INodo<Persona> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato().toString() + " \n");
            preordenRec(nodo.getHijoIzquierdo());
            preordenRec(nodo.getHijoDerecho());
        }
    }


    @Override
    public void inOrden() {
        inordenRec(raiz);
    }

    private void inordenRec(INodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.getHijoIzquierdo());
            System.out.print(nodo.getDato().toString() + " \n");
            inordenRec(nodo.getHijoDerecho());
        }
    }


    @Override
    public void postOrden() {
        postordenRec(raiz);
    }

    private void postordenRec(INodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.getHijoIzquierdo());
            postordenRec(nodo.getHijoDerecho());
            System.out.print(nodo.getDato().toString() + " \n");
        }
    }

    // Metodos Balanceo

    private int altura(INodo<Persona> nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.getHijoIzquierdo()), altura(nodo.getHijoDerecho()));
    }

    private int balanceFactor(INodo<Persona> nodo) {
        if (nodo == null) return 0;
        return altura(nodo.getHijoIzquierdo()) - altura(nodo.getHijoDerecho());
    }

    private INodo<Persona> rotarDerecha(INodo<Persona> y) {
        INodo<Persona> x = y.getHijoIzquierdo();
        INodo<Persona> T2 = x.getHijoDerecho();

        x.setHijoDerecho(y);
        y.setHijoIzquierdo(T2);

        return x;
    }

    private INodo<Persona> rotarIzquierda(INodo<Persona> x) {
        INodo<Persona> y = x.getHijoDerecho();
        INodo<Persona> T2 = y.getHijoIzquierdo();

        y.setHijoIzquierdo(x);
        x.setHijoDerecho(T2);

        return y;
    }

    private INodo<Persona> balancear(INodo<Persona> nodo) {
        int balance = balanceFactor(nodo);

        // Izquierda
        if (balance > 1) {
            if (balanceFactor(nodo.getHijoIzquierdo()) < 0) {
                nodo.setHijoIzquierdo(rotarIzquierda(nodo.getHijoIzquierdo()));
            }
            return rotarDerecha(nodo);
        }

        // Derecha
        if (balance < -1) {
            if (balanceFactor(nodo.getHijoDerecho()) > 0) {
                nodo.setHijoDerecho(rotarDerecha(nodo.getHijoDerecho()));
            }
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

}
