/**
 * Provides method signatures for Conservatory class.
 */
public interface IConservatory {
    /**
     * Tries to rescue the current bird
     * @throws Exception if bird cannot be rescued due to: being a conflicting type, all aviaries are full, or bird is extinct.
     */
    void rescueBird(Bird bird) throws Exception;

    /**
     * Prints every bird with their respective aviary in alphabetical order
     */
    void printSortedBirds();

    /**
     * Prints all aviaries with their respective birds housed as well as the details and unique features of each bird.
     */
    void listAllAviaries();

    /**
     * Prints the food storage: food types with their specific quantities and how many weeks that food can feed a bird.
     */
    void listFoodStorageContents();

    /**
     * Searches the conservatory for the specific bird
     * @return the unique identifier of the aviary that currently houses the bird if found, null otherwise
     */
    String searchAviaryByBird(Bird bird);

    /**
     * Checks whether the conservatory is full
     * @return true if it is full, false otherwise
     */
    boolean isFull();
}
