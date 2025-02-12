package pgdp;
import pgdp.datastructures.lists.RecIntList;

import static pgdp.TestAPI.RecList;
import static pgdp.TestAPI.assertListEquals;

import org.junit.jupiter.api.*;

public class ZipTest {
    public static RecIntList l1;
    public static RecIntList l2;

    @Test
    @DisplayName("Should zip empty arrays")
    public void empty() {
        l1 = RecList();
        l2 = RecList();

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "");
    }

    @Test
    @DisplayName("Should zip example arrays")
    public void example() {
        l1 = RecList(1,3,5,7,8);
        l2 = RecList(2,4,6);

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 2, 3, 4, 5, 6, 7, 8");
    }

    @Test
    @DisplayName("Should zip when second array is empty")
    public void only_one() {
        l1 = RecList(1,3,5,7,8);
        l2 = RecList();

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 3, 5, 7, 8");
    }

    @Test
    @DisplayName("Should zip when first array is empty")
    public void only_two() {
        l1 = RecList();
        l2 = RecList(1,3,5,7,8);

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 3, 5, 7, 8");
    }

    @Test
    @DisplayName("Should zip when first array is smaller by one")
    public void one_smaller() {
        l1 = RecList(1,3,5);
        l2 = RecList(2,4,6,8);

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 2, 3, 4, 5, 6, 8");
    }

    @Test
    @DisplayName("Should zip when second array is smaller by one")
    public void two_smaller() {
        l1 = RecList(1,3,5,8);
        l2 = RecList(2,4,6);

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 2, 3, 4, 5, 6, 8");
    }

    @Test
    @DisplayName("Should zip when first array is smaller")
    public void one_great_smaller() {
        l1 = RecList(1,3,5);
        l2 = RecList(2,4,6,8,9,9,9);

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 2, 3, 4, 5, 6, 8, 9, 9, 9");
    }

    @Test
    @DisplayName("Should zip when second array is smaller")
    public void two_great_smaller() {
        l1 = RecList(1,3,5,8,9,9,9);
        l2 = RecList(2,4,6);

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 2, 3, 4, 5, 6, 8, 9, 9, 9");
    }

    @Test
    @DisplayName("Should zip when both arrays contain one element.")
    public void equals_one() {
        l1 = RecList(1);
        l2 = RecList(2);

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 2");
    }

    @Test
    @DisplayName("Should zip when both arrays are of equal length")
    public void equal() {
        l1 = RecList(1,3,5,7,9);
        l2 = RecList(2,4,6,8,10);

        RecIntList.zip(l1, l2);

        assertListEquals(l1, "1, 2, 3, 4, 5, 6, 7, 8, 9, 10");
    }
}
