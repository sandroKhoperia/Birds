/**
 * Provides signatures for Aviary class
 */
public interface IAviary {
    /**
     * Tries to add specified bird into aviary.
     * @return true if bird was added, false otherwise
     */
    boolean tryAddBird(Bird bird);

    /**
     * Removes the specified bird from the aviary
     */
    void removeBird(Bird bird);

    /**
     * Removes the specified bird from aviary
     */
    void removeBird(String id);

    /**
     * Checks whether the specified bird exists in the aviary.
     * @return true if the bird is found, false otherwise
     */
    boolean exists(Bird bird);

    /**
     * Checks whether there are conflicting types of birds housed in the aviary
     * @return true if there are no conflicting types of birds, false otherwise.
     */
    boolean validateAviary();

    /**
     * Checks whether the aviary is full
     * @return true if full, false otherwise.
     */
    boolean isFull();
}
