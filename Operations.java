package com.project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Operations {

	public BufferedOutputStream wstream;
	public Scanner scanner = new Scanner(System.in);
    public BufferedInputStream  rstream;


	//to create user specified files and to give user defined content to the files
	public void createFile() {

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
			System.out.println("Sorry, folder doesn't exist. Try again");
		} catch (IOException e) {
		  System.out.println("Something went wrong, try again");
		}finally {
			if(wstream != null) {
				try {
					wstream.close();
				} catch (IOException e) {
					System.out.println("Something went wrong, try again");
				}
			}
		}
	}




	//to read the user given file by scanner 
	public void readFile() throws FileNotFoundException {
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





	//to delete the user defined file from the repository
	public void deleteFile() {
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




	//to list all the file
	public void listFile() {
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