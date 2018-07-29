import java.io.*;
import java.util.*;
class EX0504{
   public static int mergeatri(int v1[ ], int v2[ ]) {
      int vR [ ] = new int[v1.length+v2.length];
      int n1=0,n2=0,nR=0,atri=0;
      while(n1<v1.length && n2<v2.length) {
         if(v1[n1] < v2[n2]){
            vR[nR++]=v1[n1++];
            atri = atri + 1;
         }
         else{
            vR[nR++]=v2[n2++];
            atri = atri + 1;
         }
      }
      while(n1<v1.length){
         vR[nR++]=v1[n1++];
         atri = atri + 1;
      }
      while(n2<v2.length){
         vR[nR++]=v2[n2++];
         atri = atri + 1;
      }
      return atri;
   }
   
   public static int separa1atri (int vet [ ], int ini, int fim)
   {
      int atri=0;
      int c = vet [ ini ], i = ini + 1, j = fim, aux;
      while ( i<=j ) {
         while (i <= fim && vet [ i ] <= c)
            i++;
         while (c < vet [ j ])
            j--;
         if (i < j){
            aux = vet [ i ];
            vet [ i ] = vet [ j ];
            atri++;
            vet [ j ] = aux;
            atri++;
            i++;
            j--;
         }
      }
      vet [ ini ] = vet [ j ];
      atri++;
      vet [ j ] = c;
      atri++; 
      return j;
   }
      
   public static int quickSortatri (int vet [ ], int ini, int fim)
   {
      int atri=0;
      if (ini < fim) {
         atri = separa1atri (vet, ini, fim);
         quickSortatri (vet, ini, atri-1);
         quickSortatri (vet, atri+1, fim);
      }
      return atri;
   }
   public static void preencheAleatorio (int [] v, int max)
   {
      Random r = new Random ();
      for (int i = 0; i < v.length; i++)
         v [i] = r.nextInt (max + 1);
   }
   
   public static void main(String[] args){
      
      int atrimerge=0;
      int atriquick=0;
      for(int i=0;i<100;i++){
      
         int vet1[] = new int [1000];
         preencheAleatorio(vet1,100000);
         int vet2[] = new int [1000];
         int ini = 0;
         int fim = vet1.length;
         preencheAleatorio(vet1,100000);
         atrimerge = atrimerge + mergeatri(vet1,vet2);
      
      }
      
      atrimerge = atrimerge/100;
      atriquick = atriquick/100;
      System.out.println("atribuicoes medias do merge = " + atrimerge + "\n");
      System.out.println("atribuicoes medias do quick = " + atriquick + "\n");
   
   }
}