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
    printf("NULL\n");
}
void deleteFromBeg()
{
    Node *temp;
    temp = tail->next;
    if (tail == 0)
    {
        printf("List is Empty\n");
    }
    else if (temp->next == temp)
    {
        tail = 0;
        free(temp);
    }
    else
    {
        tail->next = temp->next;
        free(temp);
    }
}
void deleteFromEnd(){
    Node *current,*previous;
    current = tail->next;
    if(tail == 0){
        printf("Invalid");
    }
    else if(current->next == current){
        tail = 0;
        free(current);
    }
    else{
        while(current->next != tail->next){
            previous = current;
            current = current->next;
        }
        previous->next = tail->next;
        tail = previous;
        free(current);
    }
}
void deleteFromPos(){
    struct node *current,*nextnode;
    int pos, i = 1;
    current = tail->next;
    printf("Enter position from where you want to delete: ");
    scanf("%d",&pos);
    if(pos == 1){
        deleteFromBeg();
    }
    else if(pos<1){
        printf("INVALID");
    }
    else{
        while(i < pos - 1){
            current = current->next;
            i++;
        }
        nextnode = current->next;
        current->next = nextnode->next;
        free(nextnode);
    }
}
int main()
{
    create();
    Display();
    printf("\n.............................................................................M.E.N.U............................................................................");
    printf("\n1.To delete the element from the beginning... ");
    printf("\n2.To delete from the end of the Linked List... ");
    printf("\n3.To delete from a certain position...");
    printf("\nEnter your choice: ");
    int choose;
    scanf("%d", &choose);
    if(choose == 1){
        deleteFromBeg();
    }
    else if(choose == 2){
        deleteFromEnd();
    }
    else if(choose == 3){
        deleteFromPos();
    }
    else{
        exit(0);
    }
}