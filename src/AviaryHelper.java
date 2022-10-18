import java.util.ArrayList;
import java.util.Comparator;

/**
 * Helper class for aviary. Provides functionality for sorting birds and in each aviary.
 */
public class AviaryHelper {
    /**
     * Sorts birds in aviaries alphabetically by comparing bird types.
     * Acts as a pseudo merge sort. Sorts all aviaries of conservatory and then
     * merges first and second aviaries into first aviary. Then first and third and so on.
     * @param self takes conservatory as an argument
     * @return sorted list of BirdWithAviaryId objects
     */
    public static ArrayList<BirdWithAviaryId> getSortedBirds(Conservatory self){
        var result = new ArrayList<BirdWithAviaryId>();
        for (var aviary: self.getAviaries()){
            aviary.getCurrentBirds().sort(Comparator.comparing(o -> o.getBirdType().toString().toLowerCase()));

            var tmp = new ArrayList<BirdWithAviaryId>();
            for(var bird: aviary.getCurrentBirds()){
                tmp.add(new BirdWithAviaryId(bird, aviary.getId()));
            }
            result = merge(result, tmp);
        }
        return  result;
    }

    /**
     * Merges two sorted lists of BirdWithAviaryId objects. Employs merge() functionality from merge sort.
     * @return sorted list of BirdWithAviaryId objects
     */
    private static ArrayList<BirdWithAviaryId> merge(ArrayList<BirdWithAviaryId> first, ArrayList<BirdWithAviaryId> second){
        var firstPtr = 0;
        var secondPtr = 0;
        var firstLen = first.size();
        var secondLen = second.size();
        var result = new ArrayList<BirdWithAviaryId>(firstLen+secondLen);

        while(firstPtr < firstLen && secondPtr < secondLen){
            var firstBirdType = first.get(firstPtr).getBird().getBirdType().toString().toLowerCase();
            var secondBirdType = second.get(secondPtr).getBird().getBirdType().toString().toLowerCase();
            if(firstBirdType.compareTo(secondBirdType) < 0){
                result.add(first.get(firstPtr++));
            }
            else {
                result.add(second.get(secondPtr++));
            }
        }

        while(firstPtr < firstLen){
            result.add(first.get(firstPtr++));
        }

        while(secondPtr < secondLen){
            result.add(second.get(secondPtr++));
        }

       return result;

    }
}
