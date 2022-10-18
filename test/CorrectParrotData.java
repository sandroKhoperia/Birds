import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/**
 * Represents the constants class for correct parrot data.
 */
public class CorrectParrotData {
    public final static BirdType GrayParrot = BirdType.GRAYPARROT;
    public final static int NumberOfWings = 2;
    public final static boolean IsExtinct = false;
    public final static ArrayList<FoodType> FoodPreferences = new ArrayList<>(Arrays.asList(FoodType.SEEDS, FoodType.NUTS));
    public final static String FavoriteWord = "birdie";
    public final static HashSet<String> Vocab = TestingHelper.FillParrotVocabulary();

    public final static BirdClassification Classification = BirdClassification.PARROT;

    public final static Beak Beak = new Beak(BeakSize.SHORT,BeakType.CURVED,false,false);
}
