import java.util.ArrayList;
import java.util.Arrays;
/**
 * Represents the constants class for correct waterfowl data.
 */
public class CorrectWaterFowlData {
    public final static BirdType Goose = BirdType.GOOSE;
    public final static int NumberOfWings = 2;
    public final static boolean IsExtinct = false;
    public final static ArrayList<FoodType> FoodPreferences = new ArrayList<>(Arrays.asList(FoodType.SEEDS, FoodType.LEAVES, FoodType.INSECTS));
    public final static ArrayList<LivingHabitat> LivingHabitats =
            new ArrayList<>(Arrays.asList(LivingHabitat.SALTWATER_SHORELANDS, LivingHabitat.FRESHWATER_SHORELANDS));

    public final static BirdClassification Classification = BirdClassification.WATERFOWL;

    public final static Beak Beak = new Beak(BeakSize.LONG, BeakType.CURVED, false,false);
}
