import java.util.ArrayList;
import java.util.Arrays;
/**
 * Represents the constants class for correct shore bird data.
 */
public class CorrectShoreBirdData {
    public final static BirdType GreatAuk = BirdType.GREATAUK;
    public final static int NumberOfWings = 2;
    public final static boolean IsExtinct = false;
    public final static ArrayList<FoodType> FoodPreferences = new ArrayList<>(Arrays.asList(FoodType.FISH, FoodType.INSECTS));
    public final static ArrayList<LivingHabitat> LivingHabitats =  new ArrayList<>(Arrays.asList(LivingHabitat.OCEAN,
            LivingHabitat.WETLAND,LivingHabitat.FRESHWATER_SHORELANDS,LivingHabitat.SALTWATER_SHORELANDS));

    public final static BirdClassification Classification = BirdClassification.SHOREBIRD;

    public final static Beak Beak = new Beak(BeakSize.LONG, BeakType.CURVED, false,false);
}
