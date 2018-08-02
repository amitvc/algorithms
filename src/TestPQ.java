import java.util.PriorityQueue;

public class TestPQ {

    public static class P implements Comparable<P>{
        public String name;
        public int age;
        public P(String string, int i) {
            this.name = string;
            this.age = i;
        }
        
        @Override
        public int compareTo(P o) {
            return - (Integer.valueOf(this.age).compareTo(Integer.valueOf(o.age)));
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<P> minPQ = new PriorityQueue<>();
        P p1 = new P("amit", 32);
        P p2 = new P("tanya", 32);
        P p3 = new P("paresh", 40);
        minPQ.offer(p1);
        minPQ.offer(p3);
        minPQ.offer(p2);
        System.out.println(minPQ.peek().name);
    }

}
