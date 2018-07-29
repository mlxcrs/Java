import java.io.*;
import java.util.Scanner;
public class EX0103
{
   public static void main ( String args [] )
   {   
      Scanner entrada = new Scanner(System.in);
   
      float v1, v2, v3;
   
      try{
         System.out.print("Entre com dois valores:\n");
         v1 = entrada.nextFloat();
         v2 = entrada.nextFloat();
         if(v1>v2){v3 = v1;}
         else{v3 = v2;}
         String saida = "Resposta:\n";
         saida = saida + "O maior valor é: " + v3;
         saida = saida + "\nFim.";
         System.out.print(saida);
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}