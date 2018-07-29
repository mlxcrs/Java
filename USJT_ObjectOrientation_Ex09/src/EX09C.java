import java.util.Scanner;
import java.io.*;
import java.util.*;

public class EX09C {

   public static class Nodo{
      int data;
      Nodo link;
   } 
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      try{
         System.out.println("Digite quantos numeros quiser sendo todos maiores e diferentes de 0.");
         int a=1;
         int i=0;
         Nodo lista = new Nodo();
         Nodo aux = new Nodo();
         Nodo aux2 = new Nodo();
         aux = lista;
         while(lista!=null){
            System.out.print("Insira o valor:");
            a = in.nextInt();
            lista.data = a;
            if (a <= 0){
               lista.link = null;
               lista = lista.link;
            }
            else{
               lista.link = new Nodo();
               lista = lista.link;
            }
         }
         lista = aux;
         while(lista!=null){
            lista = lista.link;
            i++;
         }
         System.out.println("Você digitou "+i+" Valores que são:");
         lista = aux;
         System.out.printf("|Posição|  Valor|\n");
         for(int j=1;j<=i;j++){
            System.out.printf("|Nodo %2d|%7d|\n",j,lista.data);
            lista = lista.link;
         }
         lista = aux;
         for(int j=0;j<i;j++){
            for(int k=0;k<i;k++){
            if(k==i-1){
               lista.link = new Nodo();
               lista.link.data = 2147483647;
               lista = aux;
            }
               if(lista.data>lista.link.data){
                  aux2.data = lista.data;
                  lista.data = lista.link.data;
                  lista.link.data = aux2.data;
               }
               lista = lista.link;
            }
         }
         i=-1;
         while(lista!=null){
            lista = lista.link;
            i++;
         }
         System.out.println("Os "+i+" valores que você digitou organizados em ordem crescente são:");
         lista = aux;
         System.out.printf("|Posição|  Valor|\n");
         for(int j=1;j<=i;j++){
            System.out.printf("|Nodo %2d|%7d|\n",j,lista.data);
            lista = lista.link;
         }
         lista = aux;
      }
      catch (Exception e){
         System.out.println("Não funcionou!");
      }
   }
}