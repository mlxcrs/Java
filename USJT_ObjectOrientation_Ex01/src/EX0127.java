import java.io.*;
import java.util.Scanner;
public class EX0127
{
   public static void main ( String args [] )
   {
      int a [] = {32,45,89,66,12,35,10,96,38,15,13,11,65,81,35,64,16,89,54,19};
   
      int n = a.length;
      int b [] = new int [n];
      int m = 0;
      int i,c=0;
      String saida = "Resposta:\n";
      
      for(i=0;i<(n-1);i++)
      {
         if(a[i]<a[i+1])
         {
            b[c] = i;
            c++;
         }
      }
      for(i=0;i<c;i++)
      {
         saida = saida + b[i] + " ";
      }
      saida = saida + "\nFim.";
      System.out.println(saida);
   }
}