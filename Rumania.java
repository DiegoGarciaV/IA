import java.util.LinkedList;
public class Rumania {

    Grafo arbol = new Grafo();
    LinkedList<Nodo> visitados = new LinkedList<Nodo>();
    LinkedList<NodoPeso> frontera = new LinkedList<NodoPeso>();

    boolean exito(Nodo n)
    {
        return n.nombre.equals("Neamt");

    }

    void imprimeFrontera(LinkedList<NodoPeso> L)
    {
        int i = 0;
        for(NodoPeso n : L)
        {
            System.out.print(n.nNodo.nombre + " " + n.peso);
            if(i++ < L.size()-1)
                System.out.print(", ");
        }
    }

    int nodoEnFrontera(Nodo n)
    {
        int i= 0;
        for(NodoPeso nNodoP : this.frontera)
        {
            if(nNodoP.nNodo.equals(n))
                return i;
            else
                i++;
        }
        return -1;
    }

    void ordenaFrontera()
    {
        
        int i = 0,indice = 0,k = 0;
        System.out.println("Orden: ");
        while(k < this.frontera.size())
        {
            indice = 0;
            double min = 10000000.0;
            for(i = 0;i< this.frontera.size() - k ;i++)
            {
                if(this.frontera.get(i).peso < min)
                {
                    min = this.frontera.get(i).peso;
                    indice = i;
                }
            }
            NodoPeso minNodo = this.frontera.get(indice);
            System.out.println(minNodo.nNodo.nombre + " -> " + minNodo.peso);
            this.frontera.addLast(minNodo);
            this.frontera.remove(indice);
            k++;

        }
        System.out.println("");
            

    }

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
        rum.arbol.agregaNodo("Eforie");
        rum.arbol.agregaNodo("Vaslui");
        rum.arbol.agregaNodo("Iasi");
        rum.arbol.agregaNodo("Neamt");
        rum.arbol.agregaNodo("CiudadPerdida");

        rum.arbol.getNodo("Oradea").agregaVecinoCoste(rum.arbol.getNodo("Zerind"), 71);
        rum.arbol.getNodo("Oradea").agregaVecinoCoste(rum.arbol.getNodo("Sibiu"), 151);

        rum.arbol.getNodo("Zerind").agregaVecinoCoste(rum.arbol.getNodo("Oradea"), 71);
        rum.arbol.getNodo("Zerind").agregaVecinoCoste(rum.arbol.getNodo("Arad"), 75);

        rum.arbol.getNodo("Arad").agregaVecinoCoste(rum.arbol.getNodo("Zerind"), 75);
        rum.arbol.getNodo("Arad").agregaVecinoCoste(rum.arbol.getNodo("Timisoara"), 118);
        rum.arbol.getNodo("Arad").agregaVecinoCoste(rum.arbol.getNodo("Sibiu"), 140);

        rum.arbol.getNodo("Timisoara").agregaVecinoCoste(rum.arbol.getNodo("Arad"), 118);
        rum.arbol.getNodo("Timisoara").agregaVecinoCoste(rum.arbol.getNodo("Lugoj"), 111);

        rum.arbol.getNodo("Lugoj").agregaVecinoCoste(rum.arbol.getNodo("Timisoara"), 111);
        rum.arbol.getNodo("Lugoj").agregaVecinoCoste(rum.arbol.getNodo("Mehadia"), 70);

        rum.arbol.getNodo("Mehadia").agregaVecinoCoste(rum.arbol.getNodo("Lugoj"), 70);
        rum.arbol.getNodo("Mehadia").agregaVecinoCoste(rum.arbol.getNodo("Drobeta"), 75);

        rum.arbol.getNodo("Drobeta").agregaVecinoCoste(rum.arbol.getNodo("Mehadia"), 75);
        rum.arbol.getNodo("Drobeta").agregaVecinoCoste(rum.arbol.getNodo("Craiova"), 120);

        rum.arbol.getNodo("Craiova").agregaVecinoCoste(rum.arbol.getNodo("Drobeta"), 120);
        rum.arbol.getNodo("Craiova").agregaVecinoCoste(rum.arbol.getNodo("Rimnicu Vilcea"), 146);
        rum.arbol.getNodo("Craiova").agregaVecinoCoste(rum.arbol.getNodo("Pitesti"), 138);

        rum.arbol.getNodo("Sibiu").agregaVecinoCoste(rum.arbol.getNodo("CiudadPerdida"), 20);
        rum.arbol.getNodo("Sibiu").agregaVecinoCoste(rum.arbol.getNodo("Oradea"), 151);
        rum.arbol.getNodo("Sibiu").agregaVecinoCoste(rum.arbol.getNodo("Arad"), 140);
        rum.arbol.getNodo("Sibiu").agregaVecinoCoste(rum.arbol.getNodo("Rimnicu Vilcea"), 80);
        rum.arbol.getNodo("Sibiu").agregaVecinoCoste(rum.arbol.getNodo("Fagaras"), 99);
        

        rum.arbol.getNodo("CiudadPerdida").agregaVecinoCoste(rum.arbol.getNodo("Sibiu"), 20);
        rum.arbol.getNodo("CiudadPerdida").agregaVecinoCoste(rum.arbol.getNodo("Neamt"), 50);

        rum.arbol.getNodo("Rimnicu Vilcea").agregaVecinoCoste(rum.arbol.getNodo("Sibiu"), 80);
        rum.arbol.getNodo("Rimnicu Vilcea").agregaVecinoCoste(rum.arbol.getNodo("Craiova"), 146);
        rum.arbol.getNodo("Rimnicu Vilcea").agregaVecinoCoste(rum.arbol.getNodo("Pitesti"), 97);
        
        rum.arbol.getNodo("Fagaras").agregaVecinoCoste(rum.arbol.getNodo("Sibiu"), 99);
        rum.arbol.getNodo("Fagaras").agregaVecinoCoste(rum.arbol.getNodo("Bucharest"), 211);
        
        rum.arbol.getNodo("Pitesti").agregaVecinoCoste(rum.arbol.getNodo("Rimnicu Vilcea"), 97);
        rum.arbol.getNodo("Pitesti").agregaVecinoCoste(rum.arbol.getNodo("Craiova"), 138);
        rum.arbol.getNodo("Pitesti").agregaVecinoCoste(rum.arbol.getNodo("Bucharest"), 101);

        rum.arbol.getNodo("Bucharest").agregaVecinoCoste(rum.arbol.getNodo("Pitesti"), 101);
        rum.arbol.getNodo("Bucharest").agregaVecinoCoste(rum.arbol.getNodo("Fagaras"), 211);
        rum.arbol.getNodo("Bucharest").agregaVecinoCoste(rum.arbol.getNodo("Giurgiu"), 90);
        rum.arbol.getNodo("Bucharest").agregaVecinoCoste(rum.arbol.getNodo("Urziceni"), 85);

        rum.arbol.getNodo("Giurgiu").agregaVecinoCoste(rum.arbol.getNodo("Bucharest"), 90);

        rum.arbol.getNodo("Urziceni").agregaVecinoCoste(rum.arbol.getNodo("Bucharest"), 85);
        rum.arbol.getNodo("Urziceni").agregaVecinoCoste(rum.arbol.getNodo("Hirsova"), 98);
        rum.arbol.getNodo("Urziceni").agregaVecinoCoste(rum.arbol.getNodo("Vaslui"), 142);

        rum.arbol.getNodo("Hirsova").agregaVecinoCoste(rum.arbol.getNodo("Urziceni"), 98);
        rum.arbol.getNodo("Hirsova").agregaVecinoCoste(rum.arbol.getNodo("Eforie"), 86);

        rum.arbol.getNodo("Eforie").agregaVecinoCoste(rum.arbol.getNodo("Hirsova"), 86);

        rum.arbol.getNodo("Vaslui").agregaVecinoCoste(rum.arbol.getNodo("Urziceni"), 142);
        rum.arbol.getNodo("Vaslui").agregaVecinoCoste(rum.arbol.getNodo("Iasi"), 92);

        rum.arbol.getNodo("Iasi").agregaVecinoCoste(rum.arbol.getNodo("Vaslui"), 92);
        rum.arbol.getNodo("Iasi").agregaVecinoCoste(rum.arbol.getNodo("Neamt"), 87);

        rum.arbol.getNodo("Neamt").agregaVecinoCoste(rum.arbol.getNodo("Iasi"), 87);
        rum.arbol.getNodo("Neamt").agregaVecinoCoste(rum.arbol.getNodo("CiudadPerdida"), 50);

        //rum.arbol.muesraGrafo();
        
        rum.frontera.addFirst(new NodoPeso(rum.arbol.nodos.getFirst(),0));
        while(rum.frontera.size()>0)
        {
            System.out.print("Frontera: ");
            rum.imprimeFrontera(rum.frontera);
            System.out.println("");
            NodoPeso explorando = rum.frontera.pop();
            double w = explorando.peso;
            
            if(rum.exito(explorando.nNodo))
            {   
                System.out.println("Estado objetivo alcanzado, costo: " + w);
                break;
            }
            

            rum.visitados.addLast(explorando.nNodo);
            System.out.println(explorando.nNodo.nombre);
            for(NodoPeso h : explorando.nNodo.vecinos)
            {
                if(!rum.visitados.contains(h.nNodo))
                {
                    int indice = rum.nodoEnFrontera(h.nNodo);
                    if(indice == -1)
                        rum.frontera.push(new NodoPeso(h.nNodo, h.peso + w));
                    else if(h.peso + w < rum.frontera.get(indice).peso)
                        rum.frontera.get(indice).peso = h.peso + w;

                }
            }
            System.out.println("");
            rum.ordenaFrontera();
        }
    }
    
}
