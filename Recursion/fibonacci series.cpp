#include<iostream>
#include<bits/stdc++.h>
using namespace std;
long long int fib(int n);
int main()
{
    int n;
    cout<<"Enter the term of the fibonacci number you want to see : ";
    cin>>n;
    cout<<fib(n);
    return 0;
}
long long int fib(int n)
{
    if(n<=1)
    return n;
    
        return fib(n-1)+fib(n-2);
    
}
