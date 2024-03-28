public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        // Create a linked list with values 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        ListNode node8 = new ListNode(8, null);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // Print the original linked list
        printList(node1);

        printList(getKNodes(node1, 2));
    }

    // function that will check that a group of K element exists in the provided node

    private static boolean exists(ListNode head, int k) {
        int counter = 0;

        while (head != null && counter < k) {
            head = head.next;
            counter++;
        }

        return counter == k;
    }

    private static ListNode getKNodes(ListNode head, int k) {
        if (!exists(head, k)) {
            return null;
        }

        ListNode current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        // Disconnect the 3rd node from the rest of the list
     //   ListNode next = current.next;
        current.next = null;

        return head;
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
