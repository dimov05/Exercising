package leetCode;

// Given the head of a linked list, rotate the list to the right by k places.
class ListNode {
      int val;
      ListNode21 next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode21 next) { this.val = val; this.next = next; }
  }

public class RotateList61 {
    public ListNode21 rotateRight(ListNode21 head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        int lenght = 1;
        ListNode21 current = head;
        while(current.next != null){
            lenght++;
            current = current.next;
        }
        k = lenght - (k%lenght);

        current.next = head;

        while (k > 0){
            current = current.next;
            k--;
        }
        head = current.next;
        current.next = null;

        return head;
    }
}
