import java.util.LinkedList;

public class Grafo
{
    LinkedList<Nodo> nodos = new LinkedList<Nodo>();

    Grafo(){}

    void agregaNodo(String data)
    {
        nodos.addLast(new Nodo(data));
    }

    void muesraGrafo()
    {
        for(Nodo n : this.nodos)
        {
            System.out.print(n.nombre + ": ");
            n.muestraVecinos();
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {

        
        
        
    }


    public static void prueba()
    {
        Grafo g = new Grafo();

        g.agregaNodo("N1");
        g.agregaNodo("N2");
        g.agregaNodo("N3");
        g.agregaNodo("N4");
        g.agregaNodo("N5");
        g.agregaNodo("N6");
        g.agregaNodo("N7");
        
        g.nodos.get(0).agregaVecino(g.nodos.get(2));
        g.nodos.get(0).agregaVecino(g.nodos.get(3));

        g.nodos.get(1).agregaVecino(g.nodos.get(4));
        g.nodos.get(1).agregaVecino(g.nodos.get(5));
        g.nodos.get(1).agregaVecino(g.nodos.get(6));

        g.nodos.get(3).agregaVecino(g.nodos.get(1));

        g.muesraGrafo();
    }

}