package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {

    @Test
    public void testWalrusEatsFood() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        walrus.addToStomach(food);
        assertTrue("Walrus should have eaten the food", walrus.hasEaten(food));
    }

    @Test
    public void testWalrusReceivesCorrectFood() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        walrus.addToStomach(food);
        assertTrue("Walrus should have received the exact food object", walrus.hasEaten(food));
    }

    @Test
    public void testOpeningCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();
        WalrusFood opened = opener.open(can);
        assertNotNull("Opening a can should return food", opened);
        assertSame("Returned food should be the same as canned food", food, opened);
    }

    @Test
    public void testFeedsWalrusAddsFood() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, can);
        assertTrue("Feeding the walrus should add food to its stomach", walrus.hasEaten(food));
    }

    @Test
    public void testWalrusDoesNotEatUnknownFood() {
        Walrus walrus = new Walrus();
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();
        walrus.addToStomach(food1);
        assertFalse("Walrus should not have eaten unrelated food", walrus.hasEaten(food2));
    }
}
