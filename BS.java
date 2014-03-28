/*
Problem: Find the first index of an element in a sorted array
*/
public class HelloWorld{
     public static void main(String []args){
        System.out.println("Hello World");
        int[] num = {1, 3, 5, 8, 10};
        int tar = 5;
        int low = 0;
        int high = num.length - 1;
        int first = high;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(num[mid] < tar) low = mid + 1;
            else if(num[mid] >= tar) high = mid - 1;            
        }
        System.out.println(low);
     }
}

/*
Find how many times an element appears in a sorted array
*/
public class HelloWorld{
     public static void main(String []args){
        System.out.println("Hello World");
        int[] num = {1, 3, 5, 5, 5, 8, 10};
        int tar = 5;
        int low = 0;
        int high = num.length - 1;
       
        while(low <= high) {
            int mid = (low + high) / 2;
            if(num[mid] < tar) low = mid + 1;
            else if(num[mid] >= tar) high = mid - 1;
            
        }
		
        int first = low;
        high = num.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(num[mid] > tar) high = mid - 1;
            else low = mid + 1;
        }
        System.out.println(high - first + 1);
     }
}
