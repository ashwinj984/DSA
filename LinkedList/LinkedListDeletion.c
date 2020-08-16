#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
};
struct node *head;
//typedef struct node Node;
// function to delete one node from the beginning
void deleteFromBeg()
{
    struct node *temp;
    temp = head;
    head = temp->next;
    free(temp);
}
// function to delete one node from the end
void deleteFronEnd()
{
    struct node *temp, *prevnode;
    temp = head;
    prevnode = 0;
    while (temp->next != 0)
    {
        prevnode = temp;
        temp = temp->next;
    }
    prevnode->next = 0;
    free(temp);
}
// function to delete a node from a certain position
void deleteFromPos()
{
    int pos;
    int i = 1;
    if (head->next == 0)
    {
        free(head);
    }
    printf("Enter the position from where you want to delete the element: ");
    scanf("%d", &pos);
    struct node *temp, *prevnode = 0;
    temp = head;
    while (i < pos - 1)
    {
        prevnode = temp;
        temp = temp->next;
        i++;
    }
    prevnode = temp;
    temp = temp->next;
    prevnode->next = temp->next;
    free(temp);
}
int main()
{
    head = 0;
    int choice = 1, count = 0;
    struct node *newnode, *temp;
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
    printf(".................................Menu....................................\n");
    printf("1.To delete from Beginning\n2.To delete from the End\n3.To delete from a certain Position\n");
    int choose = 0;
    scanf("%d", &choose);
    if (choose == 1)
    {
        deleteFromBeg();
    }
    else if (choose == 2)
    {
        deleteFronEnd();
    }
    else if (choose == 3)
    {
        deleteFromPos();
    }
    else
    {
        exit(0);
    }

    temp = head;
    while (temp != 0)
    {
        printf("%d ", temp->data);
        count++;
        temp = temp->next;
    }
}