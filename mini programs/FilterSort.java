/*
Program that reads tokens from a file data.txt and prints the integer
tokens found in it to the screen in increasing order.

@author Harish Kandaswamy (3265)
@version 15 February 2019
*/

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class FilterSort {
        
        /*
        Allocates and returns an integer array twice the size of the one
        supplied as a parameter. The first half of the new array will
        be a copy of the supplied array and the second half of the new array will be zeros.
        */
        public static int[] doubleArrayAndCopy(int[] arr) {
                
                int[] temp = new int[arr.length*2];
                for (int i = 0; i < arr.length; i++) {
                        temp[i] = arr[i]; 
                }
                return temp;
        }                
                
                public static void main(String[] args) {
                
                int[] data = new int[8];
                Scanner file = null;
                try {
                        file = new Scanner(new File("data.txt"));
                }
                catch (FileNotFoundException e) {
                        file = null;
                }
                if (file != null) {
                
                        int i = 0;
                        while (file.hasNext()) {
                                if (file.hasNextInt()) {
                                        if (i >= data.length) {
                                                data = doubleArrayAndCopy(data);
                                        }
                                        data[i] = file.nextInt();
                                        i++;        
                                }
                                else {
                                        file.next();
                                }
                        }
                        Arrays.sort(data, 0, i);
                        if (i > 0) {
                                System.out.print(data[0]);
                        }
                        for (int j = 1; j < i; j++) {
                                System.out.println();
                                System.out.print(data[j]);
                        }
                }        
                else {
                        System.out.print("File not found.");
                }
        }
}