package crypto;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
   
import javax.crypto.Cipher;

public class EncriptaDescripta { 
    
   static String textopuro = "teste texto 12345678\0\0\0"; 
   static String chaveencriptacao = "hamilton16181055"; 
   public static void main(String [] args) {
      try {
         T_EncriptaDecriptaAES T = new T_EncriptaDecriptaAES();
         
         System.out.println("Texto Puro: " + textopuro);
         
         byte[] textoencriptado = T.encrypt(textopuro, chaveencriptacao); 
         System.out.print("Texto Encriptado: "); 
         
         for (int i=0; i<textoencriptado.length; i++) 
            System.out.print(new Integer(textoencriptado[i])+" "); 
         
         System.out.println(""); 
         
         String textodecriptado = T.decrypt(textoencriptado, chaveencriptacao); 
         
         System.out.println("Texto Decriptado: " + textodecriptado); 
      } 
      catch (Exception e) { 
         e.printStackTrace(); 
      }
   }

}

