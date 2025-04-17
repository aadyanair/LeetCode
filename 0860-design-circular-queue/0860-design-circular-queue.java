class MyCircularQueue {
    int[] arr;
    int front, size;
    int capacity;
    
    public MyCircularQueue(int k) {
        arr = new int[k];
        capacity = k;
        front = 0;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(size==capacity){
            return false;
        } else{
            int rear = (front + size) % capacity;
            arr[rear] = value;
            size++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(size==0){
            
            return false;
        }
        int res = arr[front];
        front = (front+1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(size==0){
            return -1;
        }else{
            return arr[front];
        }
    }
    
    public int Rear() {
        if (size==0){
            return -1;
        }else{
            int rearIndex = (front + size - 1)% capacity;
            return arr[rearIndex];
        }
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */