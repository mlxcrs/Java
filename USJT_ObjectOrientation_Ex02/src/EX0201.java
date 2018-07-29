import java.io.*;
import java.util.Scanner;
public class EX0201
{
   public static boolean buscalinear(int vet[],int x) {
      final int n = vet.length;
      for (int i=0;i<n;i++)
         if (x == vet[i]){
            return true;
            }
      return false;
   }
   public static boolean buscabinaria(int vet[],int x) {
      final int n = vet.length;
      int inicio=0,fim=n-1,meio;
      while (inicio<=fim){
         meio=(inicio+fim)/2;
         if (x == vet[meio])
            return true;
         else
            if (vet[meio] < x)
               inicio = meio+1;
            else
               fim = meio-1;
      }
      return false;
   }
   public static void main(){
   int vet[] = {1,2,3,4,5,6,7,8,9,0};
   int x=3;
   }
}