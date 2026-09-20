import java.util.LinkedList;
public class ThirdTask {
    public static void main(String[] args){
    Stack stack = new Stack(10);
    stack.push(4);
        stack.push(1);
        stack.push(300);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.size());

    }
}
class Stack{
    LinkedList<Integer>list = new LinkedList<>();
    int capacity;
    int top = -1;
    public Stack(int capacity){
        this.capacity = capacity;
    }
    void push(int element){
        if (list.size() >= capacity) {
            System.out.println("Stack capacity is full");
            System.exit(-1);
        }
        list.add(element);
        top++;
    }
    void pop(){
        if (list.isEmpty()) {
            System.out.println("Stack has no elements");
            System.exit(-1);
        }
        list.remove(top);
        top--;

    }
    boolean isEmpty(){
        return list.isEmpty();
    }
    int peek(){
        return list.get(top);
    }
    int size() {
        return list.size();
    }
}
