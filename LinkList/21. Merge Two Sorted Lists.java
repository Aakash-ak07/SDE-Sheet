// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.
// Example 1:

// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//using recursion
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)   return list2;   
        if(list2 == null)   return list1;   
        if(list1.val < list2.val)
        {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else
        {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}


// using itrative method
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        else
        {
            if(list1.val <= list2.val)
            {
                head = list1;
                list1 = list1.next;
            }
            else
            {
                head = list2;
                list2 = list2.next; 
            }
            ListNode temp = head;
            while(list1 != null && list2 != null)
            {
                if(list1.val < list2.val)
                {
                    temp.next = list1;
                    temp = temp.next;
                    list1 = list1.next;
                }
                else
                {
                    temp.next = list2;
                    temp = temp.next;
                    list2 = list2.next;
                }
            }
            if(list1 == null)
                temp.next = list2; 
            else
                temp.next = list1;
        }
        return head;
    }
}
