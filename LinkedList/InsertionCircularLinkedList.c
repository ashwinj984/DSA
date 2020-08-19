#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
} * head, *tail;
typedef struct node Node;
void create()
{
    head = 0;
    Node *temp;
    Node *newnode;
    int choice = 1;
    while (choice != 0)
    {
        newnode = (Node *)malloc(sizeof(Node));
        printf("Enter data for Doubly Linked List: ");
        scanf("%d", &newnode->data);
        newnode->next = 0;
        if (head == 0)
        {
            head = temp = newnode;
        }
        else
        {
            temp->next = newnode;
            temp = newnode;
        }
        printf("Do you want to continue entering elements in the Linked List(1 or 0) ? ");
        scanf("%d", &choice);
    }
    temp->next = head;
    tail = temp;
}
void Display()
{
    struct node *temp;
    if (head == 0)
    {
        printf("List is empty\n");
    }
    else
    {
        temp = tail->next;
        // this is to cross verify that it is just a circular linked list
        // No need to worry about this line

        // printf("%p==>>",tail->next);
        while (temp->next != head)
        {
            printf("%d==>>", temp->data);
            //printf("%p==>>",temp->next);
            temp = temp->next;
        }
        printf("%d==>>", temp->data);
        //printf("%p==>>",temp->next);
    }
    printf("NULL");
}
void insertAtBeg()
{
    Node *newnode;
    newnode = (Node *)malloc(sizeof(Node));
    printf("\nInsert data at the beginning: ");
    scanf("%d", &newnode->data);
    newnode->next = 0;
    if (tail == 0)
    {
        tail = newnode;
        tail->next = newnode;
    }
    else
    {
        newnode->next = tail->next;
        tail->next = newnode;
    }
    head = newnode;
    Display();
}
void insertAtEnd()
{
    Node *newnode;
    newnode = (Node *)malloc(sizeof(Node));
    printf("\nInsert data at the end: ");
    scanf("%d", &newnode->data);
    if (tail == 0)
    {
        tail = newnode;
        tail->next = newnode;
    }
    else
    {
        newnode->next = tail->next;
        tail->next = newnode;
        tail = newnode;
    }
    Display();
}
void insertAtPos()
{

    int pos, i = 1;
    printf("\nEnter position at which you want to enter new character: ");
    scanf("%d", &pos);

    if (pos == 1)
    {
        insertAtBeg();
    }
    else if (pos == 0)
    {
        printf("INVALID\n");
    }
    else
    {
        Node *newnode;
        Node *temp;
        newnode = (Node *)malloc(sizeof(Node));
        printf("Enter the element you want to insert: ");
        scanf("%d", &newnode->data);
        newnode->next = 0;
        temp = tail->next;
        while (i < pos - 1)
        {
            temp = temp->next;
            i++;
        }
        newnode->next = temp->next;
        temp->next = newnode;
    }
    Display();
}
int main()
{
    printf("My first new Circular Linked List\n");
    create();
    Display();
    printf("\n.............................................................................M.E.N.U............................................................................");
    printf("\n1.To insert the element at the beginning... ");
    printf("\n2.To insert at the end of the Linked List... ");
    printf("\n3.To insert at a certain position...");
    printf("\nEnter your choice: ");
    int choose;
    scanf("%d", &choose);
    if (choose == 1)
    {
        insertAtBeg();
    }
    else if (choose = 2)
    {
        insertAtEnd();
    }
    else if (choose == 3)
    {
        insertAtPos();
    }
    else
    {
        exit(0);
    }
    return 0;
}