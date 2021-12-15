import java.util.LinkedList;

public class Busqueda {
    
    Grafo arbol = new Grafo();
    LinkedList<Nodo> visitados = new LinkedList<Nodo>();
    LinkedList<Nodo> frontera = new LinkedList<Nodo>();

    void generaHijos(Nodo n)
    {
        
    }

    public static void main(String[] args) {
        
        Busqueda buscar = new Busqueda();
        Grafo arb = buscar.arbol;

        arb.agregaNodo("Inicial");
        System.out.println(arb.nodos.getFirst().imprimeEstado());
        
    }

}