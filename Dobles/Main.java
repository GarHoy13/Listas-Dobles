public class Main {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        lista.insertaPrimerNodo("B");
        lista.insertaAntesPrimerNodo("A");
        lista.insertaAlFinal("D");
        lista.insertaEntreNodos("C","D");
        System.out.println("Lista original:");
        lista.imprimir();
        Node nodoBuscado = lista.buscarNodoPorValor("B");
        if (nodoBuscado != null) {
            System.out.println("Nodo encontrado por valor: " + nodoBuscado.name);
        } else {
            System.out.println("Nodo no encontrado por valor.");
        }

        lista.insertarDespuesDeNodo("B", "E");
        System.out.println("Lista después de insertar nodo después de 'B':");
        lista.imprimir();

        lista.intercambiarNodos("C", "E");
        System.out.println("Lista después de intercambiar 'C' por 'E':");
        lista.imprimir();
        
        String valorABorrar = "B";
        System.out.println("Borrando nodo con valor '" + valorABorrar + "'");
        lista.borrarNodoPorValor(valorABorrar);
        lista.imprimir();
    }
}
