
public class ReverseLL {
    public static class Node {
        public int val;
        public Node next;
    }
    
    
    public static Node rev(Node current, Node previous) {
        if(current.next == null) {
            return current;
        }
        Node prev = rev(current.next, current);
        prev.next = current;
        current.next = previous;
        return current;
    }
    
    public static void rev(Node root) {
        if(root == null) return;
        rev(root.next);
        System.out.println(root.val);
    }
    
    // 1->2->3->null
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node n1 = new Node();
        n1.val = 1;
       
        
        
        Node n2 = new Node();
        n2.val = 2;
        
        
        Node n3 = new Node();
        n3.val = 3;
        
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        
        rev(n1);
        
        rev(n1, null);
        System.out.println("");
        
    }

}
