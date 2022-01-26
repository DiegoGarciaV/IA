import java.util.LinkedList;
public class Nodo {
    
    String nombre;
    int estado[][];
    LinkedList<NodoPeso> vecinos = new LinkedList<NodoPeso>();
    
    Nodo(String data)
    {
        this.nombre = data;
        
    }

    Nodo(String data,int[][] m, int c, int k)
    {
        this.nombre = data;
        estado  = new int[c][k];
        for(int i = 0; i < c; i++)
        {
            for(int j = 0; j < k; j++)
            {
                estado[i][j]  = m[i][j];
            }
        }
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

    boolean equals(Nodo n)
    {
        if(this == n) 
        {
            return true;
        }

        if(n instanceof Nodo && n.nombre.equals(this.nombre))
        {
            return true;
        }
   
        return false;
    }

    String imprimeEstado()
    {
        String r = "";
        int i,j;
        int h = estado.length,k = 0;
        for(i = 0;i < h;i++)
        {
            k = estado[i].length;
            for(j = 0; j  < k; j++)
            {
                r = r + estado[i][j] + " ";
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
