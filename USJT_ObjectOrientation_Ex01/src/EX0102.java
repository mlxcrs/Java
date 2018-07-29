import java.io.*;
import java.util.Scanner;
public class EX0102
{
   public static void main ( String args [] )
   {   
      Scanner entrada = new Scanner(System.in);
   
      float v1, v2, v3;
   
      try{
         System.out.print("Entre com o valor do Kilo:\n");
         v1 = entrada.nextFloat();
         System.out.print("Entre com a quantidade de quilos:\n");
         v2 = entrada.nextFloat();
         v3 = v1*v2;
         String saida = "Resposta:\n";
         saida = saida + "O valor a ser pago é:" + v3 + " Reais";
         saida = saida + "\nFim.";
         System.out.print(saida);
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}