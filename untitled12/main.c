#include <stdio.h>

int main() {
    int a,b;
    printf("Nhap vao a = ");
    scanf("%d", &a);
    printf("\nNhap vao b = ");
    scanf("%d", &b);
    if (a-b==b && a>b)
        printf("Hieu bang gia tri da cho:%d",b);
    else if (b-a==a && b>a)
        printf("Hieu bang gia tri da cho: %d", a);
    else
        printf("Hieu khong bang gia tri da nhap vao");
    return 0;
}