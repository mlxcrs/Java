import java.io.*;
import java.util.Scanner;
public class EX0105
{
   public static void main ( String args [] )
   {   
      Scanner entrada = new Scanner(System.in);
   
      int v1;
   
      try{
         System.out.print("Entre um valor inteiro:\n");
         v1 = entrada.nextInt();
                  
         if(v1%2==0){System.out.print("o numero é par");}
         else{System.out.print("o numero é impar");}
      }     
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}