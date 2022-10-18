import java.util.*;
/**
 * The class represents the mini static library used to minimize code duplication in the testing classes.
 */
public class TestingHelper {
    /**
     * Provides pseudo contains method for finding a particular aviary in the list
     * Needed only for testing purposes. Generated aviary ids are always different
     * Therefore, it was needed to define how to check whether the list contains the exact same aviary except for id.
     * @return true if list contains the aviary, false otherwise.
     */
    public static boolean contains(ArrayList<Aviary> a, Aviary b){
        for (var aviary : a){
            if(pseudoEquals(aviary, b))
                return true;
        }
        return false;
    }

    /**
     * Provides functionality for Object.equals() without actually implementing the interface as there is no need to
     * implement the actual interface for the functionality, rather it is needed here to just check that every field
     * of both aviaries are the same except for the randomly generated ids.
     * @return true if two aviaries have the same values except for id, false otherwise.
     */
    public static boolean pseudoEquals(Aviary a, Aviary b){
        if(a == null && b == null)
            return true;

        if((a == null && b!= null) || (a != null && b == null))
            return false;

        if(a.getCurrentBirds().size() != b.getCurrentBirds().size())
            return false;


        var aBirds = a.getCurrentBirds();
        var bBirds = b.getCurrentBirds();
        aBirds.sort(Comparator.comparing(Bird::getBirdType));
        bBirds.sort(Comparator.comparing(Bird::getBirdType));
        for(int i = 0 ; i < aBirds.size(); ++i){
            var aBird = aBirds.get(i);
            var bBird = bBirds.get(i);

            if(!aBird.getBirdType().equals(bBird.getBirdType()))
                return false;

            if(aBird.checkIfExtinct() != bBird.checkIfExtinct())
                return false;

            if(aBird.getBirdClassification() != bBird.getBirdClassification())
                return false;

            if(aBird.getNumberOfWings() != bBird.getNumberOfWings())
                return false;
            var aFoodPref = aBird.getFoodPreferences();
            var bFoodPref = bBird.getFoodPreferences();

            if(aFoodPref.size() != bFoodPref.size())
                return false;

            for(var foodPref : aFoodPref){
                if(!bFoodPref.contains(foodPref))
                    return false;
            }
            var aBeak = aBird.getBeak();
            var bBeak = bBird.getBeak();
            if((aBeak.IsSharp() != bBeak.IsSharp()) || (aBeak.HasVisibleNostrils() != bBeak.HasVisibleNostrils())
                    || (aBeak.getBeakSize() != bBeak.getBeakSize()) || (aBeak.getBeakType() != bBeak.getBeakType()))
                return false;
        }
        return true;

    }

    /**
     * Creates food storage for testing purposes. The values are precomputed as the storage uses pseudo random with seed
     * these values will never change, thus allowing to test the functionality of retrieving the food storage contents.
     */
    public static HashMap<FoodType, Integer> CreateFoodStorage(){
       var result = new HashMap<FoodType, Integer>();
       result.put(FoodType.INSECTS, 400);
       result.put(FoodType.NUTS, 100);
       return result;
    }

    /**
     * Creates list of BirdWithAviaryId from the conservatory object. Used to test the sorting function
     * @return list of BirdWithAviaryId objects.
     */
    public static ArrayList<BirdWithAviaryId> CreateBirdWithAviaryIdByConservatory(Conservatory cons){
        var result = new ArrayList<BirdWithAviaryId>();
        var aviaries = cons.getAviaries();
        for (var aviary: aviaries){
            for(var bird: aviary.getCurrentBirds()){
                result.add(new BirdWithAviaryId(bird, aviary.getId()));
            }
        }
        return result;
    }

    /**
     * Creates empty conservatory
     */
    public static Conservatory CreateEmptyConservatory(){
        return new Conservatory();
    }

    /**
     * Creates conservatory with exceeding amount of aviaries to test the incorrect input
     */
    public static Conservatory CreateIncorrectConservatory(){
        return new Conservatory(CreateExceedingAmountOfAviaries());
    }

    /**
     * Creates the conservatory with maximum amount of aviaries possible.
     */
    public static Conservatory CreateCappedConservatory(){
        return new Conservatory(CreateCappedAviaries());
    }

    /**
     * Creates 20 aviaries. Each aviary is filled to a maximum number of birds it can house
     */
    public static ArrayList<Aviary> CreateCappedAviaries(){
        var result = new ArrayList<Aviary>();
        for(int i = 0; i < 20; ++i){
            var aviary = CreateCappedAviary();
            result.add(aviary);
        }
        return result;
    }

    /**
     * Creates 25 aviaries. Note that only 20 are allowed to be in a single conservatory. Used to test incorrect input.
     */
    public static ArrayList<Aviary> CreateExceedingAmountOfAviaries(){
        var result = new ArrayList<Aviary>();
        for(int i = 0; i < 25; ++i ){
            result.add(CreateEmptyAviary());
        }
        return result;
    }

    /**
     * Creates aviary with too much birds in it. Used to test incorrect aviary creation.
     */
    public static Aviary CreateIncorrectAviary(){
        return new Aviary(CreateExceedingAmountOfBirds());
    }

    /**
     * Creates aviary with conflicting types of birds. Used to test incorrect aviary creation.
     */
    public static Aviary CreateAviaryWithConflictingBirds(){
        return new Aviary(CreateConflictingFiveBirds());
    }

    /**
     * Creates aviary with maximum amount of birds it can house.
     */
    public static Aviary CreateCappedAviary(){
        return new Aviary(CreateFiveBirds());
    }

    /**
     * Creates empty aviary.
     */
    public static Aviary CreateEmptyAviary(){
        return new Aviary();
    }

    /**
     * Creates the list of exceeding amount of birds. Used to test incorrect aviary creation.
     */
    public static ArrayList<Bird> CreateExceedingAmountOfBirds(){
        var result = new ArrayList<Bird>();
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        return result;
    }

    /**
     * Creates conflicting types of birds. Used to test incorrect aviary creation
     */
    public static ArrayList<Bird> CreateConflictingFiveBirds(){
        var result = new ArrayList<Bird>();
        result.add(CreateBirdOfPrey(CorrectBirdOfPreyData.Eagle));
        result.add(CreateParrot(CorrectParrotData.GrayParrot,CorrectParrotData.FavoriteWord, CorrectParrotData.Vocab));
        result.add(CreateWaterFowl(CorrectWaterFowlData.Goose));
        result.add(CreateFlightless(CorrectFlightLessData.Kiwi));
        result.add(CreatePigeon(CorrectPigeonData.Pigeon));
        return result;
    }

    /**
     * Creates maximum amount of birds a single aviary can house.
     */
    public static ArrayList<Bird> CreateFiveBirds(){
        var result = new ArrayList<Bird>();
        result.add(CreateOwl(CorrectOwlData.Owl));
        result.add(CreateParrot(CorrectParrotData.GrayParrot,CorrectParrotData.FavoriteWord, CorrectParrotData.Vocab));
        result.add(CreateOwl(CorrectOwlData.Owl));
        result.add(CreatePigeon(CorrectPigeonData.Dove));
        result.add(CreatePigeon(CorrectPigeonData.Pigeon));
        return result;
    }

    /**
     * Creates flightless bird object.
     */
    public static FlightlessBird CreateFlightless(BirdType birdType){
        return new FlightlessBird(birdType);
    }

    /**
     * Creates owl bird object.
     */
    public static Owl CreateOwl(BirdType birdType){
        return new Owl(birdType);
    }

    /**
     * Creates bird of prey object.
     */
    public static BirdOfPrey CreateBirdOfPrey(BirdType birdType){
        return new BirdOfPrey(birdType);
    }

    /**
     * Creates shore bird object.
     */
    public static Shorebird CreateShoreBird(BirdType birdType){
        return new Shorebird(birdType);
    }

    /**
     * Creates waterfowl object.
     */
    public static Waterfowl CreateWaterFowl(BirdType birdType){
        return new Waterfowl(birdType);
    }

    /**
     * Creates pigeon object.
     */
    public static Pigeon CreatePigeon(BirdType birdType){
        return new Pigeon(birdType);
    }

    /**
     * Creates parrot object.
     */
    public static Parrot CreateParrot(BirdType birdType, String favoriteWord, HashSet<String> vocab){
        return new Parrot(birdType,favoriteWord, vocab);
    }

    /**
     * Creates the testing vocabulary for the parrot.
     */
    public static HashSet<String> FillParrotVocabulary(){
        var result = new HashSet<String>();
        result.add("mom");
        result.add("dad");
        result.add("son");
        result.add("eat");
        result.add("sing");
        return result;
    }
}
