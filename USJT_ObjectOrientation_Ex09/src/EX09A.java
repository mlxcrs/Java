import java.util.Scanner;

public class EX09A{
   public static class Nodo{
      int data;
      Nodo link;
   }
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      try{
      Nodo lista = new Nodo();
      lista.data = in.nextInt();
      lista.link = new Nodo();
      lista.link.data = in.nextInt();
      Nodo aux = new Nodo();
      aux.data = in.nextInt();
      aux.link = new Nodo();
      aux.link.data = in.nextInt();
      aux.link.link = null;
      lista.link.link = aux;
      }
      catch(Exception e){
      System.out.print("Nao funcionou");
      }
   }
}