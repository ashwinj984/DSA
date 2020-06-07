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
long long  c(int n , int r)
{
    long long  t1,t2,t3;
    t1 = fact(n);
    t2 = fact(r);
    t3 = fact(n-r);
    return t1/(t2*t3);
}
int main()
{
    int n,r;
    cout<<"Enter N and r respectively for nCr : ";
    cin>>n>>r;
    cout<<"Result is : ";
    cout<<c(n,r);
}
