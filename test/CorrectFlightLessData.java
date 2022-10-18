import java.util.ArrayList;
import java.util.Arrays;
/**
 * Represents the constants class for correct flightless birds data.
 */
public class CorrectFlightLessData {
    public final static BirdType Kiwi = BirdType.KIWI;
    public final static BirdType Emu = BirdType.EMU;
    public final static int NumberOfWings = 0;
    public final static boolean IsExtinct = true;
    public final static boolean IsExtinctKiwi = false;
    public final static ArrayList<FoodType> FoodPreferences = new ArrayList<>(Arrays.asList(FoodType.LARVAE, FoodType.FRUITS));

    public final static BirdClassification Classification = BirdClassification.FLIGHTLESS;

    public final static Beak Beak = new Beak(BeakSize.LONG, BeakType.CURVED, false, false);
}
