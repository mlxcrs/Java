import java.io.*;

public class listaA{
    public static class Nodo{
        Nodo link;
        char data;
    }
    Nodo l;
    listaA(){
        l=null;
    }
    void inserir(char a){
        Nodo aux = new Nodo();
        aux.data = a;
        aux.link=l;
        l=aux;
    }
    void mostrar(Nodo la){
        if(la!=null){
        System.out.println(la.data);            
        mostrar(la.link);
        }
    }
    public static void main(String[] args){

        listaA bus = new listaA();
        bus.inserir('a');
        bus.inserir('b');
        bus.inserir('c');
        bus.inserir('d');
        bus.inserir('e');
        bus.mostrar(bus.l);
    }
}