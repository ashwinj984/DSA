#include <iostream>
#include <bits/stdc++.h>
#define N 5
int stack[N];
int top = -1;
void display();
void push()
{
    printf("\nEnter Data: ");
    int data;
    scanf("%d", &data);
    if (top == N - 1)
    {
        printf("\nData Overflow\n");
    }
    else
    {
        top++;
        stack[top] = data;
    }
    display();
    printf("\n");
}
void pop()
{
    int item;
    if (top == -1)
    {
        printf("\nUnderflow\n");
    }
    else
    {
        item = stack[top];
        top--;
        // a statement to return the deleted value
        printf("\nThe deleted data is %d", item);
    }
}
void peek()
{
    if (top == -1)
    {
        printf("\nStack is Empty\n");
    }
    else
    {
        printf("\nThe data at the top of the stack is %d", stack[top]);
    }
}
void display()
{
    int i;
    printf("\n");
    for (i = top; i >= 0; i--)
    {
        printf("%d ", stack[i]);
    }
}
int main()
{
    int choice;
    do
    {
        printf(".................................................................MENU.......................................................");
        printf("\n1.To insert element in the stack.");
        printf("\n2.To pop out the first element of the stack.");
        printf("\n3.To know which element is at the top without deleting it.");
        printf("\n4.To display the elements of the stack.\n");
        printf("Enter choice : ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            push();
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
