class MyStack {
    public Queue<Integer>  q1;
    public Queue<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int val = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return val;
        
    }
    
    public int top() {
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int topVal = q1.peek();
        q2.add(q1.poll());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return topVal;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */