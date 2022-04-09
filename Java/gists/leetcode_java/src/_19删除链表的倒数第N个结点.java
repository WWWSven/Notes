public class _19删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        /**
         * 输入：head = [1,2,3,4,5], n = 2
         * 输出：[1,2,3,5]
         */
        // ListNode l5 = new ListNode(5);
        // ListNode l4 = new ListNode(4,l5);
        // ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1,l2);
        int n = 2;
        ListNode listNode = removeNthFromEnd(l1,n);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = head;
        int len = 0; // 链表长度
        while (head!=null){
            len++;
            head=head.next;
        }
        head = tempHead; // 头指针回退到头结点
        int target = len-n;
        if (target<1) {
            // 处理边界条件：[1],n=1,target=0,要删除头节点,target也可能为负数
            head=head.next;
            return head;
        }
        int temp = 1;// 当前访问到第几个
        while (head!=null){
            if (temp==target) {
                head.next = head.next.next; // 跳过一个元素
            }
            temp++;
            head=head.next;
        }
        return tempHead; // 返回头节点
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
