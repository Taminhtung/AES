import java.io.IOException;
import java.util.*;

public class SubjectManagement {
	private Scanner input = new Scanner(System.in);
	private ArrayList<Subject> arrsbj= new ArrayList<Subject>(); 
	
	/********Contructor******/
	public SubjectManagement() {
	}

	/*************getter and setter*****************/
	public ArrayList<Subject> getArrsbj() {
		return arrsbj;
	}

	public void setArrsbj(ArrayList<Subject> arrsbj) {
		this.arrsbj = arrsbj;
	}
	
	/*********Them 1 mon hoc*********/
	public void Add1Subject() throws IOException{
		boolean c=true;
		while(c){
			System.out.println("Enter new subject: ");
			System.out.print("Enter SubjectID:");
			String temp = input.next();
			String SubjectID = temp;
			System.out.print("Enter SubjectName: ");
			temp = input.next();
			String SubjectName=temp;
			System.out.print("Enter quota: ");
			temp = input.next();
			int quota = Integer.parseInt(temp);
			System.out.print("Enter currentEnrolment: ");
			temp = input.next();
			int CurrentEnrolment = Integer.parseInt(temp);
			if(CurrentEnrolment>quota){
				System.out.print("Enter Error! Try Again");
			}
			else {
				Subject newSubject = new Subject(SubjectID, SubjectName, quota, CurrentEnrolment);
				arrsbj.add(newSubject);
				c=false;
			}
		}
	}
	
    /*********Them nhieu mon hoc**************/
	public void AddSubject() throws IOException{
		int i=0;
		int check=1;
		while(check==1){
			if(i<20){
				i++;
				Add1Subject();
				System.out.println("Do you continue to add subject to list? [0-Don't / 1-Do ]");
				check=input.nextInt();
			}
			else{
				System.out.println("List fulled. You can't add"); break;
			}
		}
	}
	
	/**Tim kiem thong tin 1 mon hoc theo ma mon hoc va them/huy dang ki ***/
	public void SearchThenAction(String Sid){
		Subject sbj= new Subject();
		Iterator<Subject> it= arrsbj.iterator();
		boolean c=false;
		while (it.hasNext()){
			sbj = it.next();
			if(sbj.getSubjectID().equals(Sid)){
				System.out.println("\nSubject information before :");
				sbj.displaySubjectInfo();
				c=true;
			    break;
			}    
		}
		if(c){
			System.out.println("Do you want enrol or unenrol student to this subject: [0-Don't more/ 1- enrol / 2-unenrol]");
			int temp = input.nextInt();
			switch(temp){
			    case 0: break;
				case 1: sbj.enrolStudent(); break;
				case 2: sbj.unEnrolStudent();
			}
			while(temp!=0){
				System.out.println("Do you want enrol or unenrol student to this subject: [0-Don't more/ 1- enrol / 2-unenrol");
			    temp = input.nextInt();
				switch(temp){
				    case 0: break;
					case 1: sbj.enrolStudent();break;
					case 2: sbj.unEnrolStudent();
				}
			}
			System.out.println("\nSubject information after :");
			sbj.displaySubjectInfo();
		}  
		else  System.out.println("No subject have id "+Sid);
	}
	
	/**************Chuyen n sinh vien tu mon A sang B**************/
	public void MoveStudent(int n, String idA, String idB){
		if(idA.equals(idB)){
			System.out.println("Subject source and destination are same ");
		}
		else{
			Subject sbjA= new Subject();
			Subject sbjB= new Subject();
			Iterator<Subject> it= arrsbj.iterator();
			boolean cA=false, cB=false;
			while (it.hasNext()){
				Subject sbj = it.next();
				if(sbj.getSubjectID().equals(idA)){
					cA=true;
					sbjA=sbj;
				}
				if(sbj.getSubjectID().equals(idB)){
					cB=true;
					sbjB=sbj;
				}
				if(cA && cB) break;
		    }
			if(!cA) System.out.println("No subject have id "+idA);
			else if(!cB) System.out.println("No subject have id "+idB);
			     else{
			    	 System.out.println("\nSubject A before : ");
			    	 sbjA.displaySubjectInfo();
			    	 System.out.println("\nSubject B before : ");
			    	 sbjB.displaySubjectInfo();
			    	 if(sbjA.getCurrentEnrolment()<n) 
			    		 System.out.println("Not enough student in A to move! ");
			    	 else
			    		 if(sbjB.getQuota()< sbjB.getCurrentEnrolment()+n)
			    			 System.out.println("Quota B reached. Cant't move!");
			    		 else {
			    			 sbjA.setCurrentEnrolment(sbjA.getCurrentEnrolment() -n);
			    			 sbjB.setCurrentEnrolment(sbjB.getCurrentEnrolment() +n);
			    			 System.out.println("\nSubject A after : ");
					    	 sbjA.displaySubjectInfo();
					    	 System.out.println("\nSubject B after : ");
					    	 sbjB.displaySubjectInfo();
			    		 }
			    	 
			     }
		}
	}
	
	/*********hien thi thong tin 1 mon************/
	public void displayinfo(Subject sbj){
		sbj.displaySubjectInfo();
	}
	
	/*******hien thi thong tin tat ca cac mon*****/
	public void displaylist(){
		System.out.println("List subject: ");
		int i=1;
		Iterator<Subject> it= arrsbj.iterator();
		while (it.hasNext()){
			Subject sbj = it.next();
			System.out.println("\nNo. "+i);
			i++;
			sbj.displaySubjectInfo();
		}
	}
}
