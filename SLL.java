
/**
 * A very basic generic list node.
 * Since fields are public, they may be accessed
 * through an instance directly, like
 * 
 *   ListNode<String> n = new ListNode<String>();
 *   n.value = "hello";
 *   System.out.println(n.value);
 * 
 * Students: DO NOT MODIFY this class.
 */
class ListNode<E> {
    public E value;
    public ListNode<E> next;
}

/**
 * A SLL<E> wrapper class.
 * 
 * Students: MODIFY this class.
 */
class SLL<E> {
    ListNode<E> head;
    int count = 0;


    /**
     * Returns the length of the list.
     * Students: DO NOT MODIFY THIS METHOD.
     * @return The length as an int.
     */
    public int size() {
        return count;
    }
    /**
     * Returns the ListNode of the element at the given
     * index. Returns null if the index is out of bounds.
     *
     * @pre 0 <= index < size()
     * @param index
     * @return The node, or null on failure.
     */
    public ListNode<E> nodeAt(int index) {
        //assert index >= 0 && index < size(SSLL<E> sll);
        assert index >= 0 && index < size();
        ListNode<E> finger = head;
        if (head == null) {
            return null;
        }
        if (index > size()) {
            return null;
        } else {
            for (int i = 0; i < index; i++) {
                finger = finger.next;
            }
        }
        return finger;
    }
    /**
     * Returns the head
     * @param sll - our Singly Linked List
     * @return - the node at our specified index
     */
    public  ListNode<E> getHead(SLL<E> sll){
        return nodeAt(0);
    }
    /**
     * Swaps the values of our head and the node
     * @param node
     * @param value
     * @return
     */
    public ListNode<E> setHead(ListNode<E> node, E value) {
            node.value = value;
        if (head == null) {
            head = node;
            return head;
        }
        ListNode<E> ogHead = nodeAt(0);
        head = node;
        head.next = ogHead;
        return head;
    }
   /**
     * Insert value at location.
     * @post adds ith entry of list to value o
     * @param index index of this new value
     * @param value to be stored
     */
    public void add(int index, E value) {
        ListNode<E> head = new ListNode<E>();
         if (index == 0) {
            ListNode<E> oldHead = nodeAt(0);
            setHead(head, value);
            head.value = value;
            head.next = oldHead;
        } else if (index > 0) {
            ListNode<E> parent = nodeAt(0);
            for (int i = 0; i < index - 1; i++) {
                 parent = parent.next;
             }
            ListNode<E> afterParent = parent.next;
            ListNode<E> newNode = new ListNode<E>();
            newNode.value = value;
            newNode.next = afterParent;
            parent.next = newNode;
        }  
    }

	
	/**
	 * A simple toString method.
	 */
	public String toString() {
        String s = "[";
        head = nodeAt(0);
        ListNode<E> finger = head;
        while (finger != null) {
            s += finger.value.toString();
            if (finger.next != null) {
                s += ", ";
            }
            finger = finger.next;
        }
        return s + "]";
    }
    /**
     * Inserts an element into the middle of the list.
     * The middle is defined as size() / 2.
     * @param value An element to insert.
     */
    public void insertIntoMiddle(E value) {
        int c = size();
        int mid = c / 2;
        add(mid, value);
        System.out.println();
        count = size() + 1;
 
    }

    /**
     * For testing.  Change this however you wish, however we will test
     * your code using the tests shown below.
     * @param args [Ignored]
     */
    public static void main(String[] args) {
        SLL<Integer> sll = new SLL<Integer>();
    //     ListNode<Integer> ln = new ListNode<>();
    //     ListNode<Integer> ln1 = new ListNode<>();
    //     sll.add(0, 2);
    //     System.out.println(sll.nodeAt(0));
    //     sll.add(1, 3);
    //     sll.setHead(ln, 5);
    //     sll.setHead(ln1, 7);
    //     System.out.println(sll);
    //    sll.add(3, 25);
    //     System.out.println(sll.count);
        
    //     System.out.println(sll.size());
        System.out.println(sll);
        // // list is empty: []
        sll.insertIntoMiddle(1);
        //System.out.println(sll.nodeAt(0));
        ///System.out.println(sll.count);
        System.out.println(sll);
        // // list should contain: [1]
        sll.insertIntoMiddle(2);
        System.out.println(sll);
        ////System.out.println(sll.nodeAt(0));
        ///System.out.println(sll.nodeAt(1));
        ///System.out.println(sll.count);
        // // list should contain: [2, 1]
        sll.insertIntoMiddle(3);
        ////System.out.println(sll.nodeAt(0));
        ///System.out.println(sll.nodeAt(1));
        ///System.out.println(sll.nodeAt(2));
        ///System.out.println(sll.count);
        System.out.println(sll);
        // // list should contain: [2, 3, 1]
        sll.insertIntoMiddle(4);
        System.out.println(sll);
        // // list should contain: [2, 4, 3, 1]
        sll.insertIntoMiddle(5);
        System.out.println(sll);
        // // list should contain: [2, 4, 5, 3, 1]

    }

    
}