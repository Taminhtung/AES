package AES;

public class Block {
    private int[][] data ;
    
    public Block(){
    	data = new int[4][4]; 
    }

	public int[][] getData() {
		return data;
	}

	public void setData(int[][] data) {
		this.data = data;
	}
    
	public static Block xorblock(Block b1, Block b2){
		int[][] dt1=b1.getData();
		int[][] dt2=b2.getData();
		int[][] dtrs=new int[4][4];
		for(int i=0; i<4; i++)
			for(int j =0; j<4; j++)
				dtrs[i][j]=dt1[i][j]^dt2[i][j];
		Block rs = new Block();
		rs.setData(dtrs);
		return rs;
		
	} 
	
	public Block add( int n){
		Block rs = new Block();
		if(n==0){
			return this;
		}
		else{
			int[][] dt2=new int[4][4];
			for(int i=0; i<4; i++)
				for(int j =0; j<4; j++)
					dt2[i][j]=data[i][j];
			int i=15;
			int d=n;
			int e=0;
			while(i>=0){
				e=(dt2[i/4][i%4]+d)%256;
				d=(dt2[i/4][i%4]+d)/256;
				dt2[i/4][i%4]=e;
				if(d>0) i--;
				else break;
			}
			
			rs.setData(dt2);
			return rs;
		}
	}
	
    public String toString() {
    	String s="";
    	 for(int i=0; i<16; i++){
        	 if(i%4==0) s=s+'\n';
        	 s=s+" "+data[i/4][i%4];
         }
    	 s+='\n';
    	return s;
    	}
}
