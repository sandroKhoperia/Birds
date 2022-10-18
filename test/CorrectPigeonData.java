import java.util.ArrayList;
import java.util.Arrays;
/**
 * Represents the constants class for correct pigeon data.
 */
public class CorrectPigeonData {
    public final static BirdType Pigeon = BirdType.PIGEON;
    public final static BirdType Dove = BirdType.DOVE;
    public final static String FeedsMilk = "Pigeons(doves) are known for feeding their young with 'bird milk' like milk of mammals.";
    public final static int NumberOfWings = 2;
    public final static boolean IsExtinct = false;
    public final static ArrayList<FoodType> FoodPreferences = new ArrayList<>(Arrays.asList(FoodType.SEEDS, FoodType.LARVAE, FoodType.INSECTS));

    public final static BirdClassification Classification = BirdClassification.PIGEON;

    public final static Beak Beak = new Beak(BeakSize.SHORT, BeakType.CURVED, false, false);
}
