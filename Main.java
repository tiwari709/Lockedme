package com.project;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static BufferedOutputStream wstream;
	static Scanner scanner = new Scanner(System.in);
    public static BufferedInputStream  rstream;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Operations op= new Operations();
		
		System.out.println("Welcome to LockedMe.Com developed by Rohit Tiwari ");
		System.out.println(" ");
		
		op.listFile();
		//conditional rendering of operations using a a loop
		while(true) {
			System.out.println(" ");
			System.out.println("press y to continue to operations, press n to exit");
			String ask = scanner.nextLine();
			
			if(ask.equals("y")) {
				//number of operations that can be performed
			System.out.println("Enter c: create file");
			System.out.println("Enter r: read file");
			System.out.println("Enter d: delete file");
			System.out.println("Enter l: list of files ");
			System.out.println("Enter e: to exit");
			}else if(ask.equals("n")) {
				break;
			}
			
			String command = scanner.nextLine();
			
			if(command.equals("c")) {
				op.createFile();
			}else if(command.equals("r")) {
				try {
				op.readFile();
				} catch (FileNotFoundException e) {
					System.out.println("File doesn't exists");
				}
			}else if(command.equals("d")) {
				op.deleteFile();
			}else if(command.equals("l")) {
				op.listFile();
			}else if(command.equals("e")) {
				break;
			   }
	  }
	}
	

	public static void createFile() {
		System.out.println("Enter file name");
		String fileName = scanner.nextLine();
		String path = "files/"+fileName;
		try {
			wstream = new BufferedOutputStream(new FileOutputStream(path));

			System.out.println("Enter Content");
			String content = scanner.nextLine();
			String a = content;
			wstream.write(a.getBytes());
			System.out.println("sucessfully created file and added content");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(wstream != null) {
				try {
					wstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	public static void readFile() throws FileNotFoundException {
		System.out.println("Enter file name");
		String fileName = scanner.nextLine();
		String path = "files/"+fileName;
	    File file = new File(path);

		try (Scanner sc = new Scanner(file)) {
			while(sc.hasNextLine()) {
				   System.out.print(sc.nextLine());
			   }
			System.out.println(" ");
			sc.close();
		}
	  }
	

	public static void deleteFile() {
		System.out.println("Enter file name");
		String fileName = scanner.nextLine();
		String path = "files/"+fileName;
		File file = new File(path);

		boolean a = file.delete();
		if(a) {
			System.out.println("file deleted Sucessfully");
		}else {
			System.out.println("file not found");
		}

	}

	public static void listFile() {
		//Creating a File object for directory
	      File directoryPath = new File("files");
	      //List of all files and directories
	      File filesList[] = directoryPath.listFiles();
	      System.out.println("List of files in the directory:");
	      System.out.println(" ");
	      for(File file : filesList) {
	         System.out.println("File name: "+file.getName());
	      }
	}
}
