import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockMe {
	static String directory;
	File folder_name;
	
public LockMe(){
	 directory = System.getProperty("user.dir");
	folder_name = new File(directory+"/files");
	if(!folder_name.exists()) {
		folder_name.mkdirs();
	}
	System.out.println("DIRECTORY: "+folder_name.getAbsolutePath()+"\n");
}
private static final String WELCOME_PROMPT = 
		"\n--------------------------------LockedMe.com--------------------------"+
			"\n-----------------------Developed By:Shreya Patidar--------------------\n";


void mainMenue() {
	// TODO Auto-generated method stub
	System.out.println("\nSelect any of the following: \n");
	System.out.println("\t->1.List files in directory \n");
	System.out.println("\t->2.Business-Level Operations Menu \n");
	System.out.println("\t->3.Exit from the application \n");
	
	
}
void secondaryMenuePrompt() {
	// TODO Auto-generated method stub
	System.out.println("\nEnter choice for Business Operations: \n");
	System.out.println("\t->a.Add a file \n");
	System.out.println("\t->b.Delete a file \n");
	System.out.println("\t->c.Search a file \n");
	System.out.println("\t->d.Return to main menu \n");

	
	
}

 void showPrimaryMenu() {
	 mainMenue();
	 try {
		 Scanner sc = new Scanner(System.in);
		 int option = sc.nextInt();
		 switch(option) {
		 case 1:{
			 showFiles();
			 showPrimaryMenu();
		 }
		 case 2:{
			 showSecondaryMenu();
		 }
		 case 3:{
			 System.out.println("Thank You");
			 System.exit(0);
		 }
		 default:
			 System.out.println("Please enter a correct choice");
			 showPrimaryMenu();
		 }
	 }
	 catch(Exception e) {
		 System.out.println("Please enter 1,2 or 3");
		 showPrimaryMenu();
	 }
 }
 
 

void showSecondaryMenu() {
	secondaryMenuePrompt();
	 try {
		 Scanner sc = new Scanner(System.in);
		 char[] input = sc.nextLine().toLowerCase().trim().toCharArray();
		 char option = input[0];
		 
		 switch(option) {
		 case 'a':{
			 System.out.println("Enter the name of file to be added: ");
			 String filename = sc.next().trim().toLowerCase();
			 addFile(filename);
			 break;
		 }
		 case 'b':{
			 System.out.println("Enter the name of file to be deleted: ");
			 String filename = sc.next().trim().toLowerCase();
			 deleteFile(filename);
			 break;
		 }
		 case 'c':{
			 System.out.println("Enter the name of file to be searched: ");
			 String filename = sc.next().trim().toLowerCase();
			 searchFile(filename);
			 break;
		 }
		 case 'd':{
			 System.out.println("Going back to main menu");
			 showPrimaryMenu();
			 break;
		 }
		 default:System.out.println("Please enter a correct choice (a,b,c or d)");
		 }
		 showSecondaryMenu();
	 }
	 catch(Exception e) {
		 System.out.println("Please enter a,b,c or d");
		 showSecondaryMenu();
		 
	 }
 }
void showFiles() {
	// TODO Auto-generated method stub
	if(folder_name.list().length==0) {
		System.out.println("Folder is empty");
		
	}
	else {
		String[] list = folder_name.list();
		System.out.println("The file present in "+folder_name+" are :");
		Arrays.sort(list);
        for( String str:list) {
        	System.out.println(str);
        }
	}
	
}
void addFile(String filename) throws IOException{
	File filepath = new File(folder_name+"/"+filename);
	String[] list = folder_name.list();
	for(String file: list) {
		if(filename.equalsIgnoreCase(file)) {
			System.out.println("File "+filename+" already exists at "+folder_name);
			return;
		}
	}
	filepath.createNewFile();
	System.out.println("File: "+filename+" added to "+folder_name);
}
 void deleteFile(String filename) {
	 File filepath = new File(folder_name+"/"+filename);
	 String[] list = folder_name.list();
	 for(String file: list) {
		 if(filename.equals(file) && filepath.delete()) {
			 System.out.println("File "+filename+" deleted from "+folder_name);
			 return;
		 }
	 }
	 System.out.println("Delete operation failed.FILE NOT FOUND");
 }
 void searchFile(String filename) {
	 String[] list = folder_name.list();
	 for(String file:list) {
		 if(filename.equals(file)) {
			 System.out.println("File "+filename+" exists at "+folder_name);
			 return;
		 }
	 }
	 System.out.println("File not Found");
 }
public static void main(String[] args) {
	System.out.println(WELCOME_PROMPT);
	LockMe n = new LockMe();
	n.showPrimaryMenu();
}
}
