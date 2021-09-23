public class PriorityQueue<V> {
        private Node<V> head = null;
        private Node<V> tail = null;
        private int size = 0;

        public PriorityQueue() {}

        public int getHeadPriority() {
            return head.priority;
        }

        public int getTailPriority() {
            return tail.priority;
        }

        public int getSize() {
            return size;
        }

        public Node<V> peek() {
            return head;
        }

        public Node<V> pop(){
            Node<V> temp = head;
            head = head.next;
            size--;
            return temp;
        }

        public void add(V value, int priority) {
            Node<V> node = new Node<>(value, priority);
            size++;
            if(head == null) {
                head = node;
                tail = node;
                return;
            }
            tail.next = node;
            node.prev = tail;
            tail = node;
            sort();
        }

        public void print(){
            iteratePrint(head);
        }

        private void iteratePrint(Node<V> head) {
            if(head != null){
                System.out.println("[Priority: " + head.priority + " Value: " + head.value + "]");
                if(head.next != null){
                    iteratePrint(head.next);
                }
            }
        }

        private Node<V> getByIndex(int i) {
            int count = 0;
            Node<V> current = head;
            while (current != null) {
                if (count == i) {
                    return current;
                }
                count++;
                current = current.next;
            }
            return null;
        }

        private void sort() {
            int arrLength = size;
            buildMaxHeap(arrLength);
            for (int i = arrLength - 1; i > 0; i--) {
                swap(0, i);
                heapify(i, 0);
            }
        }

        private void buildMaxHeap(int length) {
            for (int i = length / 2 - 1; i >= 0; i--) {
                heapify(length, i);
            }
        }

        private void heapify(int arrLength, int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int maxAsRoot = i;

            if(left < arrLength && getByIndex(left).priority < getByIndex(maxAsRoot).priority) {
                maxAsRoot = left;
            }

            if(right < arrLength && getByIndex(right).priority < getByIndex(maxAsRoot).priority) {
                maxAsRoot = right;
            }

            if(maxAsRoot != i) {
                swap(maxAsRoot, i);
                heapify(arrLength , maxAsRoot);
            }
        }

        private void swap(int index1, int index2) {
            Node<V> tmp1 = getByIndex(index1);
            Node<V> tmp2 = getByIndex(index2);
            assert tmp1 != null;
            V tmpV = tmp1.value;
            int tmpP = tmp1.priority;
            assert tmp2 != null;
            tmp1.value = tmp2.value;
            tmp1.priority = tmp2.priority;
            tmp2.value = tmpV;
            tmp2.priority = tmpP;
        }

    }

    class Node<V>{
        V value;
        int priority;
        Node<V> prev;
        Node<V> next;

        Node(V value, int priority){
            this.value = value;
            this.priority = priority;
            this.prev = null;
            this.next = null;
        }
    }

