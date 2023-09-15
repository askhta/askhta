#include <stdio.h>

int main() {
    int i,a,b,c,d;
    int r1,r2,r3;
    i=10;
    a=2;
    b=2;
    c=4;
    d=5;
    r1 = ++i % 7;
    printf("i=%d, r1 = %d\n", i, r1);
    r2 = 5 * (c - d +3);
    printf("r2 = %d\n",r2);
    r3= a * (b+c/d) -22;
    printf("r3 = %d\n", r3);
}
