import java.util.LinkedList;
public class Rumania {

    Grafo arbol = new Grafo();
    LinkedList<Nodo> visitados = new LinkedList<Nodo>();
    LinkedList<Nodo> frontera = new LinkedList<Nodo>();

    public static void main(String[] args) {
        
        Rumania rum = new Rumania();

        rum.arbol.agregaNodo("Oradea");
        rum.arbol.agregaNodo("Zerind");
        rum.arbol.agregaNodo("Arad");
        rum.arbol.agregaNodo("Sibiu");
        rum.arbol.agregaNodo("Timisoara");
        rum.arbol.agregaNodo("Lugoj");
        rum.arbol.agregaNodo("Mehadia");
        rum.arbol.agregaNodo("Drobeta");
        rum.arbol.agregaNodo("Fagaras");
        rum.arbol.agregaNodo("Rimnicu Vilcea");
        rum.arbol.agregaNodo("Craiova");
        rum.arbol.agregaNodo("Pitesti");
        rum.arbol.agregaNodo("Bucharest");
        rum.arbol.agregaNodo("Giurgiu");
        rum.arbol.agregaNodo("Urziceni");
        rum.arbol.agregaNodo("Hirsova");
        rum.arbol.agregaNodo("Vaslui");
        rum.arbol.agregaNodo("Iasi");
        rum.arbol.agregaNodo("Neamt");

    }
    
}
