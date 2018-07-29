import java.io.*;
import java.util.Scanner;
public class EX0112
{
   public static void main ( String args [] )
   {  
      BufferedReader entrada;
      entrada = new BufferedReader( new InputStreamReader (System.in) );
      
      int i;
      float a[] = new float [10];
   
      try
      {
         System.out.print("Entre com 10 valores inteiros \n");
         for(i=0;i<10;i++)
         {
            System.out.print(":");
            a[i] = Float.parseFloat( entrada.readLine() );
         }
            String saida = "\n :";
            saida = saida + a[9] + saida + a[8] + saida + a[7] + saida + a[6] + saida + a[5] + saida + a[4] + saida + a[3] + saida + a[2] + saida + a[1] + saida + a[0];
            System.out.print(saida);
      }
      catch (Exception e) 
      {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}