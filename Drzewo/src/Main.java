public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

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
        } catch (Exception e) {
            System.out.println(e);
        }
        tree.display();
        tree.displayAsc();
        tree.displayDsc();

        System.out.println("Wartość minimalna: " + tree.getMin());
        System.out.println("Wartość maksymalna: " + tree.getMax());
        System.out.println("Głębokość drzewa: " + tree.getDepth());
        System.out.println("Liczba elementów: " + tree.getCount());
    }
}