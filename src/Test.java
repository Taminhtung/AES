import java.io.IOException;
import java.util.*;


public class Test {
	private static Scanner input= new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		 SubjectManagement sbjmng = new SubjectManagement();
		 
		 /*********************Them danh sach mon hoc********************/ 
		 sbjmng.AddSubject();
		 System.out.println("******************");
		 
		 /**********************Hien thi danh sach mon hoc***********************/
		 sbjmng.displaylist();
		 System.out.println("******************");
		 
		 /***********Tim kiem mon hoc ; dang ki / huy dang ki sinh vien*****************/
		 System.out.print("Enter Subject id: ");
		 String sid = input.next();
		 sbjmng.SearchThenAction(sid);
		 System.out.println("****************** ");
		 
		 /***************************chuyen n sinh vien tu mon A sang mon B************************/
		 System.out.print("Enter number student you want move: ");
		 int n = input.nextInt();
		 System.out.print("Enter ID of Subject A: ");
		 String sidA = input.next();
		 System.out.print("Enter ID of Subject B: ");
		 String sidB = input.next();
		 sbjmng.MoveStudent(n, sidA, sidB);
	}

}
