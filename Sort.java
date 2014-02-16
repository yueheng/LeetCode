import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        int[] num = {1, 3, 5, 2, 0};
        QuickSort(num);
        for(int i = 0; i < num.length; i++)System.out.println(num[i]);
     }
     
     
     //insertion sort
     public static void InsertionSort(int[] num) {
         for(int i = 1; i < num.length; i++) {
             int temp = num[i];
             int j = i;
             for(; j > 0 && num[j-1] > temp; j--) num[j] = num[j-1];
             num[j] = temp;
         }
     }
     
     
     //selection sort
     public static void SelectionSort(int[] num) {
         for(int i = 0; i < num.length - 1; i++) {
             int temp = num[i];
             int min = i;
             for(int j = i + 1; j < num.length; j++) {
                 if(num[j] < num[min]) min = j;
             }
             num[i] = num[min];
             num[min] = temp;
         }
     }
     
     //merge sort
     public static void MergeSort(int[] num) {
         helper(num, 0, num.length - 1);
     }
     
     public static void helper(int[] num, int low, int high) {
         int mid = (low + high) / 2;
         if(low < high) {             
             helper(num, low, mid);
             helper(num, mid+1, high);
         }
         merge(num, low, high, mid);
     }
     
     public static void merge(int[] num, int low, int high, int mid) {
         int i = 0, j = 0, k = low;
         int[] lowarr = new int[mid - low + 1];
         int[] higharr = new int[high - mid];
         for(int p = 0; p < lowarr.length; p++) lowarr[p] = num[low + p];
         for(int p = 0; p < higharr.length; p++) higharr[p] = num[mid + 1 + p];
         while(i < lowarr.length && j < higharr.length) {
             int temp1 = lowarr[i];
             int temp2 = higharr[j];
             if(temp1 <= temp2) {
                 num[k] = temp1;
                 i++;
             }
             else {
                 num[k] = temp2;
                 j++;
             }
             k++;
         }
         while(i < lowarr.length) {
             num[k] = lowarr[i];
             i++;
             k++;
         }
         while(j < higharr.length) {
             num[k] = higharr[j];
             j++;
             k++;
         }
     }
     
     //heap sort
     public static void HeapSort(int[] num) {
         PriorityQueue<Integer> q = new PriorityQueue<Integer>();
         for(int i = 0; i < num.length; i++) q.add(num[i]);
         for(int i = 0; i < num.length; i++) num[i] = q.remove();
     }
     
     //quick sort
     public static void QuickSort(int[] num) {
         quickhelper(num, 0, num.length - 1);
     }
     
     public static void quickhelper(int[] num, int low, int high) {
         int i = low, j = high;
         int pivot = num[(low + high) / 2];
         while(i <= j) {
             while(num[i] < pivot) i++;
             while(num[j] > pivot) j--;
             if(i <= j) {
                 int temp = num[i];
                 num[i] = num[j];
                 num[j] = temp;
                 i++;
                 j--;
             }
         }
         if(low < j) quickhelper(num, low, j);
         if(i < high) quickhelper(num, i, high);
     }
     
     
     //bucket sort
     public static void BucketSort(int[] num) {
         int max = num[0];
         for(int i = 1; i < num.length; i++) if(num[i] > max) max = num[i];
         int[] bucket = new int[max + 1];
         for(int i = 0; i < num.length; i++) bucket[num[i]]++;
         int index = 0;
         for(int i = 0; i <= max; i++) {
             while(bucket[i] > 0) {
                 num[index++] = i;
                 bucket[i]--;
            }
         }
         
     }
}
