#include<iostream>
#include<bits/stdc++.h>
struct node
{
    int data;
    struct node *next;
};
typedef struct node Node;
Node *top = 0;
void push(int x)
{
    Node *newnode;
    newnode = (Node *)malloc(sizeof(Node));
    newnode->data = x;
    newnode->next = top;
    top = newnode;
}
void display(){
    Node *temp;
    temp = top;
    if(top == 0)
    {
        printf("Stack is Empty\n");
    }
    else{
        while(temp!=0)
        {
            printf("%d",temp->data);
            temp = temp->next;
        }
    }
}
void peek()
{
    if(top == 0)
    {
        printf("Underflow\n");
    }
    else
    {
        printf("%d",top->data);
    }
    
}
void pop(){
    Node *temp;
    temp=top;
    if(top == 00)
    {
        printf("Underflow");
    }
    else
    {
        
        printf("%d",temp->data);
        top = temp->next;
        free(temp);
    }
    
}
int main(){
     int choice;
    do
    {
        printf("\n.................................................................MENU.......................................................");
        printf("\n1.To insert element in the stack.");
        printf("\n2.To pop out the first element of the stack.");
        printf("\n3.To know which element is at the top without deleting it.");
        printf("\n4.To display the elements of the stack.\n");
        printf("Enter choice : ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
        int x;
        printf("Enter data:");
        scanf("%d",&x);
            push(x);
            break;
        case 2:
            pop();
            break;
        case 3:
            peek();
            break;
        case 4:
            display();
            break;
        default:
            printf("INVALID CHOICE");
            exit(0);
            break;
        }
    } while (choice != 0);
}
