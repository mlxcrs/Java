import java.io.*;
import java.util.Scanner;
public class EX0101{
   public static void main(String args[]){   
      Scanner entrada = new Scanner(System.in);
  // 
      float v1, v2, v3;
   
      try{
         System.out.print("Entre com o valor pago:\n");
         v1 = entrada.nextFloat();
         System.out.print("Entre com o preco do produto:\n");
         v2 = entrada.nextFloat();
         v3 = v1-v2;
         String saida = "Resposta:\n";
         saida = saida + "seu troco e:" + v3 + "Reais";
         saida = saida + "\nFim.";
         System.out.print(saida);
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}