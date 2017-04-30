package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GetRankedCourses {
	
	public class Course {
		String course;
		int frequency;
	}
	
	public List<String> getDirectFriendsForUser(String user) {
		return null;
	}
	
	private List<String> getSocialNetworkFriendsList(String user, int level) {
		Set<String> socialNetworkUserList = new HashSet<>();
		if (level == -1) {
			socialNetworkUserList.addAll(getDirectFriendsForUser(user, 0, Integer.MAX_VALUE));
		} else {
			socialNetworkUserList.addAll(getDirectFriendsForUser(user, 0, level));
		}

		List<String> list = new ArrayList<String>(socialNetworkUserList);
		return list;
	}

	/**
	 * DFS search in social graph limited by the maxLevel.
	 * @param user
	 * @param level
	 * @param maxLevel
	 * @return
	 */
	private List<String> getDirectFriendsForUser(String user, int level, int maxLevel) {
		Set<String> userList = new HashSet<>();
		if (level < maxLevel) {
			List<String> directFriends = getDirectFriendsForUser(user);
			for (String friendId : directFriends) {
				userList.addAll(getDirectFriendsForUser(friendId, level + 1, maxLevel));
			}
		}
		return new ArrayList<String>(userList);
	}

	public List<String> getAttendedCoursesForUser(String user) {
		return null;
	}

	public List<String> getRankedCourses(String user) {
		Map<String, String> coursesAlreadyAttended = new HashMap<>();
		List<String> coursesAttended = getAttendedCoursesForUser(user);
		for (String course : coursesAttended) {
			coursesAlreadyAttended.put(course, course);
		}

		List<String> listOfFriends = getSocialNetworkFriendsList(user, 3);
		List<String> coursesToRecommend = new ArrayList<>();
		for (String friendId : listOfFriends) {
			coursesToRecommend.addAll(coursesNotAttended(getAttendedCoursesForUser(friendId), coursesAlreadyAttended));
		}
		
		sortCoursesByFrequency(sortCoursesToRecommend(coursesToRecommend));
		return coursesAttended;
	}

	
	/**
	 * Returns the list of courses based on how many friends in social network took the course.
	 * @param coursesByFrequency
	 * @return
	 */
	private List<String> sortCoursesByFrequency(Map<String, Integer> coursesByFrequency) {
		Map<Integer, String> sortedMapByFrequency = new TreeMap<>();
		for(Map.Entry<String, Integer> entry : coursesByFrequency.entrySet()) {
			sortedMapByFrequency.put(entry.getValue(), entry.getKey());
		}
		
		// Now we have the sorted key map.
		List<String> sortedCourses = new ArrayList<>();
		for(Map.Entry<Integer, String> entry : sortedMapByFrequency.entrySet()) {
			sortedCourses.add(entry.getValue());
		}
		return sortedCourses;
	}
	
	
	private Map<String, Integer> sortCoursesToRecommend(List<String> coursesToRecommend) {
		Map< String, Integer> courseRecommendationRankings = new HashMap<>();
		for(String s : coursesToRecommend) {
			if(courseRecommendationRankings.containsKey(s)){
				Integer rank = courseRecommendationRankings.get(s);
				Integer newRank = new Integer(rank.intValue()+1);
				courseRecommendationRankings.put(s, newRank);
			} else {
				courseRecommendationRankings.put(s, new Integer(1));
			}
		}
		
		return courseRecommendationRankings;
	}
	

	/**
	 * This function uses the courseLookup hashmap to determine if a particular course has been already taken by the current user.
	 * This function will only return courses not taken by the user yet.
	 * @param coursesAttended
	 * @param coursesLookup
	 * @return
	 */
	private List<String> coursesNotAttended(List<String> coursesAttended, Map<String, String> coursesLookup) {
		List<String> coursesNotAttended = new ArrayList<>();
		for(String course : coursesAttended) {
			if(!coursesLookup.containsKey(course)) {
				coursesNotAttended.add(course);
			}
		}
		return coursesNotAttended;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
