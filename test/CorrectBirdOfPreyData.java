import java.util.ArrayList;
import java.util.Arrays;
/**
 * Represents the constants class for correct bird of prey data.
 */
public class CorrectBirdOfPreyData {
    public final static BirdType Eagle = BirdType.EAGLE;
    public final static BirdType Hawk = BirdType.HAWK;
    public final static int NumberOfWings = 2;
    public final static boolean IsExtinct = false;

    public final static ArrayList<FoodType> FoodPreferences =
            new ArrayList<>(Arrays.asList(FoodType.OTHER_BIRDS, FoodType.FISH, FoodType.SMALL_MAMMALS));

    public final static BirdClassification Classification = BirdClassification.BIRD_OF_PREY;

    public final static Beak Beak =  new Beak(BeakSize.SHORT,  BeakType.HOOKED, true, true);
}
