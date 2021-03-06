import java.util.LinkedList;

import javax.lang.model.util.ElementScanner14;
public class Canivales {
   
    Grafo arbol = new Grafo();
    LinkedList<Nodo> visitados = new LinkedList<Nodo>();
    LinkedList<NodoPeso> frontera = new LinkedList<NodoPeso>();


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

    void imprimeVisitados()
    {
        int i = 0;

        for(Nodo n : this.visitados)
        {
            System.out.print(n.nombre);
            if(i++ < this.visitados.size()-1)
                System.out.print(", ");
        }
    }

    int nodoEnLista(Nodo n,LinkedList<Nodo> L)
    {
        int i= 0;
        for(Nodo nNodo : L)
        {
            if(nNodo.equals(n))
                return i;
            else
                i++;
        }
        return -1;
    }
    void ordenaFrontera()
    {
        
        int i = 0,indice = 0,k = 0;
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
            this.frontera.addLast(minNodo);
            this.frontera.remove(indice);
            k++;

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


    int nodoVisitado(Nodo n)
    {
        return nodoEnLista(n,this.visitados);
    }


    String generaNombre(int[] m, int j)
    {
        String r = "";
        for(int i = 0;i<j;i++)
        {   
            r = r + m[i] + " ";
        }
        return r;
    }

    LinkedList<Nodo> expandeHijos(Nodo n)
    {
        int estado[] = n.estado[0];

        int s = estado[2];
        LinkedList<Nodo> l = new LinkedList<Nodo>();

        int movimientos[][] = new int[5][2];
        movimientos[0][0] = s*1;
        movimientos[0][1] = s*1;

        movimientos[1][0] = s*2;
        movimientos[1][1] = 0;

        movimientos[2][0] = 0;
        movimientos[2][1] = s*2;

        movimientos[3][0] = s*1;
        movimientos[3][1] = 0;

        movimientos[4][0] = 0;
        movimientos[4][1] = s*1;

        for(int i = 0; i < 5; i++)
        {
            int nEstado[][] = new int[1][3];
            nEstado[0][0] = estado[0] + movimientos[i][0];
            nEstado[0][1] = estado[1] + movimientos[i][1];
            nEstado[0][2] = -s;
            if(!(nEstado[0][0] < 0 || nEstado[0][1] < 0 || nEstado[0][0] > 3 || nEstado[0][1] > 3))
                l.add(new Nodo(generaNombre(nEstado[0], 3),nEstado,1,3));

        }

        return l;
    }


    int nodoTerminal(Nodo n)
    {
        int estado[] = n.estado[0];
        if((estado[0] + estado[1]) == 0 && estado[2] == 1)
            return 1;
        else if(estado[0] != estado[1] && (estado[0] == 1 || estado[0] == 2))
            return -1;
        else
            return 0;

    }


    public static void main(String[] args)
    {
        Canivales can = new Canivales();
        int ini[][] = new int[6][3];
        ini[0][0] = 3;
        ini[0][1] = 3;
        ini[0][2] = -1;

        String nombre = can.generaNombre(ini[0], 3);
        can.arbol.agregaNodo(nombre, ini, 1, 3);

        can.frontera.addFirst(new NodoPeso(can.arbol.nodos.getFirst(),0));
        while(can.frontera.size()>0)
        {
            System.out.print("Frontera: ");
            can.imprimeFrontera(can.frontera);
            System.out.println("");

            System.out.print("Visitados: ");
            can.imprimeVisitados();
            System.out.println("");


            NodoPeso explorando = can.frontera.pop();
            double w = explorando.peso;
            System.out.println("Explorando: " + explorando.nNodo.nombre);
            LinkedList<Nodo> hijos = new LinkedList<Nodo>();
            hijos.clear();

            
            if(can.nodoTerminal(explorando.nNodo) > -1)
                hijos = can.expandeHijos(explorando.nNodo);
        
            for(Nodo h : hijos)
            {
                if(can.nodoEnLista(h, can.arbol.nodos) == -1)
                    can.arbol.agregaNodo(h);
                can.arbol.getNodo(explorando.nNodo.nombre).agregaVecinoCoste(can.arbol.getNodo(h.nombre), w +1);
            }

            if(can.nodoTerminal(explorando.nNodo) == 1)
            {   
                System.out.println("Estado objetivo alcanzado, costo: " + w);
                break;
            }

            can.visitados.addLast(explorando.nNodo);

            for(NodoPeso h : explorando.nNodo.vecinos)
            {
                if(can.nodoVisitado(h.nNodo) == -1)
                {
                    int indice = can.nodoEnFrontera(h.nNodo);
                    if(indice == -1)
                        can.frontera.addLast(new NodoPeso(h.nNodo, 1 + w));

                }
            }
            System.out.println("");
        }
        System.out.println("\n'Arbol: \n");
        can.arbol.muesraGrafo();


        can.frontera.clear();
        can.visitados.clear();
        can.frontera.addFirst(new NodoPeso(can.arbol.nodos.getFirst(),0));
        while(can.frontera.size()>0)
        {
            System.out.print("Frontera: ");
            can.imprimeFrontera(can.frontera);
            System.out.println("");
            NodoPeso explorando = can.frontera.pop();
            double w = explorando.peso;
            
            if(can.nodoTerminal(explorando.nNodo) == 1)
            {   
                System.out.println("Estado objetivo alcanzado, costo: " + w);
                break;
            }
            

            can.visitados.addLast(explorando.nNodo);
            System.out.println(explorando.nNodo.nombre);
            for(NodoPeso h : explorando.nNodo.vecinos)
            {
                if(!can.visitados.contains(h.nNodo))
                {
                    int indice = can.nodoEnFrontera(h.nNodo);
                    if(indice == -1)
                        can.frontera.push(new NodoPeso(h.nNodo, h.peso + h.nNodo.estado[0][0] + h.nNodo.estado[0][1]));
                    else if(h.peso + w < can.frontera.get(indice).peso)
                        can.frontera.get(indice).peso = h.peso + w;

                }
            }
            System.out.println("");
            can.ordenaFrontera();
        }

    }

}
