import java.util.ArrayList;
import java.util.Arrays;
/**
 * Represents the constants class for correct owl data.
 */
public class CorrectOwlData {
    public final static BirdType Owl = BirdType.OWL;
    public final static int NumberOfWings = 2;
    public final static boolean IsExtinct = false;
    public final static ArrayList<FoodType> FoodPreferences = new ArrayList<>(Arrays.asList(FoodType.LEAVES, FoodType.INSECTS));

    public final static BirdClassification Classification = BirdClassification.OWL;

    public final static Beak Beak = new Beak(BeakSize.SHORT,BeakType.HOOKED, false, false);

    public final static String FacialDisk = "facial disks frame the eyes and bill";
}
