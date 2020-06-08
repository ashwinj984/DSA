#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void TOH(int n, char A, char B, char C)
{
    if(n==0)
    return ;
    TOH(n-1,A,C,B);
    cout<<"Moving a disc from "<<A<<"to"<<C;
    TOH(n-1,B,A,C);
}
int main()
{
    int n;
    cout<<"Enter number of discs : ";
    cin>>n;
    TOH(n,'A','B','C');
    cout<<"..................Tower of Hanoi Completed.......................";
    cout<<"...................Completed the work .................";
    return 0;
}
