import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
       solution.reverseKGroup(head,3);
    }
}


class Solution {



    public ListNode detectCycle(ListNode head) {
        if (head==null){
            return null;
        }

        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast.next==null||fast.next.next==null) {
            return null;
        }

        ListNode res=head;
        while (res!=slow){
            res=res.next;
            slow=slow.next;
        }
        return res;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     return combine(list1,list2);
    }

    public ListNode combine(ListNode list1, ListNode list2){
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first=new ListNode();
        ListNode next=first;
        combine(next,l1,l2,0);
        return first.next;
    }
    public void combine(ListNode next,ListNode l1,ListNode l2, int sum){
        if(l1==null&&l2==null){
            if(sum==0){
                next.next=null;
            }else {
                next.next=new ListNode(1);
                next.next.next=null;
            }
        }else {
            int a= l1==null ? 0: l1.val;
            int b= l2==null ? 0: l2.val;

            sum+=a+b;
            next.next=new ListNode(sum%10);
            sum= sum>=10 ? 1:0;

            l1= l1!=null ? l1.next:null;
            l2= l2!=null ? l2.next:null;
            combine(next.next, l1,l2,sum);
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left=head;
        ListNode right=head;

        for (int i = 0; i < n|| right==null; i++) {
            right=right.next;
        }

        ListNode pre=null;
        while (right!=null){
            pre=left;
            left=left.next;
            right=right.next;
        }

        if(head==left){
            head=head.next;
        }else {
            pre.next=left.next;
        }

        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode first=new ListNode();
        ListNode pre=first;
        ListNode next=head;

        while (next!=null&&next.next!=null){
            ListNode left=next;
            ListNode right=next.next;
            next=right.next;

            pre.next=right;
            right.next=left;

            pre=left;

        }
        return first.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode first=new ListNode();
        ListNode pre=first;
        ListNode left=head;
        ListNode right=toNextNode(left,k);
        while (right!=null){
            ListNode next=right.next;

            pre.next=right;
            reverseList(left,right);

            pre=left;
            left=next.next;
            right=toNextNode(left,k);
        }
        pre.next=left;
        return first.next;
    }

    public  ListNode toNextNode(ListNode left,int k){
        ListNode right=left;
        while(k>1&&right!=null){
            right=left.next;
            k--;
        }
        return  right;
    }

    public void reverseList(ListNode left,ListNode right) {
        ListNode new_next=left;
        ListNode new_head=left.next;

        while(new_next!=right){
            ListNode next=new_head.next;
            new_head.next=new_next;
            new_next=new_head;
            new_head=next;
        }
    }


    Map<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        if(!map.containsKey(head)){
            Node node=new Node(head.val);
            map.put(head,node);

            node.next=copyRandomList(head.next);
            node.random=copyRandomList(head.random);
        }
        return map.get(head);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode first=new ListNode();
        ListNode next=first;
       return first;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        for (int i = 0; i <= nums.length-k; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = i; j <i+k ; j++) {
                if(max<nums[j]){
                    max=nums[j];
                }
            }
            res[i]=max;
        }
        return res;
    }



}