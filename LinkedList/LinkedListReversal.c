#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
};
typedef struct node Node;
Node *head;
void LinkedListReversal()
{
    Node *prevnode = 0;
    Node *currentnode, *nextnode;
    currentnode = nextnode = head;
    while (nextnode != 0)
    {
        nextnode = nextnode->next;
        currentnode->next = prevnode;
        prevnode = currentnode;
        currentnode = nextnode;
    }
    head = prevnode;
}
int main()
{
    head = 0;
    Node *newnode, *temp;
    int choice = 1;
    while (choice != 0)
    {
        newnode = (Node *)malloc(sizeof(Node));
        printf("Enter data\n");
        scanf("%d", &newnode->data);
        if (head == 0)
        {
            temp = head = newnode;
        }
        else
        {
            temp->next = newnode;
            temp = newnode;
        }
        printf("Do you want to continut(1 or 0)?\n");
        scanf("%d", &choice);
    }
    temp->next = 0;
    temp = head;
    while (temp != 0)
    {
        printf("%d==>>", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
    printf("Reversed Linked list \n");
    LinkedListReversal();
    temp = head;
    while (temp != 0)
    {
        printf("%d==>>", temp->data);
        temp = temp->next;
    }
    printf("NULL\n")
}