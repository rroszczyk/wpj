import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDrzewa {
    public void buildTree(Tree tree) {
        try {
            tree.add(100);
            tree.add(50);
            tree.add(340);
            tree.add(12);
            tree.add(358);
            tree.add(867);
            tree.add(999);
            tree.add(105);
            tree.add(208);
            tree.add(902);
            tree.add(1);
            tree.add(11);
            tree.add(111);
            tree.add(123);
            tree.add(218);
        }
        catch (Exception e) {
            System.out.println("Nie mogę przygotować drzewa do testów");
        }
    }
    @Test
    public void testMin() {
        Tree tree = new Tree();
        buildTree(tree);
        assertEquals(tree.getMin(), 1);
    }
    @Test
    public void testMax() {
        Tree tree = new Tree();
        buildTree(tree);
        assertEquals(tree.getMax(), 999);
    }

    @Test
    public void testAdd() {
        Tree tree = new Tree();
        buildTree(tree);

        Exception thrown = assertThrows(Exception.class, () -> tree.add(100));

        assertTrue(thrown.getMessage().contentEquals("Węzeł o takiej wartości już istnieje"));
    }
}
