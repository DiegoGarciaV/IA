import java.util.LinkedList;
import java.util.Scanner;

public class Gato {

    Grafo arbol = new Grafo();
    char agente = 'O';
    char jugador = 'X';
    LinkedList<Nodo> visitados = new LinkedList<Nodo>();
    LinkedList<Nodo> frontera = new LinkedList<Nodo>();
    
    boolean ganaTurno(Nodo n, char j)
    {
        char estado[] = n.nombre.toCharArray();
        if(estado[4] == j)
        {
            int k = 0;
            for(k=0;k<4;k++)
            {
                if(estado[k] == j && estado[8-k] == j)
                    return true;
            }

        }
        
        
        if(estado[0] == j)
        {
            if((estado[1] == j && estado[2] == j) || (estado[3] == j && estado[6] == j))
                return true;
        }
        
        if(estado[8] == j)
        {
            if((estado[6] == j && estado[7] == j) || (estado[2] == j && estado[5] == j))
                return true;
        }
        
        return false;
    }

    int evalFunc(Nodo n)
    {
        if(nodoTerminal(n))
        {
            //Si es nodo terminal retorna el valor de victoria, perdida o empate
            return (ganaTurno(n, agente) ? 1 : (ganaTurno(n, jugador) ? -1 : 0));
        }
        else
        {
            //Si no lo es, retorna heuristica
            return 0;
        }
    }

    boolean nodoTerminal(Nodo n)
    {
        boolean r = (!n.nombre.contains("-") || ganaTurno(n, agente) || ganaTurno(n, jugador));

        return r;
    }

    void imprimeEstado(String h)
    {
        System.out.println(h.substring(0,3) + "\n" + h.substring(3,6) + "\n" + h.substring(6));
    }

    int minimax(Nodo n, char turno)
    {

        if(nodoTerminal(n))
        {
            return evalFunc(n);
        }
        
        LinkedList<Nodo> hijos = new LinkedList<Nodo>();
        int i = 0;

        //Generamos a los hijos
        //System.out.println("Turno de " + turno);
        //imprimeEstado(n.nombre);
        //System.out.println("Posibles jugadas: ");
        //System.out.println("");

        for(char c : n.nombre.toCharArray())
        {
            if(c == '-')
            {
                String h = n.nombre.substring(0,i) + turno + n.nombre.substring(i+1);
                //imprimeEstado(h);
                
                Nodo nNuevo = new Nodo(h);
                hijos.addLast(nNuevo);
            }
            i++;
            
        }
        //System.out.println("");
        int minimo = 100000000;
        int maximo = -100000000;
        for(Nodo h : hijos)
        {
            int r = 0;

            r = minimax(h, (turno == 'X' ? 'O' : 'X'));

            if(r < minimo)
                minimo = r;
            if(r> maximo)
                maximo = r;
        }
        return (turno == agente ? maximo : minimo);

    }

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        Nodo n = new Nodo("---------");
        Gato gto = new Gato();
        System.out.println(gto.minimax(n,'O'));
        int m = 0, res = 0;
        while(m++ < 9 && res == 0)
        {
            System.out.println("Ingrese jugada x: ");
            int x,y;
            x = leer.nextInt();
            System.out.println("Ingrese jugada y: ");
            y = leer.nextInt();

            if(x>3)
                x = 3;

            if(y>3)
                y = 3;

            int k = (y-1)*3 + (x-1);
            n.nombre = n.nombre.substring(0,k) + gto.jugador + n.nombre.substring(k+1);
            gto.imprimeEstado(n.nombre);
            System.out.println("");
            if(gto.nodoTerminal(n) && gto.ganaTurno(n, gto.jugador))
            {
                System.out.println("Fin de la partida, Ganan " + gto.jugador);
                res = -1;
            }
                
            k = 0;
            LinkedList<Nodo> hijos = new LinkedList<Nodo>();
            int maxR = -2,r;
            Nodo maxNodo = new Nodo(n.nombre);
            for(char c : n.nombre.toCharArray())
            {
                if(c == '-')
                {
                    String h = n.nombre.substring(0,k) + gto.agente + n.nombre.substring(k+1);
                    //imprimeEstado(h);
                    
                    Nodo nNuevo = new Nodo(h);
                    hijos.addLast(nNuevo);
                    r = gto.minimax(nNuevo, gto.jugador);
                    if(r > maxR)
                    {
                        maxR = r;
                        maxNodo = new Nodo(nNuevo.nombre);
                    }
                }
                k++;
                
            }

            n = new Nodo(maxNodo.nombre);
            gto.imprimeEstado(n.nombre);
            if(gto.nodoTerminal(n) && gto.ganaTurno(n, gto.agente))
            {
                System.out.println("Fin de la partida, Ganan " + gto.agente);
                res = 1;
            }
            System.out.println("\n");

        }
        if(res == 0)
            System.out.println("Fin de la partida, empate");
    }
    
}
