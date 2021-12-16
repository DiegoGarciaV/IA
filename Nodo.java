import java.util.LinkedList;
public class Nodo {
    
    String nombre;
    int estado[][] = new int[8][8];
    LinkedList<NodoPeso> vecinos = new LinkedList<NodoPeso>();
    
    Nodo(String data)
    {
        this.nombre = data;
        estado[3][3] = -1;
        estado[4][4] = -1;

        estado[3][4] = 1;
        estado[4][3] = 1;
    }

    void agregaVecino(String data)
    {
        if(data != null)
        {
            vecinos.addLast(new NodoPeso(data));
        }
            
    }

    void agregaVecinoCoste(String data, double w)
    {
        if(data != null)
        {
            vecinos.addLast(new NodoPeso(data,w));
        }
            
    }

    void agregaVecino(Nodo n)
    {
        if(n != null)
        {
            vecinos.addLast(new NodoPeso(n));
        }
            
    }

    void agregaVecinoCoste(Nodo n, double w)
    {
        if(n != null)
        {
            vecinos.addLast(new NodoPeso(n,w));
        }
            
    }

    void insertaVecino(String data)
    {
        if(data != null)
        {
            vecinos.addFirst(new NodoPeso(data));
        }
    }

    void insertaVecino(Nodo n)
    {
        if(n != null)
        {
            vecinos.addFirst(new NodoPeso(n));
        }
    }

    void insertaVecinoCoste(Nodo n,double w)
    {
        if(n != null)
        {
            vecinos.addFirst(new NodoPeso(n,w));
        }
    }

    String imprimeEstado()
    {
        String r = "";
        int i,j;
        for(i = 0;i < 8;i++)
        {
            for(j = 0; j  < 8; j++)
            {
                r = r + (estado[i][j] == 0 ? " - " : estado[i][j] > 0 ? " O " : " X ");
            }
            r = r + "\n";
        }
        return r;
    }

    void muestraVecinos()
    {
        int i = 0;
        System.out.print("[");
        for(NodoPeso v : this.vecinos)
        {
            System.out.print("(" + v.nNodo.nombre + "," + v.peso + ")");
            if(i < this.vecinos.size()-1)
                System.out.print(", ");

            i++;
        }
        System.out.print("]");
    }
}
