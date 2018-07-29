import java.io.*;
import java.util.Scanner;
public class EX0106
{
   public static void main ( String args [] )
   {   
      Scanner entrada = new Scanner(System.in);
   
      int v1, v2, v3;
   
      try{
         System.out.print("Entre com os tres lados do triangulo:\n");
         v1 = entrada.nextInt();
         v2 = entrada.nextInt();
         v3 = entrada.nextInt();

         if(1==1){
            if(v1 != 0 && v2 != 0 && v3 != 0){
               if(v1 == v2 && v2== v3){System.out.print("o triangulo é equilatero");}
               if((v1 == v2 && v2 != v3) || (v3 == v2 && v2!= v1) || (v1 == v3 && v3!= v2)){System.out.print("o triangulo é isoceles");}
               if(v1 != v2 && v2 != v3 && v1 != v3){System.out.print("o triangulo é escaleno");}
            } 
         }
      }
      catch (Exception e) {
         System.out.println("Ocorreu um erro durante a leitura!");
      }
   }
}