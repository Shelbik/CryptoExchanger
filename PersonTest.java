//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    public PersonTest() {
    }

    @Test
    public void isAdultTestPositive() {
        Person person = new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022);
        Assert.assertTrue(person.isAdult());
    }

    @Test
    public void isAdultTestNegative() {
        Person person = new Person("Cristiano", "Ronaldo", 5, 2, 2012, 2022);
        Assert.assertFalse(person.isAdult());
    }

    @Test
    public void getAgeTest() {
        Person person = new Person("Cristiano", "Ronaldo", 5, 2, 1985, 2022);
        Assert.assertEquals(37L, (long)person.getAge());
    }
}
