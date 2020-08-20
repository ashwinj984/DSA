#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
} *tail;
typedef struct node Node;
void create()
{
   tail = 0;
    Node *newnode;
    int choice = 1;
    while (choice != 0)
    {
        newnode = (Node *)malloc(sizeof(Node));
        printf("Enter data for Doubly Linked List: ");
        scanf("%d", &newnode->data);
        newnode->next = 0;
        if(tail == 0){
            tail = newnode;
            tail->next = newnode;
        }
        else {
            newnode->next = tail->next;
            tail->next = newnode;
            tail = newnode;
        }
        printf("Do you want to enter more element: ");
        scanf("%d",&choice);
    }
}
void Display(){
    Node *temp;
    if(tail == 0){
        printf("NULL\n");
    }
    else{
        temp = tail->next;
        while(temp->next != tail->next){
            printf("%d==>>",temp->data);
            temp = temp->next;
        }
        printf("%d==>>",temp->data);
    }
    printf("NULL");
}
void reverse(){
    Node *current,*prev,*nextnode;
    current = tail->next;
    nextnode = current->next;
    while(current != tail){
        prev = current;
        current = nextnode;
        nextnode = current->next;
        current->next = prev;
    }
    nextnode->next = tail;
    tail = nextnode;
    printf("\n");
    Display();
}

int main(){
    create();
    Display();
    printf("\nReversed linked list: ")
    reverse();
}