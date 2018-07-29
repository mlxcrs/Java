import java.io.*;
import java.util.*;
class EX0503{
   public static int [ ] merge(int v1[ ], int v2[ ]) {
      int vR [ ] = new int[v1.length+v2.length];
      int n1=0,n2=0,nR=0;
      while(n1<v1.length && n2<v2.length) {
         if(v1[n1] < v2[n2])
            vR[nR++]=v1[n1++];
         else
            vR[nR++]=v2[n2++];
      }
      while(n1<v1.length)
         vR[nR++]=v1[n1++];
      while(n2<v2.length)
         vR[nR++]=v2[n2++];
      return vR;
   }
   
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
      long time1m = 0;
      long time2m = 0;
      long timems = 0;
      long time1q = 0;
      long time2q = 0;
      long timeqs = 0;
      
      for(int i=0;i<100;i++){
      
         int vet1[] = new int [1000];
         preencheAleatorio(vet1,100000);
         int vet2[] = new int [1000];
         preencheAleatorio(vet1,100000);
      
         time1m = System.nanoTime();
         int vR []= merge(vet1,vet2);
         time2m = System.nanoTime();
         timems = timems + time2m - time1m;
         int ini = 0;
         int fim = (vet1.length-1);
         time1q = System.nanoTime();
         vR = quickSortInt(vet1,ini,fim);
         time2q = System.nanoTime();
         timeqs = timeqs + time2q - time1q;
      }
      timems = timems/100;
      System.out.println("tempo medio do merge = " + timems + " nano segundos.\n");
      timeqs = timeqs/100;
      System.out.println("tempo medio do QuickSort = " + timeqs + " nano segundos.\n");
   }
}