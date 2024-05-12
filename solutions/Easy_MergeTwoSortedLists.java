class Easy_MergeTwoSortedLists {
    public static void main(String[] args) {
        
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1, null); // how to init
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;

        }

        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;

    }


        private static class ListNode {
        int val;
        ListNode next;


        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

            @Override
            public String toString() {
                return "ListNode{" +
                        "val=" + val +
                        ", next=" + next +
                        '}';
            }
        }
}