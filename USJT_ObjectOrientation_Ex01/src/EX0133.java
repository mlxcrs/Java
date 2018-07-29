import java.io.*;
import java.util.Scanner;
public class EX0133
{
   public static void main ( String args [] )
   {
      int a [] = {32,45,89,66,12,35,10,96,38,15,13,11,65,81,35,64,16,89,54,19};
   
      int n = a.length;
      int b [] = new int [n];
      int m=0,v=0;
      int i=0,c=0,h=0;
      String saida = "Resposta:\n";
      
      for(i=0;i<n;i++)
      {
         if(a[i]>m)
         {
            m=a[i];
         }
      }
      v=m;
      for(i=0;i<n;i++)
      {
         if(a[i]<v)
         {
            v=a[i];
         }
      }
      
      for(i=v;i<(m+1);i++)
      {
         for(c=0;c<n;c++)
         {
            if(a[c]==i)
            {
               b[h]=i;
               h++;
            }
         }
      }
      
      for(i=0;i<n;i++)
      {
      saida = saida + b[i] + " ";
      }
      saida = saida + "\nFim.";
      System.out.println(saida);
   }
}