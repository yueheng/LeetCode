/*
CHALLENGE DESCRIPTION:

Our marketing department has just negotiated a deal with several local merchants that will allow us to offer exclusive discounts on various products to our top customers every day. The catch is that we can only offer each product to one customer and we may only offer one product to each customer. 

Each day we will get the list of products that are eligible for these special discounts. We then have to decide which products to offer to which of our customers. Fortunately, our team of highly skilled statisticians has developed an amazing mathematical model for determining how likely a given customer is to buy an offered product by calculating what we call the "suitability score" (SS). The top-secret algorithm to calculate the SS between a customer and a product is this: 

1. If the number of letters in the product's name is even then the SS is the number of vowels (a, e, i, o, u, y) in the customer's name multiplied by 1.5. 
2. If the number of letters in the product's name is odd then the SS is the number of consonants in the customer's name. 
3. If the number of letters in the product's name shares any common factors (besides 1) with the number of letters in the customer's name then the SS is multiplied by 1.5. 

Your task is to implement a program that assigns each customer a product to be offered in a way that maximizes the combined total SS across all of the chosen offers. Note that there may be a different number of products and customers. You may include code from external libraries as long as you cite the source.

INPUT SAMPLE:

Your program should accept as its only argument a path to a file. Each line in this file is one test case. Each test case will be a comma delimited set of customer names followed by a semicolon and then a comma delimited set of product names. Assume the input file is ASCII encoded. For example (NOTE: The example below has 3 test cases): 

Jack Abraham,John Evans,Ted Dziuba;iPad 2 - 4-pack,Girl Scouts Thin Mints,Nerf Crossbow
Jeffery Lebowski,Walter Sobchak,Theodore Donald Kerabatsos,Peter Gibbons,Michael Bolton,Samir Nagheenanajar;Half & Half,Colt M1911A1,16lb bowling ball,Red Swingline Stapler,Printer paper,Vibe Magazine Subscriptions - 40 pack
Jareau Wade,Rob Eroh,Mahmoud Abdelkader,Wenyi Cai,Justin Van Winkle,Gabriel Sinkin,Aaron Adelson;Batman No. 1,Football - Official Size,Bass Amplifying Headphones,Elephant food - 1024 lbs,Three Wolf One Moon T-shirt,Dom Perignon 2000 Vintage
OUTPUT SAMPLE:

For each line of input, print out the maximum total score to two decimal places. For the example input above, the output should look like this:

21.00
83.50
71.25
*/

import java.io.*;
import java.util.*;

public class HelloWorld{
	private static HashSet<Character> vowels;
	public static void main(String []args){
		try {
			File file = new File(args[0]);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str;
			addVowels();
			while ((str = br.readLine()) != null) {
				double SS = getSS(str);
				System.out.format("%.2f%n", SS);  
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void addVowels() {
		vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('y');
	}
	//function to calculate total SS
	public static double getSS(String input){
		String[] strs = input.split(";");
		if(strs == null || strs.length <= 1) return 0;
		String customers = strs[0];
		String products = strs[1];
		String[] cust = getMembers(customers);
		String[] pro = getMembers(products);
		String[] cust = strs[0].split(",");
		String[] pro = strs[1].split(",");
		if(cust == null || pro == null) return 0;
		HashSet<String> assign = new HashSet<String>();
		double res = 0;
		if(cust.length <= pro.length) 	res = getMaxSS(cust, pro, 0, assign);
		else res = getMaxSSLessPro(cust, pro, 0, assign);
		return res;
	}
	
	
	//get customers and products
	public static String[] getMembers(String str) {
		if(str == null || str.length() == 0) return null;
		String[] strs = str.split(",");
		//for(int i = 0; i < strs.length; i++) strs[i] = strs[i].trim();
		return strs;		
	}
	
	
	//get total SS if there are more products than customers
	public static double getMaxSS(String[] cust, String[] pro, int custNum, HashSet<String> proAssign) {
		if(cust == null || pro == null) return 0;
		double max = 0;
		if(custNum >= cust.length) return max;
		for(int i = 0; i < pro.length; i++) {
			if(!proAssign.contains(pro[i])) {
				proAssign.add(pro[i]); 
				double temp = eval(cust[custNum], pro[i]) + getMaxSS(cust, pro, custNum + 1, proAssign);
				max = Math.max(max, temp);
				proAssign.remove(pro[i]); 
			}			
		}
		return max;
	}
	
	
	//get total SS if there are less products than customers
	public static double getMaxSSLessPro(String[] cust, String[] pro, int proNum, HashSet<String> custAssign) {
		if(cust == null || pro == null) return 0;
		double max = 0;
		if(proNum >= pro.length) return max;
		for(int i = 0; i < cust.length; i++) {
			if(!custAssign.contains(cust[i])) {
				custAssign.add(cust[i]); 
				double temp = eval(cust[i], pro[proNum]) + getMaxSSLessPro(cust, pro, proNum + 1, custAssign);
				max = Math.max(max, temp);
				custAssign.remove(cust[i]); 
			}			
		}
		return max;
	}
	
	
	//calculate the SS between a customer and a product
	public static double eval(String cust, String pro) {
		int custLen = numOfLetters(cust);
		int proLen = numOfLetters(pro);
		int vowNum = numOfVow(cust);
		double res = 0;
		if(proLen % 2 == 0) res =  vowNum * 1.5;		
		else res = custLen - vowNum;//numOfCons(cust);
		if(proLen % 2 == 0 && custLen % 2 == 0) res *= 1.5;
		else if(greatestFactor(custLen, proLen) >= 2) res *= 1.5;
		return res;
	}
	
	
	//number of letters in a string
	public static int numOfLetters(String name) {
		int res = 0;
		for(int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) res++;
		}
		return res;
	}
	
	
	//number of vowals in name
	public static int numOfVow(String name) {
		int res = 0;
		if(name == null) return res;
		int len = name.length();		
		for(int i = 0; i < len; i++) {
			char c = name.charAt(i);
			if((('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'))) {				
				if(inVowels(c)) res++;
			} 
		}
		return res;
	}
	
	
	//to check if a character is in vowels
	public static boolean inVowels(char c) {
		return vowels.contains(Character.toLowerCase(c));
	}
	
	
	//get the greatest factor of number1 and number2
	public static int greatestFactor(int num1, int num2) {
		if(num1 == 0 || num2 == 0) return 0;
		if(num1 == num2) return num1;
		if(num2 > num1) return greatestFactor(num2, num1);
		if(num1 % num2 == 0) return num2;
		return greatestFactor(num1 % num2, num2);
	}
}



