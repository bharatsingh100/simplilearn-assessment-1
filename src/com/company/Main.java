package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the command line application by Bharat Singh Kushwah");

        File projectDir = new File("src/com/company/opFiles");
	    boolean start = true;
	    while(start){

	        System.out.println("To see the list of files press 1, \nto do other operations such as " +
                    "adding a file, deleting a file or search a file press 2, \nto exit the application " +
                    "press 0");
            char n = sc.next().charAt(0);

            if(n == '1') firstOption(projectDir);
            if(n == '2') secondOption(sc,projectDir);
            if(n == '0') start = false;
        }

    }

    private static void firstOption(File projectDir){
        File files[] = projectDir.listFiles();
        String fileNames[] = new String[files.length];
        for(int i=0; i<files.length; i++){
            fileNames[i] = files[i].getName();
        }
        Arrays.sort(fileNames);

        System.out.println("Files are");
        for(int i=0; i<files.length; i++){
            System.out.println(fileNames[i]);
        }
    }

    private static void secondOption(Scanner sc,File projectDir){
        boolean cont = true;

        while(cont){
            System.out.println("To add new file press 1, to delete a file press 2, \nto search a file" +
                    " press 3 or to get back to main menu press 0");
            char c = sc.next().charAt(0);
            if(c == '1'){
                System.out.println("Enter the location of file you want to add to application directory");
                String fileSource = sc.next();
                System.out.println("Enter file name");
                String filename = sc.next();
                Path source = Paths.get(fileSource);
                Path destFilePath = Paths.get(projectDir.getPath().toString() + "/" + filename);
                try{
                    Files.copy(source,destFilePath,REPLACE_EXISTING);
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }

            }
            else if(c == '2'){
                System.out.println("Enter name of file to be deleted");
                String filename = sc.next();
                Path filepath = Paths.get(projectDir.getPath() + "/" + filename);
                try {
                    Files.delete(filepath);
                }
                catch (IOException e){
                    System.out.println(e.getMessage());
                }

            }
            else if(c == '3'){
                System.out.println("Enter file name to search");
                String filename = sc.next();
                File files[] = projectDir.listFiles();
                boolean flag = false;
                for(int i=0; i<files.length; i++){
                    if(files[i].getName().equals(filename)){
                        flag = true;
                    }
                }
                if(flag) System.out.println("File found");
                else System.out.println("File not found");
            }
            else if(c == '0') break;
            else{
                System.out.println("invalid input try again");
            }
        }

    }


}
