/**
 * Stores information about the bird and the aviary the bird is currently housed in.
 */
public final class BirdWithAviaryId {
    /**
     * Represents the bird object currently housed in aviary
     */
    private final Bird _bird;

    /**
     * Represents the aviary unique identifier in which the bird is housed.
     */
    private final String _aviaryId;

    /**
     * Constructor: Creates BirdWithAviaryId object. Initializes the bird and the aviary id member variables
     */
    public BirdWithAviaryId(Bird bird, String aviaryId){
        _bird = bird;
        _aviaryId = aviaryId;
    }

    /**
     * Getter: Retrieves the unique identifier of the Aviary
     * @return String representation of unique identifier of the aviary
     */
    public String getAviaryId() {
        return _aviaryId;
    }

    /**
     * Getter: Retrieves the bird
     * @return Bird object
     */
    public Bird getBird() {
        return _bird;
    }

}
