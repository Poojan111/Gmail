package FIRST.First;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SmallestDifference {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Input size of 1st Array ");
		int i=scan.nextInt();
		System.out.print("Input size of 2st Array ");
		int j=scan.nextInt();
		int input1[]=new int[i];
		int input2[]=new int[j];
		for(int k=0;k<i;k++) {
			input1[k]=scan.nextInt();
			
		}
		for(int k=0;k<j;k++) {
			input2[k]=scan.nextInt();
		}
		int refer=0,diff=0,x=0;
		Arrays.sort(input1);
		Arrays.sort(input2);
		if(input2[j-1]>input1[i-1]) {
			diff=input2[j-1];
		}
		else {
			diff=input1[i-1];
		}
	   for(x=0;x<i;x++) {
			for(int y=0;y<j;y++) {
				refer=input1[x]-input2[y];
				refer=Math.abs(refer);
				if(refer<diff ) {
					diff=refer;
				}
			}
		}
		System.out.println("Output: "+diff);
	}
}
