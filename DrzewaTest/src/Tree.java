public class Tree {
    Node root;

    public void add(int value) {
        root = add(root, value);
    }

    private Node add(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = add(current.left, value);
        } else if (value > current.value) {
            current.right = add(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node current) {
        return current == null ? 0 : getSize(current.left) + 1 + getSize(current.right);
    }

    public boolean containsNode(int value) {
        return containsNode(root, value);
    }

    private boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNode(current.left, value)
                : containsNode(current.right, value);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // No children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Only 1 child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            // Two children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = delete(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = delete(current.left, value);
            return current;
        }

        current.right = delete(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            print(node.value);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            print(node.value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            print(node.value);
        }
    }

    private void print(int value) {
        System.out.print(" " + value);
    }
}
