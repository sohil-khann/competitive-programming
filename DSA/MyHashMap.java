//class MyHashMap<K, V> {
//    private class Node {
//        K key;
//        V value;
//        boolean isDeleted;
//
//        Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//            this.isDeleted = false;
//        }
//    }
//
//    private int capacity = 16;
//    private int size = 0;  //Node[] n=new Node[Capacity];
//    private Node[] table;
//
//    public MyHashMap() {
//        table = new Node[capacity];
//    }
//
//    private int hash(K key) {
//        return Math.abs(key.hashCode())%capacity;
//    }
//
//    public void put(K key, V value) {
//        int index = hash(key);
//
//        while (table[index] != null && !table[index].isDeleted) {
//            if (table[index].key.equals(key)) {
//                table[index].value = value;  // Update
//                return;
//            }
//            index = (index + 1) % capacity;
//        }
//
//        table[index] = new Node(key, value);
//        size++;
//
//        if ((double) size / capacity >= 0.7) {
//            resize();
//        }
//    }
//
//    public V get(K key) {
//        int index = hash(key);
//
//        while (table[index] != null) {
//            if (!table[index].isDeleted && table[index].key.equals(key)) {
//                return table[index].value;
//            }
//            index = (index + 1) % capacity;
//        }
//
//        return null;
//    }
//
//    public void remove(K key) {
//        int index = hash(key);
//
//        while (table[index] != null) {
//            if (!table[index].isDeleted && table[index].key.equals(key)) {
//                table[index].isDeleted = true;
//                size--;
//                return;
//            }
//            index = (index + 1) % capacity;
//        }
//    }
//
//    public boolean containsKey(K key) {
//        return get(key) != null;
//    }
//
//    private void resize() {
//        Node[] oldTable = table;
//        capacity *= 2;
//        size = 0;
//        table = new Node[capacity];
//
//        for (Node node : oldTable) {
//            if (node != null && !node.isDeleted) {
//                put(node.key, node.value);
//            }
//        }
//    }
//
//    public void display() {
//        for (int i = 0; i < capacity; i++) {
//            if (table[i] != null && !table[i].isDeleted) {
//                System.out.println(i + ": " + table[i].key + " = " + table[i].value);
//            }
//        }
//    }
//}