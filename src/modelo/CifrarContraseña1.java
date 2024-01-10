
package modelo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CifrarContraseña1 {

     public static String cifrarMD5(String contraseña) throws NoSuchAlgorithmException{
         MessageDigest md = MessageDigest.getInstance("MD5");
         
         md.update(contraseña.getBytes());
         byte [] digest = md.digest();
         StringBuilder sb = new StringBuilder();
         for(byte b:digest){
         sb.append(Integer.toHexString((int)(b & 0xff)));
         
     }
         return sb.toString();
     
     }
     
     public static String cifrarSHA1(String contraseña) throws NoSuchAlgorithmException{
         MessageDigest md = MessageDigest.getInstance("SHA1");
         
         md.update(contraseña.getBytes());
         byte [] digest = md.digest();
         StringBuilder sb = new StringBuilder();
         for(byte b:digest){
         sb.append(Integer.toHexString((int)(b & 0xff)));
         
     }
         
         return sb.toString();
     }
     
    /* public static void main(String[] args) {
        String contraseña = "password123";
        try{
            System.out.println(cifrarMD5(contraseña));
            System.out.println(cifrarSHA1(contraseña));
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }*/
}
