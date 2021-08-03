
package Searching;

import java.util.Scanner;

public class Searching {
    
    // linear-search have complexity o(n)
   static int linearSearch(int[] arr, int item){
       
        for(int i=0; i<arr.length; i++){
            if(arr[i]==item)
                return i;
        }
        return -1;
    }

   
   //Binary_search  complexity O(logn)
   static int binarySearch(int[] arr, int item){
     
       int first = 0;
       int last =  arr.length-1;
       
       while(first<=last){
         
             int mid = (first+last)/2;
             
             if(arr[mid]==item)
                 return mid;
             
         if(arr[mid]>item){
             last=mid-1;
           }
         else
           first=mid+1;
        
       }
       return -1;
   }
   
 static  int binarySearchRec(int[] arr, int lb, int ub, int item){
     
       if(lb>ub)
           return -1;
       else{
         
           int mid = (ub+lb)/2;
           if(arr[mid]==item)
               return mid;
           else if(arr[mid]<item)
              return binarySearchRec(arr,mid+1,ub,item);
           else
           return binarySearchRec(arr,lb,ub-1,item);
       }
   
   }
   
  public static void main(String[] args) {


  Scanner sc  = new Scanner(System.in);
  
     int[] arr  = new int[8];
     for(int i=0; i<arr.length; i++){
       arr[i]=i+1;
     }
     
     for(int i: arr){
      System.out.print(" "+i);
     }
     System.out.println();
     
     System.out.println("Enter item to be searched");
     
     int item = sc.nextInt();
       System.out.println("item is present at "+ binarySearchRec(arr,0,arr.length-1,item) );
    }
   
    
}
