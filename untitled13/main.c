#include <stdio.h>

int main() {
    char name;
    printf("Nhap nhan vien:");
    scanf("%c", &name);
    switch (name){
        case 'A':
            printf("Nhan vien A duoc tro cap 300");
            break;
        case 'B':
            printf("Nhan vien B duoc tro cap 250");
            break;
        case 'C':
            printf("Nhan vien C duoc tro cap 100");
            break;
        default:
            printf("Invalid");
            break;
    }
    return 0;
}
