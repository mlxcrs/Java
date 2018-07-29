import java.util.Scanner;

public class EX09B{
   public static class Nodo{
      int data;
      Nodo link;
   } 
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      try{
         int a;
         int qtd;
         System.out.println("Insira a quantidade de elementos");
         qtd = in.nextInt();
         Nodo lista = new Nodo();
         Nodo aux = new Nodo();
         aux = lista;
         for(int i=0;i<qtd;i++){
            System.out.print("Insira o valor:");
            a = in.nextInt();
            
            lista.data = a;
            if(i<qtd-1){
               lista.link = new Nodo();
            }
            else{
               lista.link = null;
            }
            lista = lista.link;
         }
         lista = aux;
         
         while(lista!=null){
        	 System.out.println(lista.data);
         	lista = lista.link;
         }
         lista = aux;
      }
      catch (Exception e){
    	  System.out.println("Nãao funcionou!");
      }
   }
}