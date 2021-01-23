package FIRST.First;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DuplicateValues {

	public static void main(String[] args) {
		System.out.print("Input: ");
		Scanner scan=new Scanner(System.in);
		String input=scan.next();
		char in[]=input.toCharArray();
		Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		int i=0;
		while(i!=in.length){
			if(map.containsKey(in[i])==false) {
				map.put(in[i], i);
			}
			i++;
		}
		Set<Map.Entry<Character,Integer>> m=map.entrySet();
		String res="";
		for(Map.Entry<Character, Integer> data : m) {
			res=res+data.getKey();
		}
		System.out.println("Output: "+res);
	}
}
