
package Sorting;
import java.util.Scanner;


public class Sorting {

    
    //selection sort...  complexity == O(n2)
    static void selectionSort(int[] arr){
    
        for(int i=0; i<arr.length-1; i++){
            
          for(int j=i+1; j<arr.length; j++){
             
              if(arr[j]<arr[i]){
                 int temp = arr[j];
                 arr[j]=arr[i];
                 arr[i]=temp;
              }
          }
        }
    
    }
   
    //Bubbl sort.. complexity == O(n2)
    static void bubbleSort(int[] arr){
      
        for(int i=0; i<arr.length-1; i++){
            boolean flag=false;
          for(int j=0;j<arr.length-1-i;j++){
             if(arr[j+1]<arr[j]){
               int temp = arr[j+1];
               arr[j+1]=arr[j];
               arr[j]=temp;
               flag=true;
             }
          }
          
          if(flag==false)
              return;
        }
    
    }
    
    
    //Insertion sort.. complexity == O(n2)
    static void insertionSort(int[] arr){
    
        for(int i=1; i<arr.length; i++){
        
            int index =  i;
            int val = arr[i];
            
            while(index>0&&arr[index-1]>val){
            
                arr[index] =  arr[index-1];
                index--;
            }
            
            arr[index]=val;
        
        }
    
    }
    
    
    //complexity==worst_case =o(n2), nlogn = avgCase
   // method to find the partition position
  static int partition(int array[], int low, int high) {
    
    // choose the rightmost element as pivot
    int pivot = array[high];
    
    // pointer for greater element
    int i = (low - 1);

    // traverse through all elements
    // compare each element with pivot
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {

        // if element smaller than pivot is found
        // swap it with the greater element pointed by i
        i++;

        // swapping element at i with element at j
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }

    }

    // swapt the pivot element with the greater element specified by i
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    // return the position from where partition is done
    return (i + 1);
  }

  static void quickSort(int array[], int low, int high) {
    if (low < high) {

      // find pivot element such that
      // elements smaller than pivot are on the left
      // elements greater than pivot are on the right
      int pi = partition(array, low, high);
      
      // recursive call on the left of pivot
      quickSort(array, low, pi - 1);

      // recursive call on the right of pivot
      quickSort(array, pi + 1, high);
    }
  
  }
  
  
 // Divide the array into two sub arrays, sort them and merge them
 static void mergeSort(int array[], int left, int right) {
    if (left < right) {

      // m is the point where the array is divided into two sub arrays
      int mid = (left + right) / 2;

      // recursive call to each sub arrays
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);

      // Merge the sorted sub arrays
      merge(array, left, mid, right);
    }
  }
  
 static  void merge(int array[], int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    // fill the left and right array
    for (int i = 0; i < n1; i++)
      L[i] = array[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = array[q + 1 + j];

    // Maintain current index of sub-arrays and main array
    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    // Until we reach either end of either L or M, pick larger among
    // elements L and M and place them in the correct position at A[p..r]
    // for sorting in descending
    // use if(L[i] >= <[j])
    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = M[j];
        j++;
      }
      k++;
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      array[k] = M[j];
      j++;
      k++;
    }
  }

 static void buildheap(int[] arr, int size){
 
     for(int i=size/2; i>=0; i--){
         heapify(arr,i,size);
     }
     
 
 }
 
 
static void heapify(int[] arr, int index , int size){
   
     int left  = 2*index +1;
     
     int right = left + 1;
     
     int max  = index;
     
     
     if(left<=size&&arr[left]>arr[max])
         max = left;
     
     if(right<=size&&arr[right]>arr[max])
         max = right;
     
     if(max!=index){
       
         int temp =  arr[max];
         arr[max]=arr[index];
         arr[index]=temp;
         
         heapify(arr,max,size);
     
     }
 
 
 }
    

static void heapSort(int[] arr, int size){
    
    buildheap(arr,size);
    
    while(size>0){
    
        int temp = arr[size];
        arr[size]=arr[0];
        arr[0]=temp;
        size--;
        
        heapify(arr,0,size);
     
    }
    
}
    
    
    public static void main(String[] args) {
     
         Scanner  sc  = new Scanner(System.in);
         int[] arr  = new int[8];
         System.out.println("Enter the values");
         for(int i=0; i<arr.length; i++){
             arr[i]=sc.nextInt();
         }
         
         heapSort(arr,arr.length-1);
         
         for(int i=0; i<arr.length; i++){
          System.out.print(arr[i]+" ");
         }

    }
    
}
