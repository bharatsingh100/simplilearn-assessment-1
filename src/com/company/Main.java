package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the command line application by Bharat Singh Kushwah");

	    boolean start = true;
	    while(start){

	        System.out.println("To see the list of files press 1, \nto do other operations such as " +
                    "adding a file, deleting a file or search a file press 2, \nto exit the application " +
                    "press 0");
            char n = sc.next().charAt(0);

            if(n == '1') firstOption();
            if(n == '2') secondOption(sc);
            if(n == '0') start = false;
        }

    }

    private static void firstOption(){
        System.out.println("Files are");
        File opFiles = new File("src/com/company/opFiles");

        File files[] = opFiles.listFiles();
        String fileNames[] = new String[files.length];
        for(int i=0; i<files.length; i++){
            fileNames[i] = files[i].getName();
        }
        Arrays.sort(fileNames);

        for(int i=0; i<files.length; i++){
            System.out.println(fileNames[i]);
        }
    }

    private static void secondOption(Scanner sc){
        boolean cont = true;
        while(cont){
            System.out.println("To add new file press 1, to delete a file press 2, to search a file press 3" +
                    "to get back to main menu press 0");
            char c = sc.next().charAt(0);
            if(c == '1');
        }
    }


}
