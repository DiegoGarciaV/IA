import java.util.LinkedList;
public class Nodo {
    
    String nombre;
    Object estado;
    LinkedList<Nodo> vecinos = new LinkedList<Nodo>();
    
    Nodo(String data)
    {
        this.nombre = data;
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
