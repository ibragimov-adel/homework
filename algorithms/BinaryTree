import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable> {

    private Node<T> root;
    private StringBuilder s;

    public BinaryTree(T value) {
        this.root = new Node<>(value);
    }

    public BinaryTree() {
        this.root = null;
    }

    public void add(T value) {
        root = addRec(root, value);
    }

    public String DFS() {
        s = new StringBuilder();
        return DFS(root);
    }

    private String DFS(Node<T> node) {
        if (root == null) {
            return s.toString();
        } else {
            s.append(node.value).append(" ");
            if (node.left != null)
                DFS(node.left);
            if (node.right != null)
                DFS(node.right);
        }
        return s.toString();
    }

    private String BFS() {
        s = new StringBuilder();
        if (root == null) {
            return s.toString();
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node node = queue.remove();

                s.append(node.value).append(" ");

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return s.toString();
    }

    private Node<T> addRec(Node<T> current, T value) {
        if (current == null)
            return new Node(value);

        if (value.compareTo(current.value) < 0)
            current.left = addRec(current.left, value);
        else if (value.compareTo(current.value) > 0)
            current.right = addRec(current.right, value);

        return current;
    }

    private class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.add(5);
        bt.add(2);
        bt.add(3);
        bt.add(7);
        bt.add(8);
        bt.add(0);
        bt.add(9);

        System.out.println(bt.DFS());
        System.out.println(bt.BFS());
    }

}
