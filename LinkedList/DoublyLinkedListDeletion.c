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
void deleteFromBeg()
{
    if (head == 0)
        printf("List is Empty\n");
    else
    {
        struct node *temp;
        temp = head;
        head = head->next;
        head->prev = 0;
        free(temp);
    }
}
void deleteFromEnd()
{
    if (tail == 0)
    {
        printf("List is Empty\n");
    }
    else
    {
        struct node *temp;
        temp = tail;
        tail->prev->next = 0;
        tail = tail->prev;
        free(temp);
    }
}
void deleteFromPos()
{
    int pos, i = 1;
    printf("Enter the position from where you want to delete the element: ");
    scanf("%d", &pos);
    struct node *temp;
    temp = head;
    if (pos == 1)
    {
        deleteFromBeg();
    }
    else
    {
        while (i < pos)
        {
            temp = temp->next;
            i++;
        }
        temp->prev->next = temp->next;
        temp->next->prev = temp->prev;
        free(temp);
    }
}
int main()
{
    create();
    display();
    printf("...........................................................................MENU...........................................................................");
    printf("\n1.To delete From the beginning of the DOUBLY LINKED LIST...\n2.To delete From the end of the DOUBLY LINKED LIST...\n3.To delete element from a certain Position of the DOUBLY LINKED LIST...\n");
    int choice = 0;
    printf("\nEnter your choice: ");
    scanf("%d", &choice);
    if (choice == 1)
    {
        deleteFromBeg();
    }
    else if (choice == 2)
    {
        deleteFromEnd();
    }
    else if (choice == 3)
    {
        deleteFromPos();
    }
    else
    {
        exit(0);
    }

    // Function to display the Doubly LINKED LIST after the changes
    display();
    return 0;
}