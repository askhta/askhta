#include <stdio.h>

int main() {
    int a,b;
    printf("Nhap vao a = ");
    scanf("%d", &a);
    printf("\nNhap vao b = ");
    scanf("%d", &b);
    if (a%b==0)
        printf("a chia het cho b");
    else
        printf("a khong chia het cho b");
    return 0;
}
