class LFUCache {
    class Node{
        int key;
        int value;
        int freq;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }

    class DoubleLinkedList{
        Node head;
        Node tail;
        int size;
        DoubleLinkedList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
        }
        void addFirst(Node node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
            size++;
        }
        void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        Node removeLast(){
            if(size==0){
                return null;
            }
            Node node=tail.prev;
            remove(node);
            return node;
        }
        boolean isEmpty(){
            return size==0;
        }
    }
    HashMap<Integer,Node>keyMap;
    HashMap<Integer,DoubleLinkedList>freqMap;
    int capacity;
    int minfreq;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        keyMap=new HashMap<>();
        freqMap=new HashMap<>();
        minfreq=0;
    }

    
    public int get(int key) {
        if(!keyMap.containsKey(key)){
            return -1;
        }
        Node node =keyMap.get(key);
        increaseFrequency(node);
        return node.value;    
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        //key already exist
        if(keyMap.containsKey(key)){
            Node node=keyMap.get(key);
            node.value=value;
            increaseFrequency(node);
            return;
        }
        //Cache is full
        if(keyMap.size()==capacity){
            DoubleLinkedList list=freqMap.get(minfreq);
            Node removed=list.removeLast();
            keyMap.remove(removed.key);
        }
        Node node=new Node(key,value);
        keyMap.put(key,node);
        freqMap.computeIfAbsent(1,k->new DoubleLinkedList())
                .addFirst(node);
        minfreq=1;
    }
    private void increaseFrequency(Node node){
        int oldFreq=node.freq;
        DoubleLinkedList oldList=freqMap.get(oldFreq);
        oldList.remove(node);
        if(oldFreq==minfreq && oldList.isEmpty()){
            minfreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq,k->new DoubleLinkedList())
                .addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */