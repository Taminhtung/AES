package AES;
public class AES {
	private  int[][] SBox = new int[16][16];
	private int[][] invSBox = new int[16][16];
	private int[] key = new int[16];
	public  long[] Ekey= new long[44];
	 public AES(){
		SBox[0][0]=0x63;  SBox[0][1]=0x7c;   SBox[0][2]=0x77;   SBox[0][3]=0x7b;   SBox[0][4]=0xf2;   SBox[0][5]=0x6B;  SBox[0][6]=0x6F;   SBox[0][7]=0xC5;
		SBox[0][8]=0x30;  SBox[0][9]=0x01;   SBox[0][10]=0x67;  SBox[0][11]=0x2b;  SBox[0][12]=0xfe;  SBox[0][13]=0xd7; SBox[0][14]=0xab;  SBox[0][15]=0x76;
		SBox[1][0]=0xca;  SBox[1][1]=0x82;   SBox[1][2]=0xc9;   SBox[1][3]=0x7d;   SBox[1][4]=0xfa;   SBox[1][5]=0x59;  SBox[1][6]=0x47;   SBox[1][7]=0xf0;
		SBox[1][8]=0xad;  SBox[1][9]=0xd4;   SBox[1][10]=0xa2;  SBox[1][11]=0xaf;  SBox[1][12]=0x9c;  SBox[1][13]=0xa4; SBox[1][14]=0x72;  SBox[1][15]=0xc0;
		SBox[2][0]=0xb7;  SBox[2][1]=0xfd;   SBox[2][2]=0x93;   SBox[2][3]=0x26;   SBox[2][4]=0x36;   SBox[2][5]=0x3f;  SBox[2][6]=0xf7;   SBox[2][7]=0xcc;
		SBox[2][8]=0x34;  SBox[2][9]=0xa5;   SBox[2][10]=0xe5;  SBox[2][11]=0xf1;  SBox[2][12]=0x71;  SBox[2][13]=0xd8; SBox[2][14]=0x31;  SBox[2][15]=0x15;	
		SBox[3][0]=0x04;  SBox[3][1]=0xc7;   SBox[3][2]=0x23;   SBox[3][3]=0xc3;   SBox[3][4]=0x18;   SBox[3][5]=0x96;  SBox[3][6]=0x05;   SBox[3][7]=0x9a;
		SBox[3][8]=0x07;  SBox[3][9]=0x12;   SBox[3][10]=0x80;  SBox[3][11]=0xe2;  SBox[3][12]=0xeb;  SBox[3][13]=0x27; SBox[3][14]=0xb2;  SBox[3][15]=0x75;		
		SBox[4][0]=0x09;  SBox[4][1]=0x83;   SBox[4][2]=0x2c;   SBox[4][3]=0x1a;   SBox[4][4]=0x1b;   SBox[4][5]=0x6e;  SBox[4][6]=0x5a;   SBox[4][7]=0xa0;
		SBox[4][8]=0x52;  SBox[4][9]=0x3b;   SBox[4][10]=0xd6;  SBox[4][11]=0xb3;  SBox[4][12]=0x29;  SBox[4][13]=0xe3; SBox[4][14]=0x2f;  SBox[4][15]=0x84;	
		SBox[5][0]=0x53;  SBox[5][1]=0xd1;   SBox[5][2]=0x00;   SBox[5][3]=0xed;   SBox[5][4]=0x20;   SBox[5][5]=0xfc;  SBox[5][6]=0xb1;   SBox[5][7]=0x5b;
		SBox[5][8]=0x6a;  SBox[5][9]=0xcb;   SBox[5][10]=0xbe;  SBox[5][11]=0x39;  SBox[5][12]=0x4a;  SBox[5][13]=0x4c; SBox[5][14]=0x58;  SBox[5][15]=0xcf;	
		SBox[6][0]=0xd0;  SBox[6][1]=0xef;   SBox[6][2]=0xaa;   SBox[6][3]=0xfb;   SBox[6][4]=0x43;   SBox[6][5]=0x4d;  SBox[6][6]=0x33;   SBox[6][7]=0x85;
		SBox[6][8]=0x45;  SBox[6][9]=0xf9;   SBox[6][10]=0x02;  SBox[6][11]=0x7f;  SBox[6][12]=0x50;  SBox[6][13]=0x3c; SBox[6][14]=0x9f;  SBox[6][15]=0xa8;
		SBox[7][0]=0x51;  SBox[7][1]=0xa3;   SBox[7][2]=0x40;   SBox[7][3]=0x8f;   SBox[7][4]=0x92;   SBox[7][5]=0x9d;  SBox[7][6]=0x38;   SBox[7][7]=0xf5;
		SBox[7][8]=0xbc;  SBox[7][9]=0xb6;   SBox[7][10]=0xda;  SBox[7][11]=0x21;  SBox[7][12]=0x10;  SBox[7][13]=0xff; SBox[7][14]=0xf3;  SBox[7][15]=0xd2;	
		SBox[8][0]=0xcd;  SBox[8][1]=0x0c;   SBox[8][2]=0x13;   SBox[8][3]=0xec;   SBox[8][4]=0x5f;   SBox[8][5]=0x97;  SBox[8][6]=0x44;   SBox[8][7]=0x17;
		SBox[8][8]=0xc4;  SBox[8][9]=0xa7;   SBox[8][10]=0x7e;  SBox[8][11]=0x3d;  SBox[8][12]=0x64;  SBox[8][13]=0x5d; SBox[8][14]=0x19;  SBox[8][15]=0x73;	
		SBox[9][0]=0x60;  SBox[9][1]=0x81;   SBox[9][2]=0x4f;   SBox[9][3]=0xdc;   SBox[9][4]=0x22;   SBox[9][5]=0x2a;  SBox[9][6]=0x90;   SBox[9][7]=0x88;
	    SBox[9][8]=0x46;  SBox[9][9]=0xee;   SBox[9][10]=0xb8;  SBox[9][11]=0x14;  SBox[9][12]=0xde;  SBox[9][13]=0x5e; SBox[9][14]=0x0b;  SBox[9][15]=0xdb;		
	    SBox[10][0]=0xe0; SBox[10][1]=0x32;  SBox[10][2]=0x3a;  SBox[10][3]=0x0a;  SBox[10][4]=0x49;  SBox[10][5]=0x06; SBox[10][6]=0x24;  SBox[10][7]=0x5c;
		SBox[10][8]=0xc2; SBox[10][9]=0xd3;  SBox[10][10]=0xac; SBox[10][11]=0x62; SBox[10][12]=0x91; SBox[10][13]=0x95;SBox[10][14]=0xe4; SBox[10][15]=0x79;		
		SBox[11][0]=0xe7; SBox[11][1]=0xc8;  SBox[11][2]=0x37;  SBox[11][3]=0x6d;  SBox[11][4]=0x8d;  SBox[11][5]=0xd5; SBox[11][6]=0x4e;  SBox[11][7]=0xa9;
		SBox[11][8]=0x6c; SBox[11][9]=0x56;  SBox[11][10]=0xf4; SBox[11][11]=0xea; SBox[11][12]=0x65; SBox[11][13]=0x7a;SBox[11][14]=0xae; SBox[11][15]=0x08;		
		SBox[12][0]=0xba; SBox[12][1]=0x78;  SBox[12][2]=0x25;  SBox[12][3]=0x2e;  SBox[12][4]=0x1c;  SBox[12][5]=0xa6; SBox[12][6]=0xb4;  SBox[12][7]=0xc6;
		SBox[12][8]=0xe8; SBox[12][9]=0xdd;  SBox[12][10]=0x74; SBox[12][11]=0x1f; SBox[12][12]=0x4b; SBox[12][13]=0xbd;SBox[12][14]=0x8b; SBox[12][15]=0x8a;
		SBox[13][0]=0x70; SBox[13][1]=0x3e;  SBox[13][2]=0xb5;  SBox[13][3]=0x66;  SBox[13][4]=0x48;  SBox[13][5]=0x03; SBox[13][6]=0xf6;  SBox[13][7]=0x0e;
		SBox[13][8]=0x61; SBox[13][9]=0x35;  SBox[13][10]=0x57; SBox[13][11]=0xb9; SBox[13][12]=0x86; SBox[13][13]=0xc1;SBox[13][14]=0x1d; SBox[13][15]=0x9e;	
		SBox[14][0]=0xe1; SBox[14][1]=0xf8;  SBox[14][2]=0x98;  SBox[14][3]=0x11;  SBox[14][4]=0x69;  SBox[14][5]=0xd9; SBox[14][6]=0x8e;  SBox[14][7]=0x94;
		SBox[14][8]=0x9b; SBox[14][9]=0x1e;  SBox[14][10]=0x87; SBox[14][11]=0xe9; SBox[14][12]=0xce; SBox[14][13]=0x55;SBox[14][14]=0x28; SBox[14][15]=0xdf;
		SBox[15][0]=0x8c; SBox[15][1]=0xa1;  SBox[15][2]=0x89;  SBox[15][3]=0x0d;  SBox[15][4]=0xbf;  SBox[15][5]=0xe6; SBox[15][6]=0x42;  SBox[15][7]=0x68;
		SBox[15][8]=0x41; SBox[15][9]=0x99;  SBox[15][10]=0x2d; SBox[15][11]=0x0f; SBox[15][12]=0xb0; SBox[15][13]=0x54;SBox[15][14]=0xbb; SBox[15][15]=0x16; 
		
		invSBox[0][0]=0x52;  invSBox[0][1]=0x09;  invSBox[0][2]=0x6a;   invSBox[0][3]=0xd5;  invSBox[0][4]=0x30;   invSBox[0][5]=0x36;   invSBox[0][6]=0xa5;   invSBox[0][7]=0x38; 
		invSBox[0][8]=0xbf;  invSBox[0][9]=0x40;  invSBox[0][10]=0xa3;  invSBox[0][11]=0x9e; invSBox[0][12]=0x81;  invSBox[0][13]=0xf3;  invSBox[0][14]=0xd7;  invSBox[0][15]=0xfb;
		invSBox[1][0]=0x7c;  invSBox[1][1]=0xe3;  invSBox[1][2]=0x39;   invSBox[1][3]=0x82;  invSBox[1][4]=0x9b;   invSBox[1][5]=0x2f;   invSBox[1][6]=0xff;   invSBox[1][7]=0x87;
		invSBox[1][8]=0x34;  invSBox[1][9]=0x8e;  invSBox[1][10]=0x43;  invSBox[1][11]=0x44; invSBox[1][12]=0xc4;  invSBox[1][13]=0xde;  invSBox[1][14]=0xe9;  invSBox[1][15]=0xcb;
		invSBox[2][0]=0x54;  invSBox[2][1]=0x7b;  invSBox[2][2]=0x94;   invSBox[2][3]=0x32;  invSBox[2][4]=0xa6;   invSBox[2][5]=0xc2;   invSBox[2][6]=0x23;   invSBox[2][7]=0x3d;
		invSBox[2][8]=0xee;  invSBox[2][9]=0x4c;  invSBox[2][10]=0x95;  invSBox[2][11]=0x0b; invSBox[2][12]=0x42;  invSBox[2][13]=0xfa;  invSBox[2][14]=0xc3;  invSBox[2][15]=0x4e;		
		invSBox[3][0]=0x08;  invSBox[3][1]=0x2e;  invSBox[3][2]=0xa1;   invSBox[3][3]=0x66;  invSBox[3][4]=0x28;   invSBox[3][5]=0xd9;   invSBox[3][6]=0x24;   invSBox[3][7]=0xb2;
		invSBox[3][8]=0x76;  invSBox[3][9]=0x5b;  invSBox[3][10]=0xa2;  invSBox[3][11]=0x49; invSBox[3][12]=0x6d;  invSBox[3][13]=0x8b;  invSBox[3][14]=0xd1;  invSBox[3][15]=0x25;		
		invSBox[4][0]=0x72;  invSBox[4][1]=0xf8;  invSBox[4][2]=0xf6;   invSBox[4][3]=0x64;  invSBox[4][4]=0x86;   invSBox[4][5]=0x68;   invSBox[4][6]=0x98;   invSBox[4][7]=0x16;
		invSBox[4][8]=0xd4;  invSBox[4][9]=0xa4;  invSBox[4][10]=0x5c;  invSBox[4][11]=0xcc; invSBox[4][12]=0x5d;  invSBox[4][13]=0x65;  invSBox[4][14]=0xb6;  invSBox[4][15]=0x92;	
		invSBox[5][0]=0x6c;  invSBox[5][1]=0x70;  invSBox[5][2]=0x48;   invSBox[5][3]=0x50;  invSBox[5][4]=0xfd;   invSBox[5][5]=0xed;   invSBox[5][6]=0xb9;   invSBox[5][7]=0xda;
		invSBox[5][8]=0x5e;  invSBox[5][9]=0x15;  invSBox[5][10]=0x46;  invSBox[5][11]=0x57; invSBox[5][12]=0xa7;  invSBox[5][13]=0x8d;  invSBox[5][14]=0x9d;  invSBox[5][15]=0x84;	
		invSBox[6][0]=0x90;  invSBox[6][1]=0xd8;  invSBox[6][2]=0xab;   invSBox[6][3]=0x00;  invSBox[6][4]=0x8c;   invSBox[6][5]=0xbc;   invSBox[6][6]=0xd3;   invSBox[6][7]=0x0a;
		invSBox[6][8]=0xf7;  invSBox[6][9]=0xe4;  invSBox[6][10]=0x58;  invSBox[6][11]=0x05; invSBox[6][12]=0xb8;  invSBox[6][13]=0xb3;  invSBox[6][14]=0x45;  invSBox[6][15]=0x06;	
		invSBox[7][0]=0xd0;  invSBox[7][1]=0x2c;  invSBox[7][2]=0x1e;   invSBox[7][3]=0x8f;  invSBox[7][4]=0xca;   invSBox[7][5]=0x3f;   invSBox[7][6]=0x0f;   invSBox[7][7]=0x02;
		invSBox[7][8]=0xc1;  invSBox[7][9]=0xaf;  invSBox[7][10]=0xbd;  invSBox[7][11]=0x03; invSBox[7][12]=0x01;  invSBox[7][13]=0x13;  invSBox[7][14]=0x8a;  invSBox[7][15]=0x6b;	
		invSBox[8][0]=0x3a;  invSBox[8][1]=0x91;  invSBox[8][2]=0x11;   invSBox[8][3]=0x41;  invSBox[8][4]=0x4f;   invSBox[8][5]=0x67;   invSBox[8][6]=0xdc;   invSBox[8][7]=0xea;
		invSBox[8][8]=0x97;  invSBox[8][9]=0xf2;  invSBox[8][10]=0xcf;  invSBox[8][11]=0xce; invSBox[8][12]=0xf0;  invSBox[8][13]=0xb4;  invSBox[8][14]=0xe6;  invSBox[8][15]=0x73;		
		invSBox[9][0]=0x96;  invSBox[9][1]=0xac;  invSBox[9][2]=0x74;   invSBox[9][3]=0x22;  invSBox[9][4]=0xe7;   invSBox[9][5]=0xad;   invSBox[9][6]=0x35;   invSBox[9][7]=0x85;
		invSBox[9][8]=0xe2;  invSBox[9][9]=0xf9;  invSBox[9][10]=0x37;  invSBox[9][11]=0xe8; invSBox[9][12]=0x1c;  invSBox[9][13]=0x75;  invSBox[9][14]=0xdf;  invSBox[9][15]=0x6e;	
		invSBox[10][0]=0x47; invSBox[10][1]=0xf1; invSBox[10][2]=0x1a;  invSBox[10][3]=0x71; invSBox[10][4]=0x1d;  invSBox[10][5]=0x29;  invSBox[10][6]=0xc5;  invSBox[10][7]=0x89;
		invSBox[10][8]=0x6f; invSBox[10][9]=0xb7; invSBox[10][10]=0x62; invSBox[10][11]=0x0e;invSBox[10][12]=0xaa; invSBox[10][13]=0x18; invSBox[10][14]=0xbe; invSBox[10][15]=0x1b;
		invSBox[11][0]=0xfc; invSBox[11][1]=0x56; invSBox[11][2]=0x3e;  invSBox[11][3]=0x4b; invSBox[11][4]=0xc6;  invSBox[11][5]=0xd2;  invSBox[11][6]=0x79;  invSBox[11][7]=0x20;
		invSBox[11][8]=0x9a; invSBox[11][9]=0xdb; invSBox[11][10]=0xc0; invSBox[11][11]=0xfe;invSBox[11][12]=0x78; invSBox[11][13]=0xcd; invSBox[11][14]=0x5a; invSBox[11][15]=0xf4;	
		invSBox[12][0]=0x1f; invSBox[12][1]=0xdd; invSBox[12][2]=0xa8;  invSBox[12][3]=0x33; invSBox[12][4]=0x88;  invSBox[12][5]=0x07;  invSBox[12][6]=0xc7;  invSBox[12][7]=0x31;
		invSBox[12][8]=0xb1; invSBox[12][9]=0x12; invSBox[12][10]=0x10; invSBox[12][11]=0x59;invSBox[12][12]=0x27; invSBox[12][13]=0x80; invSBox[12][14]=0xec; invSBox[12][15]=0x5f;		
		invSBox[13][0]=0x60; invSBox[13][1]=0x51; invSBox[13][2]=0x7f;  invSBox[13][3]=0xa9; invSBox[13][4]=0x19;  invSBox[13][5]=0xb5;  invSBox[13][6]=0x4a;  invSBox[13][7]=0x0d;
		invSBox[13][8]=0x2d; invSBox[13][9]=0xe5; invSBox[13][10]=0x7a; invSBox[13][11]=0x9f;invSBox[13][12]=0x93; invSBox[13][13]=0xc9; invSBox[13][14]=0x9c; invSBox[13][15]=0xef;	
		invSBox[14][0]=0xa0; invSBox[14][1]=0xe0; invSBox[14][2]=0x3b;  invSBox[14][3]=0x4d; invSBox[14][4]=0xae;  invSBox[14][5]=0x2a;  invSBox[14][6]=0xf5;  invSBox[14][7]=0xb0;
		invSBox[14][8]=0xc8; invSBox[14][9]=0xeb; invSBox[14][10]=0xbb; invSBox[14][11]=0x3c;invSBox[14][12]=0x83; invSBox[14][13]=0x53; invSBox[14][14]=0x99; invSBox[14][15]=0x61;
		invSBox[15][0]=0x17; invSBox[15][1]=0x2b; invSBox[15][2]=0x04;  invSBox[15][3]=0x7e;  invSBox[15][4]=0xba; invSBox[15][5]=0x77;  invSBox[15][6]=0xd6;  invSBox[15][7]=0x26;
		invSBox[15][8]=0xe1; invSBox[15][9]=0x69; invSBox[15][10]=0x14; invSBox[15][11]=0x63; invSBox[15][12]=0x55;invSBox[15][13]=0x21; invSBox[15][14]=0x0c; invSBox[15][15]=0x7d;
		genkey();
		
		
	}
	
	 //tested 
	public Block subtituteByte(Block bl){
		Block rs= new Block();
		int[][] dt = bl.getData();
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				int s= dt[i][j];
				int a= s/16;
				int b= s%16;
				dt[i][j]=SBox[a][b]; 
			}	
		}
		rs.setData(dt);
		return rs;
	}
	
	//tested 
	public Block shiftRows(Block bl){
		Block rs= new Block();
		int[][] dt = bl.getData();
		int temp = dt[1][0];
		dt[1][0]=dt[1][1];dt[1][1]=dt[1][2];dt[1][2]=dt[1][3];dt[1][3]=temp;
		temp=dt[2][0];
		dt[2][0]=dt[2][2];dt[2][2]=temp;
		temp=dt[2][1];
		dt[2][1]=dt[2][3];dt[2][3]=temp;
		temp = dt[3][0];
		dt[3][0]=dt[3][3];dt[3][3]=dt[3][2];dt[3][2]=dt[3][1];dt[3][1]=temp;
	
		rs.setData(dt);
		return rs;
	}
	
	//tested 
	public Block mixColumns(Block bl){
		Block rs= new Block();
		int[][] dt= bl.getData();
		int[][] dt2= new int[4][4];
		/*nhan ma tran 
		 * 02 03 01 01               02=0000 0010  x.02 = x.2
		 * 01 02 03 01  x bl =rs     03=0000 0011  x.03 = x^x.2 
		 * 01 01 02 03             
		 * 03 01 01 02               01=0000 0001  x.01= x
		 * */
		int x=0,a,b;
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				x=0;
				for(int m=0; m<4; m++){
					a=dt[m][i];
					b=a*2;				
					if(b>255) b^=0x11b;
					switch((i+j-m+4)%4){
			    		case 0: x^=b; break;//.02
			    		case 1:	x^=a; break;//.01
			    		case 2: x^=a;  break;//.01 
			    		case 3: x^=a^b; break;//.03
					}
				}
				dt2[j][i]=x;
			}	
		}
		rs.setData(dt2);
		return rs;		
	}
	
	
	public Block addRoundKey(Block bl, int round){
	 	Block rs = new Block();
	 	Block b1 = blockKey(round);
	 	rs= Block.xorblock(bl, b1);
		return rs;
	}
	
	public void genkey(){
		for(int i=0; i<16; i++){
			this.key[i]=(int)(Math.random()*256);
			
		}
		for(int i=0; i<44; i++){
			keyExpansion(i);
		}
	}
	
	public String getKey(){
		String key="";
		for(int i=0; i<16; i++){
			key+=toHex(this.key[i]);
		}
		return key;
	}

	public void keyExpansion(int wordcount){
		long rs;
		if(wordcount<4 ) {
			rs=(long)key[wordcount*4]<<24;
			rs+=(long)key[wordcount*4+1]<<18;
			rs+=(long)key[wordcount*4+2]<<8;
			rs+=(long)key[wordcount*4+3];
		}
		else {
		   if(wordcount%4==0){
			   long a=Ekey[wordcount-1];
			   int a1,a2,a3,a4,i,j;
			   a=(a>>24)+((a-((a>>24)<<24))<<8);
			   a1=(int)(a>>24);
			   i=(int)a1>>4;
			   j=a1-(i<<4);
			   a1= SBox[i][j];
			   a2=(int)(a>>16)%256;
			   i=(int)a2>>4;
			   j=a2-(i<<4);
			   a2=SBox[i][j]; 
			   a3=(int)((a>>8)%256);
			   i=(int)a3>>4;
			   j=(int)(a3-(i<<4));
			   a3=SBox[i][j];
			   a4=(int)(a%256);
			   i=(int)a4>>4;
			   j=(int)(a4-(i<<4));
			   a4=SBox[i][j];
			   
			   a=(long)a1<<24;
			   a+=(long)a2<<16;
			   a+=(long)a3<<8;
			   a+=(long)(a4);
			   long b =(wordcount/4)<<24;
			   a=a^b;
			   rs=a^Ekey[wordcount-4];
		   }
		   else{
			   rs =Ekey[wordcount-1]^Ekey[wordcount-4];
		   }
		}
		Ekey[wordcount]=rs;
	}
	
	public Block encrypt(Block bl){
		Block rs=new Block();
		rs=addRoundKey(bl,0);
		for(int i=1;i<10; i++){
			rs=subtituteByte(rs);
			rs=shiftRows(rs);
			rs=mixColumns(rs);
			rs=addRoundKey(rs, i); 
		}
		rs=subtituteByte(rs);
		rs=shiftRows(rs);
		rs=addRoundKey(rs, 10);
		return rs;
	}
	
	//tested 
	
	public Block invSubByte(Block bl){
		Block rs= new Block();
		int[][] dt = bl.getData();
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				int s= dt[i][j];
				int a= s/16;
				int b= s%16;
				dt[i][j]=invSBox[a][b]; 
			}	
		}
		rs.setData(dt);
		return rs;
	}
	
	//tested 
	

	public Block invShiftRows(Block bl){
		Block rs= new Block();
		int[][] dt = bl.getData();
		int temp=dt[1][0];
		dt[1][0]=dt[1][3];dt[1][3]=dt[1][2];dt[1][2]=dt[1][1];dt[1][1]=temp;
		temp=dt[2][0];
		dt[2][0]=dt[2][2];dt[2][2]=temp;
		temp=dt[2][1];
		dt[2][1]=dt[2][3];dt[2][3]=temp;
		temp = dt[3][0];
		dt[3][0]=dt[3][1];dt[3][1]=dt[3][2];dt[3][2]=dt[3][3];dt[3][3]=temp;
		rs.setData(dt);
		return rs;
	}
	
	//tested 

	public Block invMixColumns( Block bl){
		Block rs= new Block();
		int[][] dt= bl.getData();
		int[][] dt2= new int[4][4];
		/*nhan ma tran 
		 * 0e 0b 0d 09               0e=0000 1110  x.0e = x.2^x.4^x.8
		 * 09 0e 0b 0d  x bl =rs     0b=0000 1011  x.0b = x^x.2^x.8 
		 * 0d 09 0e 0b               0d=0000 1101  x.0d = x^x.4^x.8
		 * 0b 0d 09 0e               09=0000 1001  x.09 = x^x.8
		 * */
		int x=0,a,b,c,d;
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				x=0;
				for(int m=0; m<4; m++){
					a=dt[m][i];
					b=a*2;
					if(b>255) b^=0x11b;
					c=b*2;
					if(c>255) c^=0x11b;
					d=c*2;
					if(d>255) d^=0x11b;
					switch((i+j-m+4)%4){
			    		case 0: x^=b^c^d; break; //.0e
			    		case 1:	x^=a^d;  break; //.09
			    		case 2: x^=a^c^d; break;//.0d 
			    		case 3: x^=a^b^d; break;//.0b
					}
				}
				
				dt2[j][i]=x;	
			}	
		}
	int temp=dt2[0][1];dt2[0][1]=dt2[2][1];dt2[2][1]=temp;
	temp=dt2[1][1];dt2[1][1]=dt2[3][1];dt2[3][1]=temp;
	temp=dt2[0][3];dt2[0][3]=dt2[2][3];dt2[2][3]=temp;
	temp=dt2[1][3];dt2[1][3]=dt2[3][3];dt2[3][3]=temp;
		rs.setData(dt2);
		return rs;
	}
	
	public Block decrypt(Block bl){
		Block rs= new Block();
		rs=addRoundKey(bl, 10);
		for(int i=9; i>0; i--){
			rs=invShiftRows(rs);
			rs=invSubByte(rs);
			rs=addRoundKey(rs, i);
			rs=invMixColumns(rs);
		}
		rs=invShiftRows(rs);
		rs=invSubByte(rs);
		rs=addRoundKey(rs, 0);
		return rs;
	}
	
	
	public Block blockKey(int round){
		int m=round*4;
		Block rs =new Block();
		int[][] dt = new int[4][4];
		for(int i=0; i<4; i++)
			for (int j=0; j<4; j++){
				dt[i][j]=(int)((Ekey[m+i]>>(8*(3-j)))%256);
			}
		rs.setData(dt);
		return rs;
	}
	
	public static String toHex(int i){
		char[] h = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String s="";
		s=h[i/16]+""+h[i%16];
		return s;
	}
	
	public static int HextoInt(char a, char b){
		 int rs=0;
		 char[] h = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		 for(int i=0; i<16; i++){
			 if(a==h[i]) rs+=i*16;
			 if(b==h[i]) rs+=i;
		 }
		 return rs;
	}
	

}
