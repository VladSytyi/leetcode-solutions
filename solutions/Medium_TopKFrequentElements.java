
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Medium_TopKFrequentElements {

    // Topics: HashMap, Sorting , Comparators

    public static void main(String[] args) {
        // Top K frequent elements


        topKFrequent( new int[] {1,1,1,2,2,3} , 2  );
    }
    /* Solution
    * 1. Create a hashMap
    * 2. Iterate over array and calculate the number of occurrence
    * 3. Sort Map by value ( in reverse order, because default is ascending )
    * 4. Get key and map it to array
    * */

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequencyMap.computeIfPresent(nums[i], (key, value) -> ++value);
            frequencyMap.putIfAbsent(nums[i], 1);
        }

        // sort Map by Value

        return frequencyMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}