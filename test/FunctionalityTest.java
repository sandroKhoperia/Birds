import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * This class is used to test different functionalities of Conservatories, Aviaries, and Birds
 */
public class FunctionalityTest {
    /**
     * Represents the empty conservatory object
     */
    private Conservatory _emptyConservatory;

    /**
     * Represents the conservatory with all available aviaries filled to their maximum capacity
     */
    private Conservatory _fullConservatory;

    /**
     * Represents the BirdWithAviaryId list
     */
    private ArrayList<BirdWithAviaryId> _birdsWithAviaries;

    /**
     * Initializes the empty conservatory, full conservatory and list of BirdWithAviaryId objects.
     */
    @Before
    public void setUp(){
        _emptyConservatory = TestingHelper.CreateEmptyConservatory();
        _fullConservatory = TestingHelper.CreateCappedConservatory();

        _birdsWithAviaries = TestingHelper.CreateBirdWithAviaryIdByConservatory(_fullConservatory);
    }

    /**
     * Tests if bird can be added into full aviary
     */
    @Test(expected = Exception.class)
    public void test_Rescue_Bird_Into_Full_Aviary() throws Exception {
        var owl = TestingHelper.CreateOwl(BirdType.OWL);
        _fullConservatory.rescueBird(owl);
    }

    /**
     * tests if bird can be added in a conservatory aviary which is the only available aviary and
     * houses a conflicting bird types to the input.
     */
    @Test(expected = Exception.class)
    public void test_Rescue_Bird_With_Conflicting_Type() throws Exception {
        var emptyAviaries = new ArrayList<Aviary>();
        for(int i = 0; i < 20; ++i){
            emptyAviaries.add(new Aviary());
        }
        var newConservatory = new Conservatory(emptyAviaries);
        for(int i = 0; i < 19; ++i){
            newConservatory.rescueBird(TestingHelper.CreateBirdOfPrey(BirdType.EAGLE));
            newConservatory.rescueBird(TestingHelper.CreateBirdOfPrey(BirdType.EAGLE));
            newConservatory.rescueBird(TestingHelper.CreateBirdOfPrey(BirdType.EAGLE));
            newConservatory.rescueBird(TestingHelper.CreateBirdOfPrey(BirdType.EAGLE));
            newConservatory.rescueBird(TestingHelper.CreateBirdOfPrey(BirdType.EAGLE));
        }
        newConservatory.rescueBird(TestingHelper.CreateBirdOfPrey(BirdType.EAGLE));
        newConservatory.rescueBird(TestingHelper.CreatePigeon(BirdType.DOVE));


    }

    /**
     * Tests if extinct bird can be rescued into conservatory
     */
    @Test(expected = Exception.class)
    public void test_Rescue_Extinct_Bird() throws Exception {
        var moa = TestingHelper.CreateFlightless(BirdType.MOA);
        _emptyConservatory.rescueBird(moa);
    }

    /**
     * Tests if aviary can be created with 5+ birds.
     */
    @Test(expected = IllegalArgumentException.class )
    public void test_Incorrect_Aviary_With_Too_Many_Birds() {
        TestingHelper.CreateIncorrectAviary();
    }

    /**
     * Tests if aviary can be created with conflicting types of birds
     */
    @Test(expected = IllegalArgumentException.class )
    public void test_Incorrect_Aviary_With_ConflictingBirds() {
        TestingHelper.CreateAviaryWithConflictingBirds();
    }

    /**
     * Tests if conservatory can be created with 20+ aviaries
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Incorrect_Conservatory_With_Too_Many_Aviaries(){
        TestingHelper.CreateIncorrectConservatory();
    }

    /**
     * Tests if the same exact bird can be rescued into conservatory
     */
    @Test(expected = Exception.class)
    public void test_Bird_Exists_In_Conservatory() throws Exception {
        var bird = new BirdOfPrey(BirdType.HAWK);
        _emptyConservatory.rescueBird(bird);
        _emptyConservatory.rescueBird(bird);
    }

    /**
     * Tests if parrot can learn 100+ words
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Too_Much_Teaching_Words_Parrot(){
        var parrot = new Parrot(CorrectParrotData.GrayParrot, CorrectParrotData.FavoriteWord, null);
        for(int i = 0; i<100;++i){
            parrot.teachParrotAWord("test"+i);
        }
    }

    /**
     * Tests the conservatory functionality of sorting birds in every aviary works properly
     */
    @Test
    public void test_Sorting_Birds(){
        _birdsWithAviaries.sort(Comparator.comparing(o -> o.getBird().getBirdType().toString().toLowerCase()));
        var sorted = AviaryHelper.getSortedBirds(_fullConservatory);

        for(int i = 0; i < sorted.size();++i ){
            assertEquals(sorted.get(i).getBird().getBirdType(), _birdsWithAviaries.get(i).getBird().getBirdType());
        }
    }

    /**
     * Tests if the conservatory functionality of searching aviary id by bird works properly
     */
    @Test
    public void test_Find_Aviary_Id(){
        var aviary = _fullConservatory.getAviaries().get(0);
        var bird = aviary.getCurrentBirds().get(0);
        var aviaryId = aviary.getId();
        assertEquals(aviaryId, _fullConservatory.searchAviaryByBird(bird));

    }

    /**
     * Tests if the conservatory functionality of listing all aviaries works properly
     */
    @Test
    public void test_List_All_Aviaries(){
        var aviaries = TestingHelper.CreateCappedAviaries();
        assertEquals(aviaries.size(), _fullConservatory.getAviaries().size());
        for (var aviary: aviaries){
            assertTrue(TestingHelper.contains(_fullConservatory.getAviaries(), aviary));
        }
    }

    /**
     * Tests if the conservatory functionality of storing food works properly
     */
    @Test
    public void test_Food_Storage(){
        var storage = TestingHelper.CreateFoodStorage();
        var consStorage = _fullConservatory.getFoodStorage();
        assertEquals(storage.size(),consStorage.size());

        for(var food: storage.keySet()){
            assertTrue(consStorage.containsKey(food));
            assertEquals(storage.get(food), consStorage.get(food));
        }

    }

    /**
     * Tests if the parrot functionality of teaching parrot a word works correctly
     */
    @Test
    public void test_Teach_Parrot_Word(){
        var parrot = new Parrot(CorrectParrotData.GrayParrot, CorrectParrotData.FavoriteWord, null);
        assertFalse(parrot.getVocabulary().contains("Design"));

        parrot.teachParrotAWord("Design");
        assertTrue(parrot.getVocabulary().contains("Design"));
    }

    /**
     * Tests if the conservatory functionality of rescuing a single bird works properly
     */
    @Test
    public void test_Rescue_Single_Bird() throws Exception {
        var owl = TestingHelper.CreateOwl(BirdType.OWL);

        _emptyConservatory.rescueBird(owl);
        assertEquals(1,_emptyConservatory.getAviaries().size());
        assertEquals(1,_emptyConservatory.getAviaries().get(0).getCurrentBirds().size());
        assertEquals(owl.getId(),_emptyConservatory.getAviaries().get(0).getCurrentBirds().get(0).getId());
    }

    /**
     * Tests if the aviary functionality of adding an extinct bird works properly
     */
    @Test
    public void test_Add_Extinct_Bird_Into_Aviary(){
        var aviary = TestingHelper.CreateEmptyAviary();
        var moa = TestingHelper.CreateFlightless(BirdType.MOA);
        assertFalse(aviary.tryAddBird(moa));
        assertEquals(0, aviary.getCurrentBirds().size());
    }

    /**
     * Tests if the aviary functionality of adding a bird to a full aviary works properly
     */
    @Test
    public void test_Add_Bird_To_Full_Aviary(){
        var aviary = TestingHelper.CreateCappedAviary();
        var owl = TestingHelper.CreateOwl(BirdType.OWL);
        assertFalse(aviary.tryAddBird(owl));
        assertEquals(5, aviary.getCurrentBirds().size());

    }

    /**
     * tests if the aviary functionality of adding a conflicting bird works properly
     */
    @Test
    public void test_Add_Conflicting_Bird_Into_Aviary(){
        var aviary = TestingHelper.CreateEmptyAviary();
        var owl = TestingHelper.CreateOwl(BirdType.OWL);
        var eagle = TestingHelper.CreateBirdOfPrey(BirdType.EAGLE);

        aviary.tryAddBird(owl);
        assertFalse(aviary.tryAddBird(eagle));
        assertEquals(1, aviary.getCurrentBirds().size());

        var goose = TestingHelper.CreateWaterFowl(BirdType.GOOSE);
        assertFalse(aviary.tryAddBird(goose));
        assertEquals(1, aviary.getCurrentBirds().size());

        var kiwi = TestingHelper.CreateFlightless(BirdType.KIWI);
        assertFalse(aviary.tryAddBird(kiwi));
        assertEquals(1, aviary.getCurrentBirds().size());


    }

    /**
     * Tests if the aviary functionality of checking whether bird exists in the aviary works properly
     */
    @Test
    public void test_Exists_In_Aviary(){
        var aviary = TestingHelper.CreateEmptyAviary();
        var owl = TestingHelper.CreateOwl(BirdType.OWL);
        aviary.tryAddBird(owl);

        assertTrue(aviary.exists(owl));
    }

    /**
     * Tests if the aviary functionality of removing a bird works properly
     */
    @Test
    public void test_Remove_Bird_From_Aviary(){
        var aviary = TestingHelper.CreateEmptyAviary();
        var owl = TestingHelper.CreateOwl(BirdType.OWL);
        aviary.tryAddBird(owl);

        aviary.removeBird(owl);
        assertFalse(aviary.exists(owl));

        aviary.tryAddBird(owl);
        aviary.removeBird(owl.getId());
        assertFalse(aviary.exists(owl));

    }
}
