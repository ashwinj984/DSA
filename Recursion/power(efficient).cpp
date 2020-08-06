#include<iostream>
#include<bits/stdc++.h>
using namespace std;
long long pow(int m, int n)
{
    if(n == 0)
    return 1;
    else if(n % 2 == 0)
    return pow(m*m,n/2);
    else 
    return m * pow(m*m,(n-1)/2);
}
int main()
{
    int x,n;
    cout<<"Enter base and radical respectively : ";
    cin>>x>>n;
    cout<<"Result is : "<<pow(x,n);
    return 0;
}
