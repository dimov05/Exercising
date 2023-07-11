package old.leetCode;

//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
class ListNode21 {
    int val;
    ListNode21 next;

    ListNode21() {
    }

    ListNode21(int val) {
        this.val = val;
    }

    ListNode21(int val, ListNode21 next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedLists21 {
    public ListNode21 mergeTwoLists(ListNode21 list1, ListNode21 list2) {
        if(list1 != null && list2 != null){
            if(list1.val < list2.val){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if(list1 == null){
            return list2;
        }
        return list1;
    }
}
