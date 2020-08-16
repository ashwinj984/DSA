#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
void main()
{
    struct node
    {
        int data;
        struct node *next;
    };
    typedef struct node Node;
    Node *head = 0, *newnoed, *temp;
    int choice = 1;
    while (choice != 0)
    {
        newnoed = (Node *)malloc(sizeof(Node));
        printf("Enter data\n");
        scanf("%d", &newnoed->data);
        if (head == 0)
        {
            temp = head = newnoed;
        }
        else
        {
            temp->next = newnoed;
            temp = newnoed;
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
}
