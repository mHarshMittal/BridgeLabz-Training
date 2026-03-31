package listmanager;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    ListManager manager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);

        assertEquals(1, list.size());
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        manager.removeElement(list, 10);

        assertEquals(1, list.size());
        assertFalse(list.contains(10));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15);

        assertEquals(2, manager.getSize(list));
    }
}
