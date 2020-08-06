#include<iostream>
#include<bits/stdc++.h>
using namespace std;
long long  fact(int n)
{
    if (n <= 1)
    return 1;
    else
    return fact(n-1)*n;
}
int main()
{
    int n;
    cout<<"Enter the number whose factorial you want : ";
    cin>>n;
    cout<<"Result is : "<<fact(n);
    return 0;
}
