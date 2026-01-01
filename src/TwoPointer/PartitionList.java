package TwoPointer;

public class PartitionList {
    public static void main(String[] args) {

    }
    public ListNode partition (ListNode head, int x){
        ListNode dummy = new ListNode(-1);
        ListNode LesserThanX = new ListNode(-1);
        ListNode GreaterThanX = new ListNode(-1);
        ListNode temp = head;
        ListNode lesser = LesserThanX;
        ListNode greater = GreaterThanX;

        while (temp != null && temp.next != null){
            if (temp.val < x){
                lesser.next = temp;
                temp = temp.next;
                lesser = lesser.next;
            }else {
                greater.next = temp;
                temp = temp.next;
                greater = greater.next;
            }

        }
        greater.next = null;
        lesser.next = GreaterThanX.next;
        return LesserThanX.next;
    }
}
