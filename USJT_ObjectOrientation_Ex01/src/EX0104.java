import java.io.*;
import java.util.Scanner;
public class EX0104
{
   public static void main ( String args [] )
   {   
      Scanner entrada = new Scanner(System.in);
   
      float v1, v2, v3, v4, v5;
   
      try{
         System.out.print("Entre com 4 valores:\n");
         v1 = entrada.nextFloat();
         v2 = entrada.nextFloat();
         v3 = entrada.nextFloat();
         v4 = entrada.nextFloat();
         v5=0;
         
         if(v1<=v2 && v1<=v3 && v1<=v4){v5 = v1;}
         if(v2<=v1 && v2<=v1 && v2<=v4){v5 = v2;}
         if(v3<=v1 && v3<=v2 && v3<=v4){v5 = v3;}
         if(v4<=v1 && v4<=v2 && v4<=v3){v5 = v4;}

         String saida = "Resposta:\n";
         saida = saida + "O menor valor é:" + v5;
         saida = saida + "\nFim.";
         System.out.print(saida);
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}