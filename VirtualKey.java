package phase_1_project;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;

public class VirtualKey {
	
	static void userInput(){
		Scanner sc = new Scanner(System.in);
		int a,b;
		while(true)
		{
			System.out.println("Choose the following options to proceed:");
			System.out.println("1. List the files");
			System.out.println("2. Business-level operations");
			System.out.println("3. Close the application");
			try {
			a = sc.nextInt();
			
			switch(a)
			{
			case 1:
				listFile();
				break;
				
			case 2:
				System.out.println("\nChoose the following options to proceed:");
				System.out.println("1. Add a file");
				System.out.println("2. Delete a file");
				System.out.println("3. Search a file");
				try {
				b = sc.nextInt();
				switch(b)
				{
				case 1:
					System.out.println("Enter the name of the file");
					String fileCreating = sc.next();
					createFile(fileCreating);
					break;
					
				case 2:
					System.out.println("Enter the filename to delete");
					String fileDeleting = sc.next();
					deleteFile(fileDeleting);
					break;
					
				case 3:
					searchFile();
					break;
					
				default:
					System.out.println("Invalid input");
					break;
					
				}
				break;
				}
				catch(Exception e){
					System.out.println("Please provide valid input!");
					userInput();
				}
			case 3:
				System.out.println("Thank You!");
				System.exit(0);
				
			default:
				System.out.println("Invalid input");
				break;

			}
			}
			catch(Exception e){
				System.out.println("Please provide valid input!");
				userInput();
			}
		}
	}
	
	static void listFile()
	{
		File file = new File("C://test//");
		String filename[] = file.list();
		String temp;
		for(int i=0; i<filename.length; i++)
		{
			for(int j=i+1; j<filename.length; j++)
			{
				if(filename[i].compareTo(filename[j])>0) {
	    			temp = filename[i];
	    			filename[i]=filename[j];
	    			filename[j]=temp;
				}
			}
			
		}
		System.out.println("Sorted order:");
		for(int i=0; i<filename.length; i++)
		{
			System.out.println(filename[i]);
		}
	}
	
	static void createFile(String name)throws IOException
	{
		File file = new File("C://test//"+ name+".txt");
		
		if(file.createNewFile())
		{
			System.out.println("File is created successfully.");
		}
		else
		{
			System.out.println("File already exists.");	
		}
		
	}
	
	static void deleteFile(String name)
	{
		File file = new File("C://test//"+name+".txt");
		
		if(file.exists()) {
			if ( file.delete() ) {
				System.out.println("File deleted successfully!");
			}
		} else {
			System.out.println("File Not Found");
		}
	}
	static void searchFile()
	{
		File file = new File("C://test//");
		String filename[] = file.list();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the filename to search:");
		String name = sc.next();
		name = name.concat(".txt");
		boolean temp = false;
		
		for(int i=0;i<filename.length;i++) {
        	if(filename[i].equals(name)) {
        		temp = true;
        		break;
        	}
        	else {
        		temp = false;
        	}
        }
        if(temp == true) {
        	System.out.println( " File exists!");
        }
        else {
        	System.out.println("File not found");
        }
		
	}
	

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t Welcome to Locker Pvt Ltd.");
		System.out.println("\t Developed by Sathiyanantham M N");
		System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		userInput();
		
	}

}
