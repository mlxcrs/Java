import java.io.*;
import java.util.*;
class EX0501{
   public static int [ ] merge(int v1[ ], int v2[ ]) {
      int vR [ ] = new int[v1.length+v2.length];
      int n1=0,n2=0,nR=0;
      while(n1<v1.length && n2<v2.length) {
         if(v1[n1] < v2[n2]){
            vR[nR++]=v1[n1++];
            System.out.println("\nInteracao\n");
            System.out.println(Arrays.toString(vR));}
         else{
            vR[nR++]=v2[n2++];
            System.out.println("\nInteracao\n");
            System.out.println(Arrays.toString(vR));}
      }
      while(n1<v1.length){
         vR[nR++]=v1[n1++];
         System.out.println("\nInteracao\n");
         System.out.println(Arrays.toString(vR));}
      while(n2<v2.length){
         vR[nR++]=v2[n2++];
         System.out.println("\nInteracao\n");
         System.out.println(Arrays.toString(vR));}
      return vR;
   }
   public static void preencheAleatorio (int [] v, int max)
   {
      Random r = new Random ();
      for (int i = 0; i < v.length; i++)
         v [i] = r.nextInt (max + 1);
   }
   public static void main(String args[ ]){
      int vet1 []= new int [10];
      preencheAleatorio (vet1, 100000);
      int vet2 []= new int [10];
      preencheAleatorio (vet2, 100000);
      int vetR[ ];
      Arrays.sort(vet1);
      Arrays.sort(vet2);
      System.out.println("\nElementos do vetor 1:");
      System.out.println(Arrays.toString(vet1));
      System.out.println("\nElementos do vetor 2:");
      System.out.println(Arrays.toString(vet2));
      System.out.println("\nRealizando o merge...");
      vetR = merge(vet1,vet2);
      System.out.println("\nResultado do merge:");
      System.out.println(Arrays.toString(vetR));
   }
}