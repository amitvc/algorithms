import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    private static String RANGE_SEPARATOR = ":";
    
    /**
     * Utility function accepts list of numbers and collapses the input stream of numbers in ranges
     * The performance of the function is O(nlogn)+n which is effectively O(nlogn) if we are using either
     * merge or quick sort for the element sorting.
     * @param input
     * @return collapsed ranges of the input stream
     * @throws Exception 
     */
    public static String rangeFinder(String input) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        if(!input.isEmpty() && input.contains(",")) {
            List<Integer> sorted_list = Arrays.stream(input.split(","))
                                    .map(p -> Integer.parseInt(p))
                                    .distinct().
                                    sorted().
                                    collect(Collectors.toList());
            int previous = sorted_list.get(0);
            int range = 1;
            sb.append("" + previous);
            for(int i=1; i < sorted_list.size(); i++) {
                int current = sorted_list.get(i);
                if(Math.abs(previous-current) == 1) {
                    // we are in range;
                    range++;
                } else {
                    if(range > 1) {
                        sb.append(RANGE_SEPARATOR + previous + ",");    
                    } else {
                        sb.append(",");
                    }
                    range = 1;
                    sb.append(""+current);
                }
                previous = current;
            }
            // For the last element in the list.
            if(range > 1) {
                sb.append(RANGE_SEPARATOR + previous);    
            }
        } else if(!input.isEmpty()){
            sb.append(input);
        } else {
            throw new Exception("Illegal input");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(rangeFinder("0,16,1,2,3,9,11,12,13,14,15,-1,-1,21,-4,-5"));
        System.out.println(rangeFinder("0,16,17,24,25"));
        System.out.println(rangeFinder("0,3,5"));
        System.out.println(rangeFinder("5"));
       // System.out.println(rangeFinder(""));
    }

}
