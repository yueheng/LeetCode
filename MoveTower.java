import java.util.*;
public class HelloWorld{
     public static void main(String []args){
        System.out.println("Hello World");
        Tower[] towers = new Tower[3];
        int n = 20;
        for(int i = 0; i < 3; i++) towers[i] = new Tower(i);
        for(int i = n; i > 0; i--) towers[0].add(i);
        towers[0].moveDisks(n, towers[2], towers[1]);
     }    
}

class Tower {
    public Stack<Integer> disks;
    public int id;
    public Tower(int id) {
        disks = new Stack<Integer>();
        this.id = id;
    }
    public void add(int value) {
        disks.push(value);
    }
    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.disks.push(top);
    }
    public void moveDisks(int n, Tower des, Tower buffer) {
        if(n > 0) {
            moveDisks(n-1, buffer, des);
            moveTopTo(des);
            System.out.println("move " + des.disks.peek() + " from tower " + this.id + " to tower " + des.id);
            buffer.moveDisks(n-1, des, this);
        }
    }
}
