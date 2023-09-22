
#include <stdio.h>

int main() {
    int a,b;
    printf("Nhap vao a = ");
    scanf("%d", &a);
    printf("\nNhap vao b = ");
    scanf("%d", &b);
    if (a*b>100)
        printf("a nhan b lon hon 100");
    else
        printf("a nhan b be hon 100");
    return 0;
}
