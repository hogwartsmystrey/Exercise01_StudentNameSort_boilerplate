package com.stackroute;

//Complete the code below as given in the problem.md file


import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;



import static java.util.Arrays.*;

public class Exercise01StudentNameSort {
	public static String[] sortStudents(String[] studentNames, int[] percentage) {
		//String temp[]=new String[3];
		//int[] temp1=new int[3];
		int i, j;
		int per = 0;
		String name;
		// ascending order sorting begins
		int limit;
		limit = studentNames.length;

		for (i = 0; i < limit; i++) {
			for (j = i + 1; j < limit; j++) {
				if (percentage[i] > percentage[j]) {
					// sorting marks
					per = percentage[i];
					percentage[i] = percentage[j];
					percentage[j] = per;
					//sorting names
					name = studentNames[i];
					studentNames[i] = studentNames[j];
					studentNames[j] = name;

				}
			}

		}
		//printing sorted percentage and name in ascending order
		//for(i=0;i<3;i++)
		//{
		//System.out.println(studentNames[i]+":"+percentage[i]);
		//}


		return (studentNames);
	}

	//Do not print anything other than what's expected/asked in problem

	public static void main(String args[]) {
		//Use Scanner to get input from console
		Scanner sc = new Scanner(System.in);

		//Exercise01StudentNameSort call=new Exercise01StudentNameSort();
		int n, i;
		//n=sc.nextInt();
		String input = sc.next();
		String[] splitresult = input.split(";");
		List<String> namelist = new ArrayList<String>();
		List<Integer> perlist = new ArrayList<Integer>();

		for (i = 0; i < splitresult.length; i++) {
			namelist.add(splitresult[i].split(":")[0]);
			perlist.add(Integer.parseInt(splitresult[i].split(":")[1]));
		}
		int x = splitresult.length;
		//String[] studentNames =toArray(namelist);
		String[] studentNames = namelist.toArray(new String[namelist.size()]);

		//int[] percentage = perlist.toArray(new int[perlist.size()]);

		int[] percentage = perlist.stream()
				.mapToInt(Integer::intValue)
				.toArray();
		//int[] percentage=toArray(perlist);
		Exercise01StudentNameSort.sortStudents(studentNames, percentage);
		System.out.print("[");
		int y = 0;
		for (i = 0; i < studentNames.length; i++) {
			if(i!=0) {

				System.out.print(",");
			}

			System.out.print(studentNames[i]);

		}
		System.out.print("]");
	}
}
