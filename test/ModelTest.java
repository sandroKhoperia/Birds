import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import static org.junit.Assert.*;
/**
 * Represents the testing class for Bird objects.
 */
public class ModelTest {
    /**
     * Represents the gray parrot object
     */
    private Parrot _grayParrot;

    /**
     * Represents the gray kiwis object
     */
    private FlightlessBird _kiwi;

    /**
     * Represents the gray emu object
     */
    private FlightlessBird _emu;

    /**
     * Represents the owl object
     */
    private Owl _owl;

    /**
     * Represents the pigeon object
     */
    private Pigeon _pigeon;

    /**
     * Represents the hawk object
     */
    private BirdOfPrey _hawk;

    /**
     * Represents the gray parrot object
     */
    private Waterfowl _goose;

    /**
     * Represents the gray parrot object
     */
    private Shorebird _greatAuk;


    /**
     * Initializes the bird objects used for testing the model creation.
     */
    @Before
    public void setUp() {

        _grayParrot =  TestingHelper.CreateParrot(CorrectParrotData.GrayParrot,CorrectParrotData.FavoriteWord,CorrectParrotData.Vocab);
        _kiwi =  TestingHelper.CreateFlightless(CorrectFlightLessData.Kiwi);
        _emu =  TestingHelper.CreateFlightless(CorrectFlightLessData.Emu);
        _owl =  TestingHelper.CreateOwl(CorrectOwlData.Owl);
        _pigeon =  TestingHelper.CreatePigeon(CorrectPigeonData.Pigeon);
        _hawk =  TestingHelper.CreateBirdOfPrey(CorrectBirdOfPreyData.Hawk);
        _goose =  TestingHelper.CreateWaterFowl(CorrectWaterFowlData.Goose);
        _greatAuk =  TestingHelper.CreateShoreBird(CorrectShoreBirdData.GreatAuk);

    }

    /**
     * Test the parrot object creation with vocabulary that exceeds 100 words
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Parrot_Vocabulary(){
        var vocabulary = new HashSet<String>();
        for(int i = 0; i<=100; ++i){
            vocabulary.add("test"+i);
        }

       new Parrot(CorrectParrotData.GrayParrot, CorrectParrotData.FavoriteWord,vocabulary);
    }

    /**
     * Tests the owl object creation with incorrect type
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Owl(){
        TestingHelper.CreateOwl(BirdType.OTHER);
    }

    /**
     * Tests the parrot object creation with incorrect type
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Parrot(){
        TestingHelper.CreateParrot(BirdType.OTHER, null, null);
    }

    /**
     * Tests the pigeon object creation with incorrect type
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Pigeon(){
        TestingHelper.CreatePigeon(BirdType.OTHER);
    }

    /**
     * Tests the watefowl object creation with incorrect type
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_WaterFowl(){
        TestingHelper.CreateWaterFowl(BirdType.OTHER);
    }

    /**
     * Tests the shorebird object creation with incorrect type
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_ShoreBird(){
        TestingHelper.CreateShoreBird(BirdType.OTHER);
    }

    /**
     * Tests the bird of prey object creation with incorrect type
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_BirdOfPrey(){
        TestingHelper.CreateBirdOfPrey(BirdType.OTHER);
    }

    /**
     * Tests the flightless object creation with incorrect type
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Flightless(){
        TestingHelper.CreateFlightless(BirdType.OTHER);
    }

    /**
     * Tests if the parrot functionality of setting the favorite word works properly
     */
    @Test
    public void test_Set_Parrot_Favorite_Word(){
        var parrot = TestingHelper.CreateParrot(CorrectParrotData.GrayParrot, CorrectParrotData.FavoriteWord, CorrectParrotData.Vocab);
        parrot.setFavoriteWord("CS5010");
        assertEquals("CS5010", parrot.getFavoriteWord());
    }

    /**
     * Tests if the Parrot object is created properly. Compares each property and member variable to the correct data
     */
    @Test
    public void test_Correct_Parrot() {
        assertEquals(_grayParrot.getFavoriteWord(),CorrectParrotData.FavoriteWord);
        var vocab = _grayParrot.getVocabulary();

        assertEquals(vocab.size(),CorrectParrotData.Vocab.size());
        for (var word: vocab){
            assertTrue(CorrectParrotData.Vocab.contains(word));
        }

        assertEquals(_grayParrot.getBirdClassification(),CorrectParrotData.Classification);
        assertEquals(_grayParrot.getNumberOfWings(),CorrectParrotData.NumberOfWings);
        assertEquals(_grayParrot.getBirdType(),CorrectParrotData.GrayParrot);
        assertEquals(_grayParrot.checkIfExtinct(),CorrectParrotData.IsExtinct);

        var foodPreferences = _grayParrot.getFoodPreferences();
        assertEquals(foodPreferences.size(), CorrectParrotData.FoodPreferences.size());
        for(var food: foodPreferences){
            assertTrue(CorrectParrotData.FoodPreferences.contains(food));
        }

        var beak = _grayParrot.getBeak();
        assertEquals(beak.getBeakSize(), CorrectParrotData.Beak.getBeakSize());
        assertEquals(beak.getBeakType(), CorrectParrotData.Beak.getBeakType());
        assertEquals(beak.HasVisibleNostrils(), CorrectParrotData.Beak.HasVisibleNostrils());
        assertEquals(beak.IsSharp(), CorrectParrotData.Beak.IsSharp());
    }

    /**
     * Tests if the Owl object is created properly. Compares each property and member variable to the correct data
     */
    @Test
    public void test_Correct_Owl() {

        assertEquals(_owl.getBirdClassification(),CorrectOwlData.Classification);
        assertEquals(_owl.getNumberOfWings(),CorrectOwlData.NumberOfWings);
        assertEquals(_owl.getBirdType(),CorrectOwlData.Owl);
        assertEquals(_owl.checkIfExtinct(),CorrectOwlData.IsExtinct);

        var foodPreferences = _owl.getFoodPreferences();
        assertEquals(foodPreferences.size(), CorrectOwlData.FoodPreferences.size());
        for(var food: foodPreferences){
            assertTrue(CorrectOwlData.FoodPreferences.contains(food));
        }

        var beak = _owl.getBeak();
        assertEquals(beak.getBeakSize(), CorrectOwlData.Beak.getBeakSize());
        assertEquals(beak.getBeakType(), CorrectOwlData.Beak.getBeakType());
        assertEquals(beak.HasVisibleNostrils(), CorrectOwlData.Beak.HasVisibleNostrils());
        assertEquals(beak.IsSharp(), CorrectOwlData.Beak.IsSharp());
        assertEquals(_owl.getFacialDisk(), CorrectOwlData.FacialDisk);
    }

    /**
     * Tests if the Pigeon object is created properly. Compares each property and member variable to the correct data
     */
    @Test
    public void test_Correct_Pigeon() {

        assertEquals(_pigeon.getBirdClassification(),CorrectPigeonData.Classification);
        assertEquals(_pigeon.getNumberOfWings(),CorrectPigeonData.NumberOfWings);
        assertEquals(_pigeon.getBirdType(),CorrectPigeonData.Pigeon);
        assertEquals(_pigeon.checkIfExtinct(),CorrectPigeonData.IsExtinct);

        var foodPreferences = _pigeon.getFoodPreferences();
        assertEquals(foodPreferences.size(), CorrectPigeonData.FoodPreferences.size());
        for(var food: foodPreferences){
            assertTrue(CorrectPigeonData.FoodPreferences.contains(food));
        }

        var beak = _pigeon.getBeak();
        assertEquals(beak.getBeakSize(), CorrectPigeonData.Beak.getBeakSize());
        assertEquals(beak.getBeakType(), CorrectPigeonData.Beak.getBeakType());
        assertEquals(beak.HasVisibleNostrils(), CorrectPigeonData.Beak.HasVisibleNostrils());
        assertEquals(beak.IsSharp(), CorrectPigeonData.Beak.IsSharp());
        assertEquals(_pigeon.getFeedingInfo(), CorrectPigeonData.FeedsMilk);
    }

    /**
     * Tests if the BirdOfPrey object is created properly. Compares each property and member variable to the correct data
     */
    @Test
    public void test_Correct_Bird_Of_Prey() {

        assertEquals(_hawk.getBirdClassification(),CorrectBirdOfPreyData.Classification);
        assertEquals(_hawk.getNumberOfWings(),CorrectBirdOfPreyData.NumberOfWings);
        assertEquals(_hawk.getBirdType(),CorrectBirdOfPreyData.Hawk);
        assertEquals(_hawk.checkIfExtinct(),CorrectBirdOfPreyData.IsExtinct);

        var foodPreferences = _hawk.getFoodPreferences();
        assertEquals(foodPreferences.size(), CorrectBirdOfPreyData.FoodPreferences.size());
        for(var food: foodPreferences){
            assertTrue(CorrectBirdOfPreyData.FoodPreferences.contains(food));
        }

        var beak = _hawk.getBeak();
        assertEquals(beak.getBeakSize(), CorrectBirdOfPreyData.Beak.getBeakSize());
        assertEquals(beak.getBeakType(), CorrectBirdOfPreyData.Beak.getBeakType());
        assertEquals(beak.HasVisibleNostrils(), CorrectBirdOfPreyData.Beak.HasVisibleNostrils());
        assertEquals(beak.IsSharp(), CorrectBirdOfPreyData.Beak.IsSharp());
    }

    /**
     * Tests if the Flightless Kiwi object is created properly. Compares each property and member variable to the correct data
     */
    @Test
    public void test_Correct_Kiwi() {

        assertEquals(_kiwi.getBirdClassification(),CorrectFlightLessData.Classification);
        assertEquals(_kiwi.getNumberOfWings(),CorrectFlightLessData.NumberOfWings);
        assertEquals(_kiwi.getBirdType(),CorrectFlightLessData.Kiwi);
        assertEquals(_kiwi.checkIfExtinct(),CorrectFlightLessData.IsExtinctKiwi);

        var foodPreferences = _kiwi.getFoodPreferences();
        assertEquals(foodPreferences.size(), CorrectFlightLessData.FoodPreferences.size());
        for(var food: foodPreferences){
            assertTrue(CorrectFlightLessData.FoodPreferences.contains(food));
        }

        var beak = _kiwi.getBeak();
        assertEquals(beak.getBeakSize(), CorrectFlightLessData.Beak.getBeakSize());
        assertEquals(beak.getBeakType(), CorrectFlightLessData.Beak.getBeakType());
        assertEquals(beak.HasVisibleNostrils(), CorrectFlightLessData.Beak.HasVisibleNostrils());
        assertEquals(beak.IsSharp(), CorrectFlightLessData.Beak.IsSharp());
    }

    /**
     * Tests if the Flightless Emu object is created properly. Compares each property and member variable to the correct data
     */
    @Test
    public void test_Correct_Emu() {

        assertEquals(_emu.getBirdClassification(),CorrectFlightLessData.Classification);
        assertEquals(_emu.getNumberOfWings(),CorrectFlightLessData.NumberOfWings);
        assertEquals(_emu.getBirdType(),CorrectFlightLessData.Emu);
        assertEquals(_emu.checkIfExtinct(),CorrectFlightLessData.IsExtinct);

        var foodPreferences = _emu.getFoodPreferences();
        assertEquals(foodPreferences.size(), CorrectFlightLessData.FoodPreferences.size());
        for(var food: foodPreferences){
            assertTrue(CorrectFlightLessData.FoodPreferences.contains(food));
        }

        var beak = _emu.getBeak();
        assertEquals(beak.getBeakSize(), CorrectFlightLessData.Beak.getBeakSize());
        assertEquals(beak.getBeakType(), CorrectFlightLessData.Beak.getBeakType());
        assertEquals(beak.HasVisibleNostrils(), CorrectFlightLessData.Beak.HasVisibleNostrils());
        assertEquals(beak.IsSharp(), CorrectFlightLessData.Beak.IsSharp());
    }

    /**
     * Tests if the Waterfowl object is created properly. Compares each property and member variable to the correct data
     */
    @Test
    public void test_Correct_Waterfowl() {

        assertEquals(_goose.getBirdClassification(),CorrectWaterFowlData.Classification);
        assertEquals(_goose.getNumberOfWings(),CorrectWaterFowlData.NumberOfWings);
        assertEquals(_goose.getBirdType(),CorrectWaterFowlData.Goose);
        assertEquals(_goose.checkIfExtinct(),CorrectWaterFowlData.IsExtinct);

        var foodPreferences = _goose.getFoodPreferences();
        assertEquals(foodPreferences.size(), CorrectWaterFowlData.FoodPreferences.size());
        for(var food: foodPreferences){
            assertTrue(CorrectWaterFowlData.FoodPreferences.contains(food));
        }

        var beak = _goose.getBeak();
        assertEquals(beak.getBeakSize(), CorrectWaterFowlData.Beak.getBeakSize());
        assertEquals(beak.getBeakType(), CorrectWaterFowlData.Beak.getBeakType());
        assertEquals(beak.HasVisibleNostrils(), CorrectWaterFowlData.Beak.HasVisibleNostrils());
        assertEquals(beak.IsSharp(), CorrectWaterFowlData.Beak.IsSharp());

        var habitats = _goose.getLivingHabitats();
        assertEquals(habitats.size(), CorrectWaterFowlData.LivingHabitats.size());
        for(var habitat: habitats){
            assertTrue(CorrectWaterFowlData.LivingHabitats.contains(habitat));
        }
    }

    /**
     * Tests if the ShoreBird object is created properly. Compares each property and member variable to the correct data
     */
    @Test
    public void test_Correct_ShoreBird() {

        assertEquals(_greatAuk.getBirdClassification(),CorrectShoreBirdData.Classification);
        assertEquals(_greatAuk.getNumberOfWings(),CorrectShoreBirdData.NumberOfWings);
        assertEquals(_greatAuk.getBirdType(),CorrectShoreBirdData.GreatAuk);
        assertEquals(_greatAuk.checkIfExtinct(),CorrectShoreBirdData.IsExtinct);

        var foodPreferences = _greatAuk.getFoodPreferences();
        assertEquals(foodPreferences.size(), CorrectShoreBirdData.FoodPreferences.size());
        for(var food: foodPreferences){
            assertTrue(CorrectShoreBirdData.FoodPreferences.contains(food));
        }

        var beak = _greatAuk.getBeak();
        assertEquals(beak.getBeakSize(), CorrectShoreBirdData.Beak.getBeakSize());
        assertEquals(beak.getBeakType(), CorrectShoreBirdData.Beak.getBeakType());
        assertEquals(beak.HasVisibleNostrils(), CorrectShoreBirdData.Beak.HasVisibleNostrils());
        assertEquals(beak.IsSharp(), CorrectShoreBirdData.Beak.IsSharp());

        var habitats = _greatAuk.getLivingHabitats();
        assertEquals(habitats.size(), CorrectShoreBirdData.LivingHabitats.size());
        for(var habitat: habitats){
            assertTrue(CorrectShoreBirdData.LivingHabitats.contains(habitat));
        }
    }
}
