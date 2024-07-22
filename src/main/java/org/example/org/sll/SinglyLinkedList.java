package org.example.org.sll;

public class SinglyLinkedList {

    private ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        displayList(sll.head);
        System.out.println(getCountOfSll(sll.head));
        sll.head = insertNodeAtBeginning(sll.head, 13);
        displayList(sll.head);
        insertNodeAtEnd(sll.head, 22);
        displayList(sll.head);

        sll.head = insertAtPosition(sll.head, 32, 5);
        displayList(sll.head);
        int data = findMiddleNode(sll.head);
        System.out.println(data);
        sll.head = deleteAtStart(sll.head);
        displayList(sll.head);
        deleteLastNode(sll.head);
        displayList(sll.head);
        deleteNodeAtPosition(sll.head, 5);
        displayList(sll.head);
        int position = searchInSll(sll.head, 32);
        System.out.println(position);
        sll.head = reverseLinkedList(sll.head);
        displayList(sll.head);
        int result = findNthNodeFromEnd(sll.head);
        System.out.println(result);
    }

    private static int findNthNodeFromEnd(ListNode head) {
        return 0;
    }

    private static int findMiddleNode(ListNode head) {
        ListNode temp1 = head, temp2 = head;
        while (temp2!=null && temp2.next != null){
            temp2 = temp2.next.next;
            temp1 = temp1.next;
        }
        return temp1.data;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = null;
        ListNode previousNode = null;
        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        return head;
    }

    private static int searchInSll(ListNode head, int data) {
        int count = 1;
        ListNode temp = head;
        while(temp != null){
            if(temp.data == data){
                return count;
            }
            count++;
            temp = temp.next;
        }
        return -1;
    }

    private static void deleteNodeAtPosition(ListNode head, int position) {

        if(head == null){
            return;
        }
        ListNode temp = head;
        ListNode temp2;
        int count = 1;
        while (temp != null){
            if(count+1 == position){
                temp2 = temp.next;
                temp.next = temp.next.next;
                temp2.next = null;
                return;
            }
            temp = temp.next;
            count++;
        }

    }

    private static void deleteLastNode(ListNode head) {
        ListNode temp  = head;
        while(temp.next.next  != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    private static ListNode deleteAtStart(ListNode head) {
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    private static ListNode insertAtPosition(ListNode head, int data, int position) {
        int tempNodeCount = 1;
        ListNode node = new ListNode(data);
        ListNode temp = head;
        if(head == null){

            head = node;
        }
        else if(position == 1){

            node.next = head;
            head = node;
        }
        else {
            while (temp != null) {
                if (tempNodeCount + 1 == position) {

                    node.next = temp.next;
                    temp.next = node;
                    break;
                }
                tempNodeCount++;
                temp = temp.next;
            }
        }
        return head;
    }

    private static void insertNodeAtEnd(ListNode head, int i) {
        ListNode node = new ListNode(i);
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    private static void displayList(ListNode head) {
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println(temp);
    }

    private static int getCountOfSll(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;

        }
        return count;
    }

    private static ListNode insertNodeAtBeginning(ListNode head, int data){
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
        return head;
    }


}
