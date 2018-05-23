package crypto;

import java.io.File;
public class TesteCrypto {

   public static void main(String[] args) throws Exception {
      String sMsgClara = "Oi, alunos da USJT!";
      String sMsgCifrada = null;
      String sMsgDecifrada = null;
      byte[] bMsgClara = null;
      byte[] bMsgCifrada = null;
      byte[] bMsgDecifrada = null;
   
      
   
      System.out.println("---------------------------------------------------------------");
   
      System.out.println(">>> Imprimindo mensagem original...");
      System.out.println("");
   
      bMsgClara = sMsgClara.getBytes("ISO-8859-1");
         
  
      System.out.println("Mensagem Clara (String):");
   
      System.out.println(sMsgClara);
      System.out.println("");
   
      
      System.out.println(">>> Cifrando com o algoritmo AES...");
      System.out.println("");
   
      CryptoAES caes = new CryptoAES();
   
      caes.geraChave(new File("chave.simetrica"));

      caes.geraCifra(bMsgClara, new File("chave.simetrica"));

      bMsgCifrada = caes.getTextoCifrado();
 
      sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1"));

      
      
      System.out.println("Mensagem Cifrada (String):");
   
      System.out.println(sMsgCifrada);
      System.out.println("");
 
      System.out.println(">>> Decifrando com o algoritmo AES...");
      System.out.println("");
 
      caes.geraDecifra(bMsgCifrada, new File("chave.simetrica"));
 
      bMsgDecifrada = caes.getTextoDecifrado();
  
      sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1"));
 
      System.out.println("Mensagem Decifrada (String):");
  
      System.out.println(sMsgDecifrada);
      System.out.println("");
   
   }
}
