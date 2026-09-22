import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * A recursive tree of integers, translated from the Tree class in
 * python/adts.py. An empty tree has a null root and no subtrees.
 */
public class Tree {
    private static final Random RANDOM = new Random();

    private Integer root;
    private final List<Tree> subtrees;

    public Tree() {
        this.root = null;
        this.subtrees = new ArrayList<>();
    }

    public Tree(int root) {
        this.root = root;
        this.subtrees = new ArrayList<>();
    }

    public Tree(Integer root, List<Tree> subtrees) {
        this.root = root;
        this.subtrees = subtrees == null ? new ArrayList<>() : new ArrayList<>(subtrees);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        int size = 1;
        for (Tree subtree : subtrees) {
            size += subtree.getSize();
        }
        return size;
    }

    public int count(int item) {
        if (isEmpty()) {
            return 0;
        }
        int occurrences = root == item ? 1 : 0;
        for (Tree subtree : subtrees) {
            occurrences += subtree.count(item);
        }
        return occurrences;
    }

    public boolean contains(int item) {
        if (isEmpty()) {
            return false;
        }
        if (root == item) {
            return true;
        }
        for (Tree subtree : subtrees) {
            if (subtree.contains(item)) {
                return true;
            }
        }
        return false;
    }

    /** Insert an item using the same random branching rule as the Python tree. */
    public void insert(int item) {
        if (isEmpty()) {
            root = item;
        } else if (subtrees.isEmpty() || RANDOM.nextInt(3) == 2) {
            subtrees.add(new Tree(item));
        } else {
            subtrees.get(RANDOM.nextInt(subtrees.size())).insert(item);
        }
    }

    /** Remove one occurrence, returning whether an item was removed. */
    public boolean deleteItem(int item) {
        if (isEmpty()) {
            return false;
        }
        if (root == item) {
            deleteRoot();
            return true;
        }
        for (int i = 0; i < subtrees.size(); i++) {
            Tree subtree = subtrees.get(i);
            if (subtree.deleteItem(item)) {
                if (subtree.isEmpty()) {
                    subtrees.remove(i);
                }
                return true;
            }
        }
        return false;
    }

    private void deleteRoot() {
        if (subtrees.isEmpty()) {
            root = null;
        } else {
            Tree chosen = subtrees.remove(subtrees.size() - 1);
            root = chosen.root;
            subtrees.addAll(chosen.subtrees);
        }
    }

    /** Insert one item under the first matching parent in a preorder search. */
    public boolean insertChild(int item, int parent) {
        if (isEmpty()) {
            return false;
        }
        if (root == parent) {
            subtrees.add(new Tree(item));
            return true;
        }
        for (Tree subtree : subtrees) {
            if (subtree.insertChild(item, parent)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> leaves() {
        List<Integer> result = new ArrayList<>();
        if (isEmpty()) {
            return result;
        }
        if (subtrees.isEmpty()) {
            result.add(root);
        } else {
            for (Tree subtree : subtrees) {
                result.addAll(subtree.leaves());
            }
        }
        return result;
    }

    /** Return 0.0 for an empty tree, as in the Python implementation. */
    public double average() {
        if (isEmpty()) {
            return 0.0;
        }
        long[] totalAndCount = averageHelper();
        return (double) totalAndCount[0] / totalAndCount[1];
    }

    private long[] averageHelper() {
        if (isEmpty()) {
            return new long[] {0, 0};
        }
        long total = root;
        long count = 1;
        for (Tree subtree : subtrees) {
            long[] child = subtree.averageHelper();
            total += child[0];
            count += child[1];
        }
        return new long[] {total, count};
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        appendIndented(result, 0);
        return result.toString();
    }

    private void appendIndented(StringBuilder result, int depth) {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            result.append("  ");
        }
        result.append(root).append('\n');
        for (Tree subtree : subtrees) {
            subtree.appendIndented(result, depth + 1);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tree)) {
            return false;
        }
        Tree that = (Tree) other;
        return Objects.equals(root, that.root) && subtrees.equals(that.subtrees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root, subtrees);
    }
}
