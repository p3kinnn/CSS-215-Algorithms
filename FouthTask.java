import java.util.LinkedList;

public class FouthTask {
    public static void main(String[] args){
    Queue queue = new Queue(7);
    queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        queue.dequeue();
        System.out.println(queue.peek());
        System.out.println(queue.size());

    }
}
class Queue{
    LinkedList<Integer>list = new LinkedList<>();
    int capacity;
    int rear = -1;
    int front = 0;
    public Queue(int capacity){
        this.capacity = capacity;
    }
    void enqueue(int element){
        if (list.size()>= capacity) {
            System.out.println("Queue capacity is full");
            System.exit(-1);
        }
        list.add(element);
        rear++;
    }
    void dequeue(){
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(-1);
        }
        list.remove(front);
        rear--;
    }
    boolean isEmpty(){
        return list.isEmpty();
    }
    int size(){
        return list.size();
    }
    int peek(){
        return list.get(front);
    }

}


