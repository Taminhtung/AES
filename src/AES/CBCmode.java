package AES;

public class CBCmode {
    private Block iv;
    private AES aes;

    
    public CBCmode() {
    	int[][] dt = new int[4][4];
    	for(int i=0; i<16; i++)
    		dt[i/4][i%4]=(int)(Math.random()*256);
    	this.iv= new Block();
    	this.iv.setData(dt);
    	this.aes = new AES();
	}
    
    public String getIv() {
    	String siv="";
		for(int i=0; i<16; i++){
			siv+=AES.toHex(this.iv.getData()[i/4][i%4]);
		}
		return siv;
	}
    
    public String encrypt(String plaintext){
    	String ciphertext="";
    	Block bl= new Block();
    	Block rs= new Block();
    	Block ivt= this.iv;
		int lg = plaintext.length(); 
		int nb=lg/16;
		for(int i=0;i<=nb;i++){
			 int[][] dt = new int[4][4];
			 for(int j=0; j<16;j++){
				 if((i*16+j)<lg)
				 	 dt[j/4][j%4]=(int)(plaintext.charAt(i*16+j));
				 else dt[j/4][j%4]=0x05;	
			 }
			 bl.setData(dt);
			 rs= Block.xorblock(bl, ivt);
			 rs=aes.encrypt(rs); 
			 ivt=rs;
			 for(int j=0; j<16; j++){
				 ciphertext+=AES.toHex(rs.getData()[j/4][j%4]);
			 }
		 }
    	return ciphertext; 
    }
    
    public String decrypt(String ciphertext) {
		String plaintext="";
		Block bl= new Block();
		Block rs= new Block();
		Block ivt= this.iv;
		int lg = ciphertext.length();
		int nb=lg/32;
		for(int i=0;i<nb;i++){
			 int[][] dt = new int[4][4];
			 for(int j=0; j<16;j++){
				 if(i*32+j*2<lg)
					 dt[j/4][j%4]=AES.HextoInt(ciphertext.charAt(i*32+j*2), ciphertext.charAt(i*32+j*2+1));
				 else dt[j/4][j%4]=0;
			 }
			 bl.setData(dt);
			 rs=aes.decrypt(bl);
			 rs= Block.xorblock(rs, ivt);
			 ivt.setData(dt);
			 for(int j=0; j<16; j++){
				 if((i*16+j)<lg)
				    if(rs.getData()[j/4][j%4]!=5) 
					 plaintext+=(char)(rs.getData()[j/4][j%4]);
			 }
		 }
		return plaintext;
	}
    
    public String getKey(){
    	String key= aes.getKey();
    	return key;
    }

}
