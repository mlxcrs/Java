import java.io.*;
import java.util.Scanner;
public class EX0108
{
   public static void main ( String args [] )
   {   
      Scanner entrada = new Scanner(System.in);
   
      int v1;
   
      try{
         System.out.print("Insira o codigo:\n");
         v1 = entrada.nextInt();
         switch (v1) {
            case 1 : System.out.print("parafuso");
            break;
            case 2 : System.out.print("porca");
            break;
            case 3 : System.out.print("prego");
            break;
            default: System.out.print("Diversos");
}
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}