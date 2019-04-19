package eg.edu.alexu.csd.datastructure.linkedList;

public class SLinkedList implements ILinkedList {

    public Node head;

    public Node tail;
 
    public SLinkedList() { 
    }

    public void add( int index,  Object element) { 
        Node newNode = new Node(element);
        Node temp = head;

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0 && size() == 0) {
            head = newNode;
            tail = newNode;

        } else if (index == 0) {
            newNode.Next = head ;
            head = newNode;
        } else if (index == size()) {
            add(element);
        } else {
            for (int i = 1; i < index; i++) {

                temp = temp.Next;
                if (temp == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            newNode.Next = temp.Next;
            temp.Next = newNode;
        }

    }

    public void add( Object element) { 
        Node newNode = new Node(element);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.Next = newNode;
            tail = newNode;
        }
    }

    public Object get( int index) {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index > (size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node temp;
        temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.Next;
        }

        Object output = temp.Data ; 
        
        return output;

    }

    public void set(int index, Object element) { 

        Node temp;
        temp = head;

        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index > (size() - 1)) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            temp = temp.Next;
        }
        temp.Data = element;
    }

    public void clear() {

        head = null;
        tail = null;
    }

    public boolean isEmpty() {

        return (head == null);

    }

    public void remove( int index) { 

        Node temp;
        temp = head;

        if (index > (size() - 1) || (index == 0 && size() == 0) || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0 && size() == 1) {
            head = head.Next;
            tail = null;
        } else if (index == 0) {
            head = head.Next;
        } else if (index < size() - 1) {
            for (int i = 1; i < index; i++) {
                temp = temp.Next;
            }
            temp.Next = temp.Next.Next;

        } else if (index == size() - 1) {
            for (int i = 1; i < index; i++) {
                temp = temp.Next;
            }
            tail = temp;
            temp.Next = null;
        }
    }

    public int size() { 

        int count = 1;
        Node temp;
        temp = head;

        if (isEmpty()) {
            return 0;
        } else {
            while (temp.Next != null) {
                count++;
                temp = temp.Next;
            }
            return count;
        }
    }

    public ILinkedList sublist( int fromIndex,  int toIndex) {

        SLinkedList subList = new SLinkedList();
        for (int i = fromIndex; i <= toIndex; i++) {

            subList.add(get(i));

        }
        return subList;

    }
    public boolean contains( Object o) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (!o.equals(temp.Data) && temp.Next != null) {
            temp = temp.Next;
        }
        return o.equals(temp.Data);
    }

}