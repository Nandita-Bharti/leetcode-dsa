//Approach 1: Two Stacks
// class MinStack {
//     Stack<Integer> minStack;
//     Stack<Integer> st;

//     public MinStack() {
//         st =  new Stack<>();
//         minStack =  new Stack<>();
//     }
    
//     public void push(int val) {
//         st.push(val);
//         if(minStack.size() == 0 || val < minStack.peek()) minStack.push(val);
//         else minStack.push(minStack.peek());
//     }
    
//     public void pop() {
//         st.pop();
//         minStack.pop();
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }


//Single Stack with Pairs (Object-Oriented)
class MinStack {
    private Stack<int[]> stack; // stores [value, current_min]

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currentMin = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, currentMin});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

