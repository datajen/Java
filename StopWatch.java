/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch;

import java.util.Random; //for Random Class
/**
 *
 * @author jennifermiller
 */
public class StopWatch {
   
    //No Argument Constructor to initialize startClock
    StopWatch(){
    long startClock = System.currentTimeMillis();
    }; 
    
    private static long startClock;
    private static long endClock;
    
    
/*********************************************************/
/*                  test program:                        */
/*         fill an array with 1000 random numbers        */
/*        sort 1000 numbers using bubble sort            */
/*********************************************************/

public static void main(String[] args) {
    
Random rand = new Random();   // Random number generator     
int array[] = new int[10000];
int i = 0;

// Fill array with Random Numbers
for (i = 0; i < array.length; i++)
    array[i] = rand.nextInt((50-1)+1) + 1;

// Call startTimer before calling bubblesort
start_Timer();

//Bubble Sort
bubbleSort(array);

// Call endTimer after calling bubblesort.
end_Timer();

getElapsed();

long x = getElapsed();

System.out.println("The time to bubble sort is ");
System.out.println(x);
System.out.println("miliseconds.");

// Print array with Bubble Sort
/*for (i = 0; i < array.length; i++)
    System.out.println(array[i]);*/
            
    } // End Main
    

  
    static long getstartClock(){
    return startClock;
    };
    
    static long getendClock(){
    return endClock;
    };
    
    static long start_Timer(){
    startClock = System.currentTimeMillis();
    return startClock;
    };
    
    static long end_Timer(){
    endClock = System.currentTimeMillis();
    return endClock;
    };
    
    static long getElapsed(){
    long timeElapsed = endClock - startClock;
    return timeElapsed;
    };
    
        static void bubbleSort(int[] A){
 
        int temp;
        int i;
        int j;
        
        for (i = 0; i < A.length - 1; i++){
            for (j = 1; j < A.length; j++){
                if(A[j-1] > A[j]){
                    temp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = temp; 
                };
            }        
        }
    };
    
}
