public class Tree {
    private Node root;
    public Tree() {
        this.root = null;
    }
    public Node add(Integer value) throws Exception {
        Node node = new Node(value);
        if (root == null) {
            this.root = node;
            return node;
        }
        Node current = this.root;
        Node parent = null;
        while (true) {
            parent = current;
            if (node.value < parent.value) {
                current = parent.left;
                if (current == null) {
                    parent.left = node;
                    return node;
                }
            } else if (node.value > parent.value) {
                current = parent.right;
                if (current == null) {
                    parent.right = node;
                    return node;
                }
            } else {
                throw new Exception("Węzeł o takiej wartości już istnieje");
            }
        }
    }
    public void display() {
        display(this.root);
        System.out.println();
    }
    private void display(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            display(root.left);
            display(root.right);
        }
    }
    public void displayAsc() {
        displayAsc(this.root);
        System.out.println();
    }
    private void displayAsc(Node root) {
        if (root != null) {
            displayAsc(root.left);
            System.out.print(root.value + " ");
            displayAsc(root.right);
        }
    }
    public void displayDsc() {
        displayDsc(this.root);
        System.out.println();
    }
    private void displayDsc(Node root) {
        if (root != null) {
            displayDsc(root.right);
            System.out.print(root.value + " ");
            displayDsc(root.left);
        }
    }
    public Integer getMin() {
        if (root != null) {
            return getMin(root);
        } else {
            return Integer.MIN_VALUE;
        }
    }
    private Integer getMin(Node node) {
        if (node.left != null) {
            return getMin(node.left);
        } else {
            return node.value;
        }
    }
    public Integer getMax() {
        return (root != null)?getMax(root):Integer.MAX_VALUE;
    }
    private Integer getMax(Node node) {
        return (node.right != null)?getMax(node.right):node.value;
    }
    public Integer getDepth() {
        return getDepth(this.root, 0);
    }
    private Integer getDepth(Node node, Integer counter) {
        if (node == null) {
            return counter;
        } else {
            return Integer.max(getDepth(node.left, counter+1), getDepth(node.right, counter+1));
        }
    }
    public Integer getCount() {
        return getCount(this.root);
    }
    private Integer getCount(Node node) {
        if (node == null) {
            return 0;
        } else {
            return getCount(node.left) + 1 + getCount(node.right);
        }
    }
    public Integer getValue()
    {
        return 100;
    }
}
