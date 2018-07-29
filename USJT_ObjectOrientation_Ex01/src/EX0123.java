import java.io.*;
import java.util.Scanner;
public class EX0123
{
   public static void main ( String args [] )
   {
      int a [] = {32,45,89,66,12,35,10,96,38,15,13,11,65,81,35,64,16,89,54,19};
   
      int n = a.length;
      int b [] = new int [n];
      int m = 0;
      int i,c=0,d;
      String saida = "Resposta:\n";
      
      for(i=0;i<n;i++)
      {
         if(a[i]<50)
         {
            b[c] = a[i];
            c=c+1;
         }
      }
      d=c;
      for (c=0;c<d;c++)
      {
         if(b[c]>m)
         {
            m=b[c];
         }
      }
      b[0]=m;
      saida = saida + b[0];
      saida = saida + "\nFim.";
      System.out.println(saida);
   }
}