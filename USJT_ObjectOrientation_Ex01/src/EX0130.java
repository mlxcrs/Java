import java.io.*;
import java.util.Scanner;
public class EX0130
{
   public static void main ( String args [] )
   {
      int a [] = {32,45,89,66,12,35,10,96,38,15,13,11,65,81,35,64,16,89,54,19};
   
      int n = a.length;
      int b [] = new int [n];
      int m = 0;
      int i,c=0;
      String saida = "Resposta:\n";
      
      for(i=1;i<(n-1);i++)
      {
         b[0]=a[0];
         b[n-1]=a[n-1];
         b[i]=((a[i-1]+a[i]+a[i+1])/3);
      }
      
      for(i=0;i<n;i++)
      {
         saida = saida + b[i] + " ";
      }
      
      saida = saida + "\nFim.";
      System.out.println(saida);
   }
}