public class Easy_ReverseLinedListInPlace {

    public static void main(String[] args) {
        // Create a linked list with values 1 -> 2 -> 3 -> 4 -> 5
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // Print the original linked list
        printList(node1);

        // Reverse the linked list
        ListNode reversedHead = revertList(node1);

        // Print the reversed linked list
        printList(reversedHead);

    }

    private static ListNode revertList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev; /// that's all, the rest is for the next iteration

            prev = current;
            current = temp;

        }

        // at the end prev points to the head;
        return prev;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
