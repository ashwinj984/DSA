#include<iostream>
#include<bits/stdc++.h>
using namespace std;
long long pow(int x,int n)
{
    if(n == 0) 
    return 1;
    else{
        return pow(x,n- 1) * x;
    }
}
int main()
{
    int x,n;
    cout<<"Enter the base and the exponent : ";
    cin>>x>>n;
    cout<<"REsult is : "<<pow(x,n);
    return 0;
}
