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
        
        printf("%p==>>",tail->next);
        while (temp->next != head)
        {
            printf("%d==>>",temp->data);
            printf("%p==>>",temp->next);
            temp = temp->next;
        }
        printf("%d==>>",temp->data);
        printf("%p==>>",temp->next);
    }
    printf("NULL");
}
int main(){
    printf("My first new Circular Linked List\n");
    create();
    Display();
    return 0;
}