public class TreeMultiSet extends MultiSet {

    // this Tree object is a private instance variable for this class.
    private final Tree root = new Tree();

    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    @Override
    void add(int item) {
        root.insert(item);
    }

    /**
     * Remove the given item from this multiset.
     * If the item isn't in the multiset, do nothing.
     *
     * @param item the item to remove
     */
    @Override
    void remove(int item) {
        root.deleteItem(item);
    }

    /**
     * Check whether item is in this multiset.
     *
     * @param item the item to check if in this multiset
     * @return True if item is in this multiset and False otherwise.
     */
    @Override
    boolean contains(int item) {
        return root.contains(item);
    }

    /**
     * @return True if this multiset is empty.
     */
    @Override
    boolean isEmpty() {
        return root.isEmpty();
    }

    /**
     * Count how many times the given item appears in this multiset.
     *
     * @param item the item to count
     * @return How many times item appears in this multiset.
     */
    @Override
    int count(int item) {
        return root.count(item);
    }

    /**
     * @return How many items are in this multiset.
     */
    @Override
    int size() {
        return root.getSize();
    }
}
