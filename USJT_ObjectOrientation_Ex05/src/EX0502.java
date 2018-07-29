import java.io.*;
import java.util.*;
class EX0502{
   public static int separa1 (int vet [ ], int ini, int fim)
   {
      int c = vet [ ini ], i = ini + 1, j = fim, aux;
      while ( i<=j ) {
         while (i <= fim && vet [ i ] <= c)
            i++;
         while (c < vet [ j ])
            j--;
         if (i < j){
            aux = vet [ i ];
            vet [ i ] = vet [ j ];
            vet [ j ] = aux;
            i++;
            j--;
         }
      }
      vet [ ini ] = vet [ j ];
      vet [ j ] = c;
      return j;
   }
   
   public static int [] quickSortInt (int vet [ ], int ini, int fim)
   {
      int j;
      if (ini < fim) {
         j = separa1 (vet, ini, fim);
         quickSortInt (vet, ini, j-1);
         quickSortInt (vet, j+1, fim);
      }
   return vet;
   }
   public static void preencheAleatorio (int [] v, int max)
   {
      Random r = new Random ();
      for (int i = 0; i < v.length; i++)
         v [i] = r.nextInt (max + 1);
   }
   public static void main(String[] args){
      int vet[] = new int [10];
      preencheAleatorio (vet, 100000);
      int ini = 0;
      int fim =(vet.length-1);
      System.out.println(Arrays.toString(quickSortInt(vet,ini,fim)));
   }
}