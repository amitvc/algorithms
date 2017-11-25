package com.algorithms.usaco;


/*
ID: achavan1
LANG: JAVA
TASK: gift1
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class gift1 {

	public static class PersonContribution {
		public String name;
		public int amountToDistribute;
		public int finalAmount;
		public List<String> donationList = new ArrayList<>();
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int numberOfPeople = Integer.parseInt(st.nextToken());
		
		Map<String, PersonContribution> inputDataMap = new HashMap<>();
		List<String> friendList = new ArrayList<>();
			
		for(int i=0; i < numberOfPeople; i++) {
			PersonContribution pc = new PersonContribution();
			pc.name = f.readLine();
			friendList.add(pc.name);
			inputDataMap.put(pc.name, pc);
		}
		
		for(int i=0; i < numberOfPeople; i++) {
			String name = f.readLine();
			PersonContribution pc = inputDataMap.get(name);
			st = new StringTokenizer(f.readLine());
			int initialAmount = Integer.parseInt(st.nextToken(" "));
			int distributionAmongst = Integer.parseInt(st.nextToken());
			if(initialAmount > 0) {
				initialAmount = -((initialAmount/distributionAmongst)*distributionAmongst);
			}
			pc.amountToDistribute = initialAmount;
			pc.finalAmount = initialAmount;
			for(int j=0; j < distributionAmongst; j++) {
				pc.donationList.add(f.readLine());
			}
		}
		
		for(String name : friendList) {
			PersonContribution pc = inputDataMap.get(name);
			int perPersonDonation = pc.amountToDistribute != 0  ? Math.abs(pc.amountToDistribute /pc.donationList.size()) : 0;
			for(String fName : pc.donationList) {
				PersonContribution friend = inputDataMap.get(fName);
				friend.finalAmount += perPersonDonation;
			}
		}
		
		for(String name : friendList) {
			PersonContribution pc = inputDataMap.get(name);
			//System.out.println(pc.name +" " + pc.finalAmount);
			out.write(pc.name + " " + pc.finalAmount+"\n");
		}
		
		out.close();				
		f.close();
	}

}
