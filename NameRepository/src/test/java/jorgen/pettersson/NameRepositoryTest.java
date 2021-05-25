package jorgen.pettersson;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for NameRepository.
 */
public class NameRepositoryTest
{

    @BeforeEach
    /**
    * @Initiation of test
     * Array is cleared
     * A test array is created and made to default
     */

    void setUp(){
    NameRepository.clear();
    String[] testArray = {"Lars Jonsson", "Erik Eriksson", "Anna Andersson", "Lena Eriksson", "Erik Svensson" };
    NameRepository.addArrayString(testArray);
    }

    @Test
    /**
     * @Test of getSize
     * getSize is called and a int is returned
     * The int is compared with expected result
     */

    public void getSize(){
        int result = NameRepository.getSize();
        int expected = 5;

        assertEquals(expected, result);
    }

    @Test
    /**
     *@ add is tested
     * A name is created and sent be added to Array
     * The result is tested true or false
     * The default value is set to false
     */
    public void add(){

        String name = "Erik Svensson";
        boolean result = NameRepository.add(name);

        assertEquals(false, result);

    }

    @Test
    /**
     * @ remove is tested
     * A name is created and sent to remove
     * the result is stored in result and tested true or false
     * The expected result is true
     */
    public void remove(){

        String name = "Lars Jonsson";
        boolean result = NameRepository.remove(name);
        
        assertEquals(true, result);
    }

    @Test
    /**
     * @find is tested
     * Name is created and sent to find()
     * The return value is stored in result
     * Result is evaluated and the expected value is null
     */
    public void find(){
        String name = "Lars Olsson";
        String result = NameRepository.find(name);
        String expected = null;

        assertEquals(expected, result);

    }

    @Test
    /**
     * @findAll is tested
     *  A test array is created and a int with the length of array from method getSize()
     *  The test arrays length is tested against the length from getSize
     */
    public void findAll(){
        String [] testArray = NameRepository.findAll();
        int testLength = NameRepository.getSize();

        assertEquals(testLength, testArray.length);

    }

    @Test
    /**
     * @update is tested
     * Two strings are created. One with the name we want to update an one that will replace it
     * A boolean is returned an evaluated
     */
    public void update(){
        String name = "Lars Jonsson";
        String updateName = "Lars Nilsson";

        boolean result = NameRepository.update(name, updateName);

        assertTrue(result);
    }

    @Test
    /**
     * @findByFirstName is tested
     * A name is created and sent to findByFirstName
     * Two strings are created. One with what we expect and one from findByFirstName
     * This are evaluated
     */
    public void findByFirstName(){
        String name = "Erik";
        String [] expectedArray = {"Erik Eriksson", "Erik Svensson" };
        String [] firstNameArray = NameRepository.findByFirstName(name);

        assertArrayEquals(expectedArray, firstNameArray);
    }

    @Test
    /**
     * @findByLastName is tested
     * A name is created and sent to findByLastName
     * Two strings are created. One with what we expect and one from findByLastName
     * This are evaluated
     */

    public void findByLastName(){
        String name = "Eriksson";
        String [] expectedArray = {"Erik Eriksson", "Lena Eriksson" };
        String [] lastNameArray = NameRepository.findByLastName(name);

        assertArrayEquals(expectedArray, lastNameArray);
    }

    @Test
    /**
     * @clear is tested
     * Clear is called and the methods findAll and getSize is called
     * The size from this methods is tested if they are equal
     */
    public void clear(){
        boolean result = false;
        NameRepository.clear();
        String [] testArray = NameRepository.findAll();
        int testLength = NameRepository.getSize();

        assertEquals(testLength, testArray.length);

    }

    @Test
    /**
     * @addArrayString is tested
     * clear is called an a new Array is created and sent to addArrayString
     * findAll is called and the array is tested against the one we sent in
     */
    public void addArrayString(){
        NameRepository.clear();
        String [] addArrayTest = {"Lars Jonsson", "Erik Eriksson", "Anna Andersson" };
        NameRepository.addArrayString(addArrayTest);

        String [] testArray = NameRepository.findAll();

        assertArrayEquals(addArrayTest, testArray);
    }

    /**
     * Print methods if you want to see whats in a array
     */

    public void toString(String [] testArray){

        for(int i = 0; i < testArray.length; i++ ){

            System.out.println(testArray[i]);
        }
        System.out.println("\n");
    }

}
