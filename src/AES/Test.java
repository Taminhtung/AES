package AES;





public class Test {
	 
      
      public static void main(String arg[]) throws Exception {
    	  CBCmode cbcm= new CBCmode();
    	  String s="This message was encrypted and decrypted by AES Algorithm with CBC mode!";
    	  System.out.println("CBC mode :");
    	  System.out.println("input: "+s);
   	   	  System.out.println("key: "+cbcm.getKey());
   	   	  System.out.println("iv:  "+cbcm.getIv());
   	   	  String c= cbcm.encrypt(s);
   	   	  String p=cbcm.decrypt(c);
   	   	  System.out.println("ciphertext: "+c);
   	   	  System.out.println("plaintext: "+p);
   	   	   
    	  CTRmode ctrm= new CTRmode();
    	  s="This message was encrypted and decrypted by AES Algorithm with CTR mode!";
    	  System.out.println("\nCTR mode :");
     	  System.out.println("input: "+s);
    	  System.out.println("key: "+ctrm.getKey());
    	  System.out.println("iv:  "+ctrm.getIv());
    	  c= ctrm.encrypt(s);
    	  p=ctrm.decrypt(c);
    	  System.out.println("ciphertext: "+c);
    	  System.out.println("plaintext: "+p);
    	  
    	   
    	   
    	  
    	   
    	   
      }		 

	}
     
