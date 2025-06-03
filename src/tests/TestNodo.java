package tests;

import interfaces.INodo;
import models.Nodo;

public class TestNodo {
    public static void main(String[] args) {

        System.out.println("--- TestNodo ---");
        System.out.println("");
        System.out.println("1) Test con Integers");
        System.out.println("    - 'nodoUnoInt' sera el nodo raiz y los otros dos seran los hijos");
        System.out.println("    - Luego mostrare informacion de cada uno, y cambiare de lado sus hijos");

        INodo<Integer> nodoUnoInt = new Nodo<>(5);
        INodo<Integer> nodoDosInt = new Nodo<>(10);
        INodo<Integer> nodoTresInt = new Nodo<>(7);

        nodoUnoInt.setHijoIzquierdo(nodoDosInt);
        nodoUnoInt.setHijoDerecho(nodoTresInt);

        System.out.println("\n"+"Nodos:" +"\n"+
                "     "+ nodoUnoInt.getDato()+ "     " +"\n"+
                "   /  " + " \\  " +"\n"+
                nodoUnoInt.getHijoIzquierdo().getDato() + "      " + nodoUnoInt.getHijoDerecho().getDato() + "\n");

        System.out.println("Ahora cambio los nodos de lugar e imprimo de vuelta");
        nodoUnoInt.setHijoIzquierdo(nodoTresInt);
        nodoUnoInt.setHijoDerecho(nodoDosInt);

        System.out.println("\n"+"Nodos:" +"\n"+
                "    "+ nodoUnoInt.getDato()+ "     " +"\n"+
                "  /  " + " \\  " +"\n"+
                nodoUnoInt.getHijoIzquierdo().getDato() + "      " + nodoUnoInt.getHijoDerecho().getDato()+ "\n");


        System.out.println("2) Test con Strings");
        System.out.println("    - La idea es formar 'Hola Mundo' y 'Hola Profe' usando los nodos, sin escribir el texto plano");
        INodo<String> nodoUnoString = new Nodo<>("Hola");
        INodo<String> nodoDosString = new Nodo<>("Mundo");
        INodo<String> nodoTresString = new Nodo<>("Profe");

        nodoUnoString.setHijoIzquierdo(nodoDosString);
        nodoUnoString.setHijoDerecho(nodoTresString);

        System.out.println("\n"+"Nodos:" +"\n"+
                "     "+ nodoUnoString.getDato()+ "     " +"\n"+
                "  /  " + "      \\  " +"\n"+
                nodoUnoString.getHijoIzquierdo().getDato() + "      " + nodoUnoString.getHijoDerecho().getDato());

        System.out.println("Ahora imprimo solo accediendo a los datos las dos oraciones:");
        System.out.println(nodoUnoString.getDato() + " " +nodoUnoString.getHijoIzquierdo().getDato());
        System.out.println(nodoUnoString.getDato() + " " +nodoUnoString.getHijoDerecho().getDato());

        System.out.println("");
        System.out.println("--- Fin TestNodo ---");
    }
}
