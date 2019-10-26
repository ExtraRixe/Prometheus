import java.util.Scanner;

public class CircularQueue2 {
     
      public static void main(String args[])  {
    Queue q = new Queue(); //Queue of size 5
    int ch;
    Scanner sc =new Scanner(System.in);
    do    {
    System.out.println("Menu\n1.insert\n2,delete\n3.display\n4.destroy\n5.exit\n");
    System.out.print("Enter choice : ");
    System.out.print("\n");

    ch=sc.nextInt();
    switch(ch)     {
        case 1:
            System.out.print("Enter data to insert: ");
        int x=sc.nextInt();
        q.insert(x);
        System.out.print("\n");
        break;
        case 2:
            if(q.empty())
            System.out.print("Queue underflow: ");
            else             {
                int z =q.delete();
                System.out.print("data deleted =" + z );
            }
            System.out.print("\n");
            break;
        case 3: q.display();
            break;

        case 4: q.destroy();
            break;
        case 5: break;

        default : System.out.println("Wrong Choice");
    }
    }while(ch!=5);
 }//end main
}//end CircularQueue

class Queue {
    int a[];
    int front, rear;

    Queue()     {
        a = new int [5];
        front = rear = -1;
    }

    Queue(int size)     {
        a = new int[size];
        front = rear = -1;
    }

    void insert(int x)     {
        int p;
        p = (rear+1)% a.length;

        if(p == front)
            System.out.println("Queue Overflow ");
        else         {
            rear = p;
            a[rear] = x;

            if(front == -1)
               front = 0;

        }
    }


    boolean empty()     {
        if(front == -1)
            return true;
        else
            return false;
    }


    int delete()     {
        int x = a[front];
        if(front == rear)
            front = rear = -1;
        else
            front =(front+1)% a.length;
        return x;
    }


    void display()     {
    	String hold = "";
        if(front == -1)
           System.out.println("Queue underflow");
        else         {
            System.out.println("Elements of Queue are");
            int i = front;

            while(i != rear)             {
                System.out.println(a[i]);
                hold+=a[i]+"|";
                i = (i+1)% a.length;
            }

            hold+=a[i];
            System.out.println(hold);


        }
    }


    void destroy()    { 
        front = rear=-1;

    }

    }
    
