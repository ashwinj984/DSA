#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
    struct node *prev;
};
typedef struct node Node;
Node *head, *newnode, *tail;
void create()
{
    head = 0;
    //Node *tail;
    int choice = 1;
    while (choice != 0)
    {
        newnode = (Node *)malloc(sizeof(Node));
        printf("Enter data for Doubly Linked List: ");
        scanf("%d", &newnode->data);
        newnode->prev = 0;
        newnode->next = 0;
        if (head == 0)
        {
            head = tail = newnode;
        }
        else
        {
            tail->next = newnode;
            newnode->prev = tail;
            tail = newnode;
        }
        printf("Do you wanna continue(1 or 0)?");
        scanf("%d", &choice);
    }
    tail->next = 0;
    //printf("%p\n",tail);
}
void display()
{
    Node *temp;
    ;
    temp = head;
    while (temp != 0)
    {
        printf("%d==>", temp->data);
        // printf("\n%p\n",tail);
        temp = temp->next;
    }
    printf("NULL\n");
}
void insertAtBeg()
{
    // Node *tail;
    newnode = (Node *)malloc(sizeof(Node));
    printf("Enter data you want to insert: ");
    scanf("%d", &newnode->data);
    newnode->prev = 0;
    newnode->next = 0;
    head->prev = newnode;
    newnode->next = head;
    head = newnode;
}
void insertAtEnd()
{
    newnode = (Node *)malloc(sizeof(Node));
    printf("Enter the data you want to enter at the end: ");
    scanf("%d", &newnode->data);
    newnode->prev = 0;
    newnode->next = 0;
    tail->next = newnode;
    newnode->prev = tail;
    tail = newnode;
}
void insertAtPos()
{
    int pos, i = 1;
    printf("Enter the position at which you want to enter the new element ");
    scanf("%d", &pos);
    if (pos == 0)
    {
        insertAtBeg();
    }
    else if (pos <= 0)
    {
        printf("                      INVALID                               ");
    }
    else
    {
        newnode = (Node *)malloc(sizeof(Node));
        printf("Enter the data you want to enter at the postion: ");
        scanf("%d", &newnode->data);

        newnode->prev = 0;
        newnode->next = 0;
        Node *temp;
        temp = head;
        while (i < pos - 1)
        {
            temp = temp->next;
            i++;
        }
        newnode->prev = temp;
        newnode->next = temp->next;
        temp->next = newnode;
        newnode->next->prev = newnode;
    }
}
void insertAfterPos()
{
    int pos, i = 1;
    printf("Enter the position after which you want to enter the element: ");
    scanf("%d", &pos);
    if (pos < 0)
    {
        printf("INVAID");
    }
    else
    {
        newnode = (Node *)malloc(sizeof(Node));
        printf("Enter the data you want to enter at the postion: ");
        scanf("%d", &newnode->data);

        newnode->prev = 0;
        newnode->next = 0;
        Node *temp;
        temp = head;
        while (i < pos)
        {

            temp = temp->next;
            i++;
        }
        newnode->prev = temp;
        newnode->next = temp->next;
        temp->next = newnode;
        newnode->next->prev = newnode;
    }
}
int main()
{
    // Function to Create a Doubly LINKED LIST
    create();
    // Function to Display the Doubly LINKED LIST
    display();

    printf("...........................................................................MENU...........................................................................");
    printf("\n1.To Insert at the beginning of the DOUBLY LINKED LIST...\n2.To insert at the end of the DOUBLY LINKED LIST...\n3.To insert element at a certain Position of the DOUBLY LINKED LIST...\n4.To insert after a certain position of the  DOUBLY LINKED LIST...");
    int choice  = 0;
    printf("\nEnter your choice: ");
    scanf("%d",&choice);
    if(choice == 1){
        insertAtBeg();
    }
    else if(choice == 2){
        insertAtEnd();
    }
    else if(choice == 3){
        insertAtPos();
    }
    else if (choice == 4){
        insertAfterPos();
    }
    else
    {
        exit(0);
    }
    
// Function to display the Doubly LINKED LIST after the changes
    display();
    return 0;
}
