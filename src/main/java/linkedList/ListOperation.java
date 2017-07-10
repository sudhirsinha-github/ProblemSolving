package linkedList;

public class ListOperation{
    public MyList createList(boolean loop) {
        MyList list0 = new MyList();
        list0.data = 10;

        MyList list1 = new MyList();
        list1.data = 12;
        list0.next = list1;


        MyList list2 = new MyList();
        list2.data = 14;
        list1.next = list2;


        MyList list3 = new MyList();
        list3.data = 15;
        list2.next = list3;


        MyList list4 = new MyList();
        list4.data = 17;
        list3.next = list4;

        MyList list5 = new MyList();
        list5.data = 19;
        list4.next = list5;
        if(loop) {
            list5.next = list0;
        }
        else {
            list5.next = null;
        }

        MyList head = list0;
        /*while (head != null){
            System.out.println(head.data);
            head = head.next;
        }*/

        return head;
    }


    public static void main(String[] args) {
        ListOperation listOperation = new ListOperation();
        MyList head = listOperation.createList(true);

        // Find length of LL
         // int length = findLengthOfLL(head);

         // Find the middle of List
        //findTheMiddleOfList(head, length);

        //Find loop in Linked List and corect it
         correctLoop(head);

        //reverse the linked list
        MyList curr = head;
        MyList prev = null;
        MyList next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = prev;
        while (curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }

        //displayStarTri();
    }

    private static void correctLoop(MyList head) {
        MyList first =head;
        MyList curr = head.next.next;
        MyList prev = head;
        int pos = 1;
        while (curr.next != null)
        {
            first = first.next;
            pos++;
            if(first == curr) {
                System.out.println("Loop found ..node .. @" + curr.data);
                prev.next = null;
                break;
            }

            prev = curr.next;
            curr = curr.next.next;

        }

        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static void findTheMiddleOfList(MyList head, int length) {
        int middle = (int) Math.floor(length/2);
        System.out.println(middle);

        // another way FP n SP
        MyList slow = head;
        MyList fast = head.next.next;
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle node is " + slow.data);
    }

    private static int findLengthOfLL(MyList head) {
        int count = 0;
        while (head != null)
        {
            count++;
            head = head.next;
        }

        System.out.println("Length of LL "+ count);

        return  count;
    }

    public static void displayStarTri()
    {
        String str ="*";
int n =5;
        for (int i=0;i<n ;i++)
        {
            for(int k = i+1;k<n;k++){
                System.out.print("  ");
            }
            for( int j=1;j<i;j++)
            {
                System.out.print("\t" + str);
            }

            System.out.println();
        }
    }
}
