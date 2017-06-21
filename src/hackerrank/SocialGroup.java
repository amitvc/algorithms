package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialGroup {
	
	public static class ValidGroup {
		public boolean groupCompleted = false;
		public StringBuilder sb = new StringBuilder();
	}
	
	
	public static void socialGraphs(int counts[]) {
		Map<Integer, Integer> groupCounters = new HashMap<>();
		Map<Integer, ValidGroup> validGroupLookup = new HashMap<>();
		// Here groupId is identification of the group and also how many friends there are in the group. 
		// Serves a dual purpose
		int index = 0;
		for(int groupId : counts) {
			if(!groupCounters.containsKey(groupId)) {
				groupCounters.put(groupId, 0);
				ValidGroup validGroup = new ValidGroup();
				validGroupLookup.put(groupId, validGroup);
			} 
			
			int groupCount = groupCounters.get(groupId);
			groupCount++;
			if(groupCount % groupId > 0) {
				ValidGroup validGroup = validGroupLookup.get(groupId);
				validGroup.sb.append(index +" ");
			} else {
				ValidGroup validGroup = validGroupLookup.get(groupId);
				validGroup.sb.append(index +" ");
				System.out.println(validGroup.sb.toString());
				validGroup.sb.setLength(0);
			}
			index++;
			groupCounters.put(groupId, groupCount);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2,1,1,2,1
		//int counts[] = {2,1,1,2,1};
		//int counts[] = {2,2,2,2};
		int counts[] = {1,1,1};
		socialGraphs(counts);
		
		
	}

}
