import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/*
time complexity O(n)
space complexity, not big on average, worst case O(n)
*/
public class ArrayHopper{    
	public static void main(String[] args) {
		ArrayList<Integer> num = doRead(args);  //read from commond line
		ArrayList<Integer> res = minHop(num);   //get result
		doPrint(res);                           //print result
	}

	
	//do calculation
	public static ArrayList<Integer> minHop(ArrayList<Integer> num) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(num == null || num.size() == 0) return res;
		int i = 0;
		int len = num.size();
		int curr = 0;
		int next = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(; i < len; i++) {
			if(curr < i) {   //if curr < i, need to jump
				if(next < i) break;                 
				curr = next;  //can jump to next at most
				res.add(map.get(next));  //add previous location to result
				map.clear();  //clear map, so the size of map won't get too large
			}
			if(i + num.get(i) > next) {  //if jump further from i than next, update next
				next = i + num.get(i);
				map.put(next, i);        //put next and the location that can jump to next into map
			}
		}
		if(i < len) return new ArrayList<Integer>();
		res.add(map.get(next));
		return res;
	}    

	
	//read from commond line
	public static ArrayList<Integer> doRead(String[] args) {
		BufferedReader br = null;
		ArrayList<Integer> num = new ArrayList<Integer>();
		try {
			FileReader fr = new FileReader(args[0]); //read
			br = new BufferedReader(fr);			
			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();          //delete whitespaces
				int temp = Integer.parseInt(line);  //parse int
				num.add(temp);
			}	
			return num;
		} catch (FileNotFoundException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try{
				if (br != null) br.close();		//finally close bufferedreader		
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return new ArrayList<Integer>();
	}
	
	
	//print result
	public static void doPrint(ArrayList<Integer> res) {
		if(res.size() == 0) {
			System.out.println("failure");
		}
		else {
			for(int i = 0; i < res.size(); i++) {
				if(res.get(i) != null) System.out.print(res.get(i) + ", ");
			}
			System.out.println("out");
		}
	}

}
