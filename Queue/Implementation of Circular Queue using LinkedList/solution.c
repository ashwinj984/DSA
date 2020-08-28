#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
};
typedef struct node Node;
Node *front = 0;
Node *rear = 0;
void enqueue(int x)
{
    Node *newnode;
    newnode = (Node *)malloc(sizeof(Node));
    newnode->data = x;
    newnode->next = 0;
    if (rear == 0)
    {
        front = newnode;
        rear = newnode;
        rear->next = front;
    }
    else
    {
        rear->next = newnode;
        rear = newnode;
        rear->next = front;
    }
}
void dequeue()
{
    Node *temp;
    temp = front;
    if (front == 0)
    {
        printf("Empty Queue\n");
    }
    else if (front == rear)
    {
        front = rear = 0;
    }
    else
    {
        front = front->next;
        rear->next = front;
    }
    free(temp);
}
void display()
{
    Node *temp;
    temp = front;
    if (front == 0 && rear == 0)
    {
        printf("Queue is Empty.\n");
    }

    else
    {

        printf("Queue is : ");
        while (temp->next != front)
        {
            printf("%d ", temp->data);
            temp = temp->next;
        }
        printf("%d ", rear->data);
    }
}
void peek()
{
    if (front == 0 && rear == 0)
    {
        printf("Queue is Empty.\n");
    }
    printf("%d ", front->data);
}
int main()
{
    int choice;
    do
    {
        printf("\n..................................................MENU...............................................");
        printf("\n1.To enter element in the queue...");
        printf("\n2.To remove an element from the Queue...");
        printf("\n3.To check the first element of the queue....");
        printf("\n4.To display element of the Queue...");
        printf("\n......................\nEnter choice: ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            printf("\nEnter element you want to enter: ");
            int x;
            scanf("%d", &x);
            enqueue(x);
            break;
        case 2:
            dequeue();
            printf("Element Removed\n");
            break;
        case 3:
            peek();
            break;
        case 4:
            display();
            break;

        default:
            break;
        }
    } while (choice != 0);
}
