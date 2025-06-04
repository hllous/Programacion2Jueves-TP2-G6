package tests;

import interfaces.IArbol;
import models.Arbol;
import models.Persona;

public class TestArbol {
    public static void main(String[] args) {
        IArbol arbol = new Arbol();

        Persona[] personas = {
                new Persona("Lucas", 4520620, 22),
                new Persona("Ana", 25579521, 52),
                new Persona("Bruno", 32437232, 85),
                new Persona("Clara", 56547852, 40),
                new Persona("David", 30796138, 55),
                new Persona("Elena", 10649728, 80),
                new Persona("Fabian", 33649137, 36),
                new Persona("Gisela", 5251975, 3),
                new Persona("Hugo", 20376198, 55),
                new Persona("Irene", 27579365, 52),
                new Persona("Jorge", 35521647, 35),
                new Persona("Karina", 55230137, 2),
                new Persona("Lautaro", 3157770, 45),
                new Persona("Mara", 10000000, 95),
                new Persona("Nico", 95, 500)
        };


        /// 1


        System.out.println("1) Creacion del arbol");
        System.out.println("");
        System.out.println("    Inserto 15 personas");

        for (Persona p : personas) {
            arbol.insertar(p);
        }


        /// 2


        System.out.println("");
        System.out.println("2) Recorridos del arbol");
        System.out.println("");
        System.out.println("    Recorrido inOrden");
        System.out.println("");
        arbol.inOrden();

        System.out.println("");
        System.out.println("    Recorrido preOrden");
        System.out.println("");
        arbol.preOrden();

        System.out.println("");
        System.out.println("    Recorrido postOrden");
        System.out.println("");
        arbol.postOrden();


        ///  3


        System.out.println("");
        System.out.println("3) Busquedas y Eliminaciones");
        System.out.println("");
        System.out.println("    Buscar DNI N°55230137");
        System.out.println("");
        System.out.println(arbol.buscarPorDni(55230137));


        System.out.println("");
        System.out.println("    Buscar nombre 'Mara'");
        System.out.println("");
        System.out.println(arbol.buscarPorNombre("Mara"));

        System.out.println("");
        System.out.println("    Eliminando a David con dni N°30796138 y Fabian con dni N°33649137 e imprimiendo en preOrden");
        System.out.println("");

        System.out.println("    preOrden antes de eliminar\n");
        arbol.preOrden();
        arbol.eliminar(new Persona("David", 30796138, 55));
        arbol.eliminar(new Persona("Fabian", 33649137, 36));
        System.out.println("\n    preOrden despues de eliminar\n");
        arbol.preOrden();
    }
}
