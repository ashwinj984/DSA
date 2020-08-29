#include<stdio.h>
/*                                   Implementation of Queues Using Stack                             */
# define N 5
int top1= -1,top2 = -1;
int s1[N],s2[N];
int count = 0;
void push1(int x);
void push2(int x);
int pop1();
int pop2();
void enqueue(int x);
void dequeue();
void display();
void enqueue(int x)
{
    push1(x);
    count++;
}
void dequeue(){
    if(top1 == -1 && top2 == -1){
        printf("Underflow\n");
    }
    else{
        for(int i = 0; i < count; i++){
            int a = pop1();
            push2(a);
        }
        int b = pop2();
        printf("Removed element is %d",b);
        count--;
        for(int i = 0; i < count;i++){
            int a = pop2();
            push1(a);
        }
    }
    }
    void display(){
        int i;
        printf("Present elements in Queue are : ");
        for(i = 0;i<=top1; i++){
            printf("%d ",s1[i]);
        }
    }
    void push1(int x){
        if(top1 == N-1){
            printf("Overflow\n");
        }
        else{
            top1++;
            s1[top1] = x;
        }
    }
    void push2(int x){
        if(top2 == N-1){
            printf("Overflow\n");
        }
        else{
            top2++;
            s2[top2] = x;
        }
    }
    int pop1(){
        return s1[top1--];
    }
    int pop2(){
        return s2[top2--];
    }
 int main(){
    
    int choice;
    do
    {
        printf("\n..................................................MENU...............................................");
        printf("\n1.To enter element in the queue...");
        printf("\n2.To remove an element from the Queue...");
        //printf("\n3.To check the first element of the queue....");
        printf("\n3.To display element of the Queue...");
        printf("\n......................\nEnter choice: ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            printf("\nEnter element you want to enter: ");
            int x;
            scanf("%d", &x);
            enqueue(x);
            break;
        case 2:
            dequeue();
            printf("Element Removed\n");
            break;
        case 3:
            display();
            break;

        default:
            break;
        }
    } while (choice != 0);
}
 
 
 // there are some minute problem but that does not affect if the user of this code is wise
