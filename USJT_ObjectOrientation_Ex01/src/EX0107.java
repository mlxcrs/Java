import java.io.*;
import java.util.Scanner;
public class EX0107
{
   public static void main ( String args [] )
   {   
      Scanner entrada = new Scanner(System.in);
   
      float v1;
   
      try{
         System.out.print("Insira o codigo do produto:\n");
         v1 = entrada.nextFloat();
         if(v1 == 1){System.out.print("parafuso");}
         if(v1 == 2){System.out.print("porca");}
         if(v1 == 3){System.out.print("prego");}
         if(v1 != 1 && v1 != 2 && v1 != 3){System.out.print("Diversos");}         
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}