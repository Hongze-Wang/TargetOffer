/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
// Step 1: create new RandomList without handle the random link
// Step 2: process the random link relationships according the old RandomList
// Step 3: separate the new RandomList from the old RandomList

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        // process illegal input
        if(pHead == null) return null;
        // Step 1
        RandomListNode currNode = pHead;
        RandomListNode nextNode, newNode;
        while(currNode != null) {
            newNode = new RandomListNode(currNode.label);
            nextNode = currNode.next;
            currNode.next = newNode;
            newNode.next = nextNode;
            currNode = nextNode;
        }
        //Step 2
        currNode = pHead;
        while(currNode != null) {
            currNode.next.random = currNode.random == null ? null : currNode.random.next;
            currNode = currNode.next.next;
        }
        //Step 3
        currNode = pHead;
        RandomListNode head = pHead.next;
        while(currNode != null) {
            newNode = currNode.next;
            currNode.next = newNode.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
            currNode = currNode.next;
        }
        return head;
    }
}