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
    //typedef struct node Node;
    int choice = 1, count = 0;
    struct node *head = 0, *newnode, *temp;
    while (choice != 0)
    {
        newnode = (struct node *)malloc(sizeof(struct node));
        printf("Enter data ");
        scanf("%d", &newnode->data);
        if (head == 0)
        {
            head = temp = newnode;
        }
        else
        {
            temp->next = newnode;
            temp = newnode;
        }
        printf("Do you want to continue(0 or 1) ");
        scanf("%d", &choice);
    }
    temp->next = 0;
    temp = head;
    while (temp != 0)
    {
        printf("%d ", temp->data);
        count++;
        temp = temp->next;
    }
    //Insertion at the begining
    printf("\nEnter data you want to enter: ");
    newnode = (struct node *)malloc(sizeof(struct node));
    scanf("%d", &newnode->data);
    newnode->next = head;
    head = newnode;

    //Displaying of element after the change...
    temp = head;
    printf("\nElement display after insertion at th e beginning ");
    while (temp != 0)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    count++;
    // Insertion at the end
    printf("\nEnter the data you want to enter ");
    newnode = (struct node *)malloc(sizeof(struct node));
    scanf("%d", &newnode->data);
    newnode->next = 0;
    temp = head;
    while (temp->next != 0)
    {
        temp = temp->next;
    }
    temp->next = newnode;
    //Display
    temp = head;
    printf("Element display after insertion at  the end \n");
    while (temp != 0)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    count++;
    // Insertion at the ith position
    int i = 1;
    int pos;
    printf("Enter the position you want to enter ");
    scanf("%d", &pos);
    if (pos > count)
    {
        printf("Invalid Operation\n");
    }
    else
    {
        temp = head;
        while (i < pos)
        {
            temp = temp->next;
            i++;
        }
        newnode = (struct node *)malloc(sizeof(struct node));
        printf("Enter the data : ");
        scanf("%d", &newnode->data);
        newnode->next = temp->next;
        temp = newnode;
        // Display
        printf("Element display after insertion at the %d position \n", pos);
        temp = head;
        while (temp != 0)
        {
            printf("%d ", temp->data);
            temp = temp->next;
        }
    }
}
