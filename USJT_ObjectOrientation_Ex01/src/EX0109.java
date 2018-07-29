import java.io.*;
import java.util.Scanner;
public class EX0109
{
   public static void main ( String args [] )
   {   
      Scanner entrada = new Scanner(System.in);
   
      float v1, soma = 0, media = 0;
      int i = 0;
   
      try{
          System.out.print("Insira 50 valores:\n");
          while(i<50){
          v1 = entrada.nextFloat();
          soma = soma + v1;
          i = i + 1;
          }
          
         media = soma / 50;
         String saida = "A soma dos valores é:";
         saida = saida + soma + "e a media aritimetica é:" + media;
         saida = saida + "\nFim.";
         System.out.print(saida);
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}