
package Hashing;
import java.util.Arrays;
import java.util.Scanner;


public class Hashing {

 
//this programe using array for the hashtable but we can also make this programme using Node and linked list which is called separate chaining    
    
 // funtion to insert item in hashTable using linear probing   
static void insert(int item, int[] ht){
    int key = item%ht.length;
    
    int index = key;
    
    while(ht[index]!=-1){
       
        index =  (index+1)%ht.length;
        
        if(index==key){
          System.out.println("Not inserted");
          return;
        }
       
    }
    
    
    System.out.println("Successfully inserted");
    ht[index]=item;
 
 }


//funtion to delete an value from hashTable
static void delete(int item, int[] arr){
    
    int key = item%arr.length;
    
    int index  = key;
    
    while(arr[index]!=item){
      
        index =  (index+1)%arr.length;
        
        if(index == key){
          System.out.println("Element is Not found Sorry");
          return;
        }
    
    }
    
    System.out.println("Succsessfully deleted");
    arr[index]=-1;
    
}

static void search(int item, int[] arr){
    
    int key = item%arr.length;
    
    int index  = key;
    
    while(arr[index]!=item){
      
        index =  (index+1)%arr.length;
        
        if(index == key){
          System.out.println("Not found");
          return;
        }
    
    }
   
    System.out.println("Found");
    
}






  
 public static void main(String[] args) {

Scanner sc  = new Scanner(System.in);

int[] arr = new int[7];

Arrays.fill(arr,-1);


     for(int i=0; i<arr.length+1; i++){
       //  System.out.println("Enter value");
         insert(i*3,arr);
     }
     
     for(int i=0; i<arr.length; i++){
       System.out.print(" "+arr[i]);
     }
     
//     System.out.println("Enter value to delete");
//     
//     int x  = sc.nextInt();
//     
//     delete(x,arr);
//     
//       for(int i=0; i<arr.length; i++){
//       System.out.print(" "+arr[i]);
//     }

search(5,arr);
     

    }
    
}
