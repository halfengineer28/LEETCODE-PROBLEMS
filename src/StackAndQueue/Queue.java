package StackAndQueue;

import java.util.ArrayList;
import java.util.List;


// Basic implementation of Queue using ArrayList;
public class Queue {
    private int start;
    private List<Integer> data;

    public Queue() {
        start = 0;
        data = new ArrayList<>();
    }
    public boolean add(int x){
        data.add(x);
        return true;
    }
    public boolean remove(){
        if (data.isEmpty() == true){
            return false;
        }
        start++;
        return true;
    }

    public boolean isEmpty(){
        return start >= data.size();
    }
    public  int top(){
        return data.get(start);
    }
}
