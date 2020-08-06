#include<iostream>
#include<bits/stdc++.h>
// Taylor series  of e^x
using namespace std;
double e(int x, int n)
{
    static double p = 1,f = 1;
    double r;
    if(n == 0)
    return 1;
    r = e(x,n-1);
    p = p * x;
    f = f * n;
    return r + p/f;

}
int main()
{
    int x,n;
    cout<<"Enter  the power and the  exponent ";
    cin>>x>>n;
    cout<<"Result " << e(x,n);
    return 0;
}
