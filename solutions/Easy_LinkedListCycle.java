public class Easy_LinkedListCycle {


    // 141. Given head, the head of a linked list, determine if the linked list has a cycle in it.
    // There is a cycle in a linked list if there is some node in the list that can be reached again by
    // continuously following the next pointer. Internally, pos is used to denote the index of the node that
    // tail's next pointer is connected to. Note that pos is not passed as a parameter.
    //
    //Return true if there is a cycle in the linked list. Otherwise, return false.
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        // use fast and slow pointer approach
        // slow makes one step
        // fast makes 2 steps
        // we need to compare the notes


        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;

    }

    private record ListNode(int val, ListNode next){};
}
