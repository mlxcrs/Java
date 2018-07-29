import java.io.*;
import java.util.*;
import java.util.Scanner;
public class EX0302{
   
   public static void preencheAleatorio (int [] v, int max)
   {
      Random r = new Random ();
      for (int i = 0; i < v.length; i++){
         v [i] = r.nextInt (max + 1);
      }
   }

   public static void selectionSort(int v[]) {
      int i1=0;
      for(int i=0;i<v.length-1;i++){
         int menor=i;
         for(int j=i+1;j<v.length;j++){
            if(v[menor] > v[j])
               menor = j;
         }
         int aux=v[i];
         v[i]=v[menor];
         i1++;
         v[menor]=aux;
         i1++;
      }
      System.out.println("\n numero de interacoes com o vetor no selection sort eh: " + i1);
   }

   public static void insertSort(int vet [ ] )
   {
      int i2=0;
      int insert;
      for ( int i = 1; i < vet.length; i++ )
      {
         insert = vet [ i ]; 
         int moveItem = i; 
         while ( moveItem > 0 && vet [ moveItem - 1 ] > insert )
         {
            vet [ moveItem ] = vet [ moveItem - 1 ];
            i2++;
            moveItem--;
         }
      
         vet [ moveItem ] = insert;
         i2++;
      }
      System.out.println("\n numero de interacoes com o vetor no insert sort eh: " + i2);
   }  
   
   public static void bubbleSort( int vet [ ] )
   
   {  
      int i3=0;
      int aux;
      for ( int i = 0; i < vet.length - 1; i++ ){
         for ( int j = 0; j < vet.length-1 - i; j++ ){
            if (vet[ j ] > vet[ j+1]) {
               aux = vet [ j ]; 
               vet [ j ] = vet [ j+1]; 
               i3++;
               vet [ j+1] = aux; 
               i3++;
            }
         }
      }
      System.out.println("\n numero de interacoes com o vetor no bubble sort eh: " + i3);
   }

   public static void main(String[] args) 
   {
      int v1 [] = new int [50];
      preencheAleatorio (v1, 10000);
      
      int v2 [] = new int [50];
      for(int i=0;i<50;i++) 
         v2[i]=v1[i];
      
      int v3 [] = new int [50];
      for(int i=0;i<50;i++) 
         v3[i]=v1[i];
   
      long t1 = System.nanoTime();
      selectionSort(v1);
      long t2 = System.nanoTime();
      System.out.println ("\nTempo gasto selection sort = " + (t2 - t1) + " nanosegundos.\n");
      
      t1 = System.nanoTime();
      insertSort(v2);
      t2 = System.nanoTime();
      System.out.println ("\nTempo gasto insertion sort = " + (t2 - t1) + " nanosegundos.\n");

      t1 = System.nanoTime();
      bubbleSort(v3);
      t2 = System.nanoTime();
      System.out.println ("\nTempo gasto bubble sort = " + (t2 - t1) + " nanosegundos.\n");
   }

}