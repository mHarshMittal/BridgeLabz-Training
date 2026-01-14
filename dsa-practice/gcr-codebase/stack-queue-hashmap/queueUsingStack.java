/*Implement a Queue Using Stacks
Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed */

import java.util.stack;

class queueUsingStack{
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    //Enqueue operation Using Stack1
    public void enqueue(int data){
        stack1.push(data);
    }

    //perform Dequeue operation using stack2

    public int dequeue(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }


}
