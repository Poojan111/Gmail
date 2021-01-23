package FIRST.First;

import java.util.Scanner;

public class CompressedString {

	public static void main(String[] args) {
		int count=1,k=0;
		System.out.print("Input: ");
		Scanner scan=new Scanner(System.in);
		String input=scan.next();
		StringBuffer output=new StringBuffer();
		System.out.print("Output: ");
		for (int i = 0; i < input.length(); i++) { 
            int count1 = 1; 
            while (i + 1 < input.length() 
                   && input.charAt(i) 
                          == input.charAt(i + 1)) { 
                i++; 
                count1++; 
            } 
            	output=output.append(input.charAt(i)).append(count1);
          //  System.out.print(input.charAt(i)  + "" + count1 + ""); 
            count=1;
		}
			if(output.length()>input.length()) {
				System.out.println(input);
			}
			else
			{
				System.out.println(output);
			}
		}

}
