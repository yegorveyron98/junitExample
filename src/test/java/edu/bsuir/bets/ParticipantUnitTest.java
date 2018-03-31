package edu.bsuir.bets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(Theories.class)
public class ParticipantUnitTest {

    @DataPoints("positive")
    public static List<Integer> winChancePositive = Arrays.asList(0, 30, 100);

    @DataPoints("negative")
    public static List<Integer> winChanceNegative = Arrays.asList(-1, 101);

    private Participant participant;

    @Before
    public void setUp() {
        participant = new Participant("team1", 10);
    }

    @Test
    @Theory
    public void setPositiveWinChance(@FromDataPoints("positive") Integer winChance) {
        participant.setWinChance(winChance);
        Assert.assertEquals(participant.getWinChance(), winChance);
    }

    @Test(expected = IllegalArgumentException.class)
    @Theory
    public void setNegativeWinChance(@FromDataPoints("negative") Integer winChance) {
        participant.setWinChance(winChance);
    }
}
