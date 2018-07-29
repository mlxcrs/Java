import java.io.*;
import java.util.Scanner;
public class EX0113
{
   public static void main ( String args [] )
   {   
      BufferedReader entrada;
      entrada = new BufferedReader( new InputStreamReader (System.in) );
   
      int i=0, b = 50;
      float soma = 0, n[] = new float [b];
      
      try{
         System.out.print("Insira 50 numeros inteiros:\n");
         for(i=0;i<b;i++)
         {
            System.out.print(":");
            n[i] = Float.parseFloat( entrada.readLine() );
            soma = soma + n[i];
         }
         float media = 0;
         media = soma/b;
      
         String saida = "\n Numeros que sao menores que a media = {";
         String saidaf = saida;
      
         for(i=0;i<b;i++)
         {
            if(n[i]<media)
            {
               saidaf = saidaf + n[i] + ",";
            }
         }
         saidaf = saidaf + "}";
         System.out.print(saidaf);
         
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}