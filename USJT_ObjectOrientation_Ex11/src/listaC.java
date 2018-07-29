import java.io.*;

class listaC{
    static class Nodo{
        Nodo link0;
        Nodo link1;
        char data;
    }
    Nodo l;
    listaC(){
        l=null;
    }
    void inserir(char elem,int ref){
        if(l==null){
            Nodo aux1 = new Nodo();
            aux1.data = elem;
            l = aux1;
            aux1.link1 = l;
            aux1.link0 = l;
        }
        else{
            l = l.link0;
            for(int i=0;i<ref;i++){
                l = l.link1;
            }
            Nodo aux1 = new Nodo();
            Nodo aux2 = l;
			aux1.data = elem;
			aux1.link1 = l.link1;
			l.link1.link0 = aux1;
			aux1.link0 = l;
			l.link1 = aux1;
			for(int i=0;i<ref;i++){
                l = l.link0;
            }
            l = l.link1;
        }
    }
    void excluir(int ref){
        Nodo aux1 = l;
        for(int i=1;i<ref-1;i++){
            aux1 = aux1.link1;
        }
        aux1.link1 = aux1.link1.link1;
        aux1.link1.link0 = aux1;
    }
    void movimentar(int ref, int dir){
        if(dir == 1){
            for(int i=0;i<ref;i++){
                l = l.link1;
            }
        }
        if(dir == 0){
            for(int i=0;i<ref;i++){
                l = l.link0;
            }
        }
    }
    void mostrar(int dir){
        Nodo aux = l;
        if(dir==1){
            if(l!=null){
                System.out.println(aux.data);
                while(aux.link1!=l){
                    aux = aux.link1;
                    System.out.println(aux.data);
                }
            }
        }
        if(dir==0){
            if(l!=null){
                System.out.println(aux.data);
                while(aux.link0!=l){
                    aux = aux.link0;
                    System.out.println(aux.data);
                }
            }
        }
    }
    public static void main(String[] args){
        try{
            listaC bus = new listaC();
            bus.mostrar(1);
            bus.inserir('a',0);
            bus.mostrar(1);
            bus.inserir('b',1);
            bus.mostrar(1);
            bus.inserir('c',2);
            bus.mostrar(1);
            bus.inserir('d',3);
            bus.mostrar(1);
            bus.inserir('e',4);
            bus.mostrar(1);
        }
        catch(Exception e){
            System.out.println("Nao funcionou");
        }
    }
}