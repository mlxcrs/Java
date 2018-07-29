import java.io.*;
import java.util.Scanner;
public class EX0122
{
   public static void main ( String args [] )
   {
      int a [] = {32,45,89,66,12,35,10,96,38,15,13,11,65,81,35,64,16,89,54,19};
   
      int n = a.length;
      int b [] = new int [n];
      int m = 0;
      int i;
      String saida = "Resposta:\n";
      
      for(i=0;i<n;i++)
      {
         if(a[i]%2==1)
         {
            b[0] = b[0] + a[i]; 
         }
      }
      
      saida = saida + b[0];
      saida = saida + "\nFim.";
      System.out.println(saida);
   }
}