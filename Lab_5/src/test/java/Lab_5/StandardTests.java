package Lab_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StandardTests {

    private AdvancedArrayListOps ops;

    @BeforeEach
    void setUp() {
        ops = new AdvancedArrayListOps();
    }

    @Test
    void testAppendAndSearch() {
        ops.append("Sanjay");
        ops.append("Madhukar");
        assertTrue(ops.Search("Sanjay"), "List should contain 'Sanjay'");
        assertFalse(ops.Search("grape"), "List should not contain 'grape'");
    }

    @Test
    void testInsert() {
        ops.append("one");
        ops.append("three");
        ops.insert("sanjay", 1);
        ArrayList<String> startsWithT = ops.Starts("t");
        assertTrue(startsWithT.contains("two"), "Inserted element should be found at index 1");
    }

    @Test
    void testAscendingSortList() {
        ops.append("dog");
        ops.append("apple");
        ops.append("cat");
        ops.AscendingSortList();
        ArrayList<String> sorted = ops.Starts("");
        assertEquals("apple", sorted.get(0));
        assertEquals("cat", sorted.get(1));
        assertEquals("dog", sorted.get(2));
    }

    @Test
    void testDescendingSortList() {
        ops.append("dog");
        ops.append("apple");
        ops.append("cat");
        ops.DescendingSortList();
        ArrayList<String> sorted = ops.Starts("");
        assertEquals("dog", sorted.get(0));
        assertEquals("cat", sorted.get(1));
        assertEquals("apple", sorted.get(2));
    }

    @Test
    void testRemoveDuplicate() {
        ops.append("java");
        ops.append("python");
        ops.append("java");
        ArrayList<String> uniqueList = ops.RemoveDuplicate();
        assertEquals(2, uniqueList.size(), "Duplicate 'java' should be removed");
    }

    @Test
    void testRegexMatch() {
        ops.append("hello");
        ops.append("HELLOworld");
        ops.append("bye");
        ArrayList<String> matches = ops.match("hello");
        assertTrue(matches.contains("hello"));
        assertTrue(matches.contains("HELLOworld"));
        assertFalse(matches.contains("bye"));
    }
}

