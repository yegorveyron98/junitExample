package edu.bsuir.bets;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(Theories.class)
public class PersonUnitTest {

    @DataPoints
    public static List<Integer> moneyData = Arrays.asList(0, 100, 100000);

    @Test
    @Theory
    public void createPerson(final Integer money) {
        String name = "Вася Пупкин";
        Person person = new Person(name, money);
        Assert.assertEquals(person.getName(), name);
        Assert.assertEquals(person.getMoney(), money);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createPersonNegativeMoney() {
        new Person("Вася Пупкин", -300);
    }


}
