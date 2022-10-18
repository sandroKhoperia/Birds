import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Represents single aviary. Provides functionality for adding birds into aviary, removing birds from aviary,
 * and checking if the particular bird belongs to this aviary
 */
public final class Aviary implements IAviary {
    /**
     * Stores how many of specific bird classification are currently in the aviary
     */
    private final HashMap<BirdClassification, Integer> _housedBirdDetails;

    /**
     * Unique identifier of the aviary. Type: Random UUID is converted into String
     */
    private String _id;

    /**
     * Represents the current maximum number of birds that can be housed inside the aviary
     */
    private int _maximumCapacity;

    /**
     * Stores the current birds in the aviary
     */
    private ArrayList<Bird> _currentBirds;

    /**
     * Constructor: Creates empty aviary, generates the new unique identifier and sets the maximum capacity to 5 birds
     */
    public Aviary(){
        _currentBirds = new ArrayList<>();
        _maximumCapacity = 5;
        _id = UUID.randomUUID().toString();
        _housedBirdDetails = new HashMap<>();
    }

    /**
     * Constructor: Creates aviary based on provided list of birds, validates the input list,
     * Stores the input list, updates the housed bird details based on input bird classification and quantity
     * Updates the maximum capacity according to the number of birds received as an input
     */
    public Aviary(ArrayList<Bird> birds){
        if(birds != null && birds.size() > 5){
                throw new IllegalArgumentException("Aviary cannot house more than five birds");
        }
        _housedBirdDetails = new HashMap<>();
        _maximumCapacity = 5;
        if(birds != null){
            for(var bird : birds){
                var classification = bird.getBirdClassification();
                _housedBirdDetails.put(classification, _housedBirdDetails.getOrDefault(classification,0)+1);
            }

            if(!validateAviary())
                throw new IllegalArgumentException("Aviary cannot house conflicting types of birds");

            _maximumCapacity -= birds.size();
        }
        _currentBirds = birds;
        _id = UUID.randomUUID().toString();

    }

    /**
     * Tries to add bird into aviary, checks if the incoming bird can be housed in the aviary by
     * Checking the conflicting types, current maximum capacity, and if the bird already exists in the aviary
     * If bird is successfully added, updates internal fields to reflect the change caused by new addition.
     * Therefore, this method ensures that the correct data is maintained at all times.
     * @return returns true if the bird is successfully added in the aviary, false otherwise.
     */
    public boolean tryAddBird(Bird bird){
        if(isFull())
            return false;

        if(bird.checkIfExtinct())
            return false;

        var classification = bird.getBirdClassification();

        var housedTypes = _housedBirdDetails.keySet();

        switch (classification){
            case PARROT,PIGEON,SHOREBIRD,OWL ->{
                if(_housedBirdDetails.containsKey(BirdClassification.BIRD_OF_PREY)
                        || _housedBirdDetails.containsKey(BirdClassification.FLIGHTLESS)
                        || _housedBirdDetails.containsKey(BirdClassification.WATERFOWL))
                    return false;
            }
            case WATERFOWL -> {
                if(housedTypes.size() >= 1 && !_housedBirdDetails.containsKey(BirdClassification.WATERFOWL))
                    return false;

            }
            case FLIGHTLESS -> {
                if(housedTypes.size() >= 1 && !_housedBirdDetails.containsKey(BirdClassification.FLIGHTLESS))
                    return false;

            }
            case BIRD_OF_PREY -> {
                if(housedTypes.size() >= 1 && !_housedBirdDetails.containsKey(BirdClassification.BIRD_OF_PREY))
                    return false;
            }

        }
        _maximumCapacity--;
        _currentBirds.add(bird);
        _housedBirdDetails.put(classification, _housedBirdDetails.getOrDefault(classification, 0) + 1);
        return true;
    }

    /**
     * Removes specific bird from aviary. First this method checks if the bird is currently in the aviary.
     * If so, removes it from the list and calls the internal remove method.
     */
    public void removeBird(Bird bird){
        for(int i = 0; i< _currentBirds.size(); ++i){
            if(bird._id.equals(_currentBirds.get(i)._id)){
                removeInternal(i,bird.getBirdClassification());
                return;
            }
        }
    }

    /**
     * Removes specific bird from aviary. First this method checks if the bird is currently in the aviary.
     * If so, removes it from the list and calls the internal remove method.
     */
    public void removeBird(String id){
        for(int i = 0; i< _currentBirds.size(); ++i){
            var currBird =_currentBirds.get(i);
            if(id.equals(currBird.getId())){
                removeInternal(i,currBird.getBirdClassification());
                return;
            }
        }
    }

    /**
     * Checks whether the queried bird is in the aviary
     * @return true if such bird exists, false otherwise.
     */
    public boolean exists(Bird bird){
        for (var brd : _currentBirds){
            if(bird._id.equals(brd._id))
                return true;
        }
        return false;
    }

    /**
     * Getter: Retrieves the current list of birds in the aviary.
     * @return ArrayList of birds
     */
    public ArrayList<Bird> getCurrentBirds() {
        return _currentBirds;
    }

    /**
     * Getter: Retrieves the unique identifier of the aviary
     * @return String representation of the unique UUID
     */
    public String getId() {
        return _id;
    }


    /**
     * Checks whether the aviary is full or not
     * @return true if full, false otherwise
     */
    public boolean isFull(){
        return _maximumCapacity <= 0;
    }

    /**
     * Getter: Retrieves bird classifications with respective number of birds that are housed in the aviary.
     * @return Hashmap of bird classification and integer.
     */
    public HashMap<BirdClassification, Integer> getHousedBirdDetails() {
        return _housedBirdDetails;
    }

    /**
     * Performs the validation of the aviary. Ensures that no conflicting types of birds are housed together.
     */
    public boolean validateAviary() {
        if(_housedBirdDetails.containsKey(BirdClassification.BIRD_OF_PREY) && _housedBirdDetails.keySet().size() > 1)
            return false;

        if(_housedBirdDetails.containsKey(BirdClassification.FLIGHTLESS) && _housedBirdDetails.keySet().size() > 1)
            return false;

        if(_housedBirdDetails.containsKey(BirdClassification.WATERFOWL) && _housedBirdDetails.keySet().size() > 1)
            return false;

        return true;
    }

    /**
     * Removes a specific bird from the aviary by removing it from the list as well as from the map
     * Ensures that the bird data is always correct and up to date. Adjusts maximum capacity
     */
    private void removeInternal(int idx, BirdClassification classification){
        _currentBirds.remove(idx);
        _maximumCapacity++;
        var mappedBird = _housedBirdDetails.get(classification);
        if( mappedBird - 1 <= 0)
            _housedBirdDetails.remove(classification);
        else
            _housedBirdDetails.put(classification, mappedBird-1);
    }

    /**
     * @return String representation of aviary by including all birds with their respective representations and aviary id.
     */
    @Override
    public String toString() {
        var sb = new StringBuilder(String.format("Aviary Id:%s", _id) + "\n");
        var counter = 1;
        for (var bird: _currentBirds) {
            sb.append(counter).append(".").append(bird.toString()).append("\n");
            counter++;
        }
        return sb.toString();
    }
}
