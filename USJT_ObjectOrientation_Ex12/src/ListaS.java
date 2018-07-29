import java.io.*;

class ListaS{
   public static class Nodo{
      Nodo link;
      int data;
   }
   Nodo l;
   ListaS(){
      l=new Nodo();
      l.link = new Nodo();
      l.data = 0;
      l.link.data = 501;
      l.link.link = null;
   }
   void inserir(int elem){
      Nodo aux1 = new Nodo();
      Nodo aux2 = l;
      if(elem>0 && elem<501){
         while(aux2.link.data<elem){
            aux2 = aux2.link;
         }
         aux1.data = elem;
         aux1.link = aux2.link;
         aux2.link = aux1;
      }
      else{
         System.out.println("O numero não estáa entre o intervalo 0 e 501.");
      }
   }
   void excluir(int elem){
      Nodo aux = l;
      if(elem!=0 && elem!=501){
         while(aux.link.link!=null){
            if(aux.link.data==elem){
               aux.link = aux.link.link;
            }
            aux = aux.link;
         }
      }
   }
   void mostrar(){
      Nodo aux = l;
      while(aux!=null){
         System.out.println(aux.data);
         aux = aux.link;
      }
   }
   boolean buscar(int elem){
      boolean res = false;
      Nodo aux = l;
      while(aux!=null){
         if(aux.data==elem){
            res=true;
         }
         aux = aux.link;
      }
   return res;
   }
   public static void main(String[] args){
      try{
         ListaS lista = new ListaS();
         lista.inserir(5);
         lista.inserir(1);
         lista.inserir(20);
         lista.inserir(300);
         lista.inserir(213);
         lista.mostrar();
         System.out.println(lista.buscar(12));
         System.out.println(lista.buscar(300));
         lista.excluir(213);
         lista.mostrar();
      }
      catch(Exception e){
         System.out.println("Nao Funcionou!");
      }
   }
}