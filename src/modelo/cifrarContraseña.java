
package modelo;
import java.security.MessageDigest;

public class cifrarContraseña {
    public static String getHash (String txt, String hashType){
        try{
            MessageDigest md = MessageDigest.getInstance(txt);
            
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            
            for(int i=0;i<array.length;i++){
                sb.append(Integer.toHexString((array[i] & 0xff) | 0x100).substring(1,5));
            }
            
            return sb.toString();
            
        }catch(java.security.NoSuchAlgorithmException e ){
            System.out.println(e.getMessage());  
        }
        
        
        return null;
    }
    
    public static String md5(String txt){
        return cifrarContraseña.getHash(txt,"MD5");
    }
    
    public static String sha1(String txt){
        return cifrarContraseña.getHash(txt,"SHA1");
    }
}
