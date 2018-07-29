import java.io.*;

class DequeDuplo{
   public static class Nodo{
      Nodo link1;
      Nodo link0;
      char data;
   }
   Nodo f;
   Nodo r;
   DequeDuplo(){
      f = null;
      r = null;
   }
   void incluir(char elem, int lado){
      Nodo aux = new Nodo();
      if(f==null){
         aux.data = elem;
         aux.link1 = null;
         aux.link0 = null;
         f = aux;
         r = aux;
      }
      else if(lado==1){
         aux.data = elem;
         aux.link1 = f;
         aux.link0 = null;
         f.link0 = aux;
         f = aux;
      }
      else if(lado==0){
         aux.data = elem;
         aux.link0 = r;
         aux.link1 = null;
         r.link1 = aux;
         r = aux;
      }
   }
   char retirar(int lado){
      char ret = '*';
      if(f==r && f!=null){
         ret = f.data;
         f = null;
         r = null;
      }
      else if(f!=null){
         if(lado==1){
            ret = f.data;
            f.link1.link0 = null;
            f = f.link1;
         }
         if(lado==0){
            ret = r.data;
            r.link0.link1 = null;
            r = r.link1;
         }
      }
      return ret;
   }
   public static void main(String[] args){
      try{
         DequeDuplo deque = new DequeDuplo();
         deque.incluir('a',1);
         deque.incluir('b',1);
         deque.incluir('c',0);
         deque.incluir('d',0);
         deque.incluir('e',1);
         System.out.println(deque.retirar(1));
         System.out.println(deque.retirar(1));
         System.out.println(deque.retirar(1));
         System.out.println(deque.retirar(1));
         System.out.println(deque.retirar(1));
         System.out.println(deque.retirar(1));
      }
      catch(Exception e){
         System.out.println("Nao Funcionou!");
      }
   }
}