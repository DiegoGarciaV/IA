import java.util.LinkedList;
public class Nodo {
    
    String nombre;
    int estado[][] = new int[8][8];
    LinkedList<Nodo> vecinos = new LinkedList<Nodo>();
    
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
            vecinos.addLast(new Nodo(data));
        }
            
    }

    void agregaVecino(Nodo n)
    {
        if(n != null)
        {
            vecinos.addLast(n);
        }
            
    }

    void insertaVecino(String data)
    {
        if(data != null)
        {
            vecinos.addFirst(new Nodo(data));
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
        for(Nodo v : this.vecinos)
        {
            System.out.print(v.nombre);
            if(i < this.vecinos.size()-1)
                System.out.print(", ");

            i++;
        }
        System.out.print("]");
    }
}
