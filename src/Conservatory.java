import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Represents the conservatory. Has the functionality to rescue a bird, print alphabetically sorted birds in every aviary
 * List all aviaries with every bird with its representation, Search in which aviary a particular bird is in, and
 * Display food storage with respective quantities required to feed the birds.
 */
public final class Conservatory implements IConservatory {
    /**
     * Represents the current maximum number of aviaries a conservatory can have
     */
    private int _maximumCapacity;

    /**
     * Represents the food storage as a map. Stores information about what type of food is stored in what quantities
     */
    private HashMap<FoodType, Integer> _foodStorage;

    /**
     * Stores the list of aviaries that the conservatory has
     */
    private ArrayList<Aviary> _aviaries;

    /**
     * Constructor: Creates empty conservatory. Sets maximum capacity to 20 and initializes food storage an aviaries.
     */
    public Conservatory(){
        _maximumCapacity = 20;
        _aviaries = new ArrayList<>();
        _foodStorage = new HashMap<>();
    }

    /**
     * Creates conservatory based on provided aviaries. Validates the input aviaries for size, conflicting types of birds
     * Initializes aviaries, food storage and maximum capacity based on the input parameter.
     */
    public Conservatory(ArrayList<Aviary> aviaries){
        if(aviaries != null && aviaries.size() > 20)
            throw new IllegalArgumentException("Maximum capacity for aviaries exceeded");
        _foodStorage = new HashMap<>();
        _aviaries = aviaries;
        _maximumCapacity = 20;
        if(aviaries != null){
            _maximumCapacity -= aviaries.size();
            for (var aviary: aviaries){
                aviary.validateAviary();
                for (var bird : aviary.getCurrentBirds()){
                    var food = randomSelectFoodType(bird);
                    _foodStorage.put(food, _foodStorage.getOrDefault(food, 0) + 5);
                }
            }
        }
    }

    /**
     * Adds bird to any available aviary. Validates the bird input, checks if the bird can be rescued and adds
     * the bird into any existing or new aviary if such thing is possible.
     * @throws Exception if the bird is either extinct, already added in the aviary, the maximum capacity has been reached
     *                   or there is a conflicting types of birds such that no new addition of this particular bird type
     *                   can be housed
     */
    public void rescueBird(Bird bird) throws Exception {
        if(bird.checkIfExtinct())
            throw new Exception("Cannot rescue extinct bird");

        var foodType = randomSelectFoodType(bird);
        if (_aviaries.size() == 0){
            var newAviary = new Aviary();
            newAviary.tryAddBird(bird);
            _aviaries.add(newAviary);
            _maximumCapacity--;
            _foodStorage.put(foodType, 5);
            return;
        }
        if(existsInAviary(bird)){
           throw new Exception(String.format("The bird with id: %s already exists in the conservatoire", bird.getId()));
        }

        for (var aviary : _aviaries){
            if(aviary.tryAddBird(bird)){
                _foodStorage.put(foodType, _foodStorage.getOrDefault(foodType, 0) + 5);
                _maximumCapacity--;
                return;
            }
        }
        if(!isFull()){
            var newAviary = new Aviary();
            newAviary.tryAddBird(bird);
            _aviaries.add(newAviary);
            _maximumCapacity--;
            _foodStorage.put(foodType, _foodStorage.getOrDefault(foodType, 0) + 5);
            return;
        }
        throw new Exception("The following bird cannot be added into any aviary");
    }

    /**
     * Sorts the birds in alphabetical order and displays the sorted birds with their respective aviary id.
     */
    public void printSortedBirds(){
        var result = AviaryHelper.getSortedBirds(this);
        for(var bird : result){
            System.out.printf("%s, aviary id: %s%n", bird.getBird().getBirdType(), bird.getAviaryId());
        }

    }

    /**
     * Getter: Retrieves the food storage of the conservatory
     * @return HashMap of food type with their respective quantity.
     */
    public HashMap<FoodType, Integer> getFoodStorage(){
        return _foodStorage;
    }

    /**
     * Prints all aviaries with their respective collection of birds and their specifications.
     */
    public void listAllAviaries(){
        for (var aviary : _aviaries)
            System.out.println(aviary.toString());
    }

    /**
     * Prints the food storage contents for each type of food stored, respective amount the number of weeks this
     * food will feed a single bird.
     */
    public void listFoodStorageContents(){
        for (var key : _foodStorage.keySet()){
            var count = _foodStorage.get(key);
            System.out.printf("%s:%s units(feeds one bird for %s weeks)", key.toString().toLowerCase(), count, count);
            System.out.println();
        }
    }

    /**
     * Provides lookup for a specific bird in the conservatory.
     * @return unique identifier of the aviary where the bird is housed, null if not found in any aviary
     */
    public String searchAviaryByBird(Bird bird){
        for(var aviary: _aviaries){
            if(aviary.exists(bird))
                return aviary.getId();
        }
        return null;
    }

    /**
     * Getter: Retrieves the list of currently operation aviaries in the conservatory
     */
    public ArrayList<Aviary> getAviaries(){
        return _aviaries;
    }


    public boolean isFull(){
        return _maximumCapacity <= 0;
    }

    /**
     * Checks if the input bird exists in any aviary.
     * @return true if bird is found, false otherwise.
     */
    private boolean existsInAviary(Bird bird){
        for (var aviary:_aviaries) {
            if(aviary.exists(bird))
                return true;
        }
        return false;
    }

    /**
     * Provides functionality for pseudo random. Used to generate food type that is stored in the food storage
     * Uses seed value to compute the same value for the same input.
     * @return random FoodType selected from the food preferences of a particular bird
     */
    private FoodType randomSelectFoodType(Bird bird){
        var foodPreferences = bird.getFoodPreferences();
        Random rand = new Random(2);

        return foodPreferences.get(rand.nextInt(foodPreferences.size()));
    }
}

