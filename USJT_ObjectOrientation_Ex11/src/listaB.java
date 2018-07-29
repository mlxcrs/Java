import java.io.*;

class listaB{
    static class Nodo{
        Nodo link;
        char data;
    }
    Nodo l;
    listaB(){
        l=null;
    }
    void inserir(char a){
        Nodo aux = new Nodo();
        aux.data = a;
        aux.link=l;
        l=aux;
    }
    void mostrar(Nodo lb){
        Nodo aux = lb;
        if(aux!=null){
            if(aux.link!=null){
                while(aux.link.link!=null){
                    aux=aux.link;
                }
                System.out.println(aux.link.data);
                aux.link=aux.link.link;
                mostrar(lb);
            }
            else{
                System.out.println(aux.data);
            }
        }
    }
    public static void main(String[] args){
        listaB bus = new listaB();
        bus.inserir('a');
        bus.inserir('b');
        bus.inserir('c');
        bus.inserir('d');
        bus.inserir('e');
        bus.mostrar(bus.l);
    }
}