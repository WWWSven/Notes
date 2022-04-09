import java.math.BigInteger;

public class _876链表的中间结点 {
    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     */
    public static void main(String[] args) {
        /**
         * 输入：[1,2,3,4,5,6]
         * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
         */
        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5,l6);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);


        ListNode listNode = middleNode(l1);
        System.out.println(listNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode temp = head; //保存一个头节点
        int len=0;
        while (head!=null){
            len++;
            head = head.next;
        }
        int middle = len/2+1;
        // 记录当前访问到第几个元素
        int i = 0;
        head = temp;
        while (head!=null){
            i++;
            if (i==middle){ // 是中间元素
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
