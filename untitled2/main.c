#include <stdio.h>

int main() {
    int a;
    float d = 123.123456;
    printf("float 123.123456: %e", d);
    char fullname[100];
    gets(fullname);
    printf("fullname: %s\n", fullname);
    char ch, name[40];
    printf("Please enter the data\n");
    scanf("%d %f %c %s", &a, &d,&ch,name);
    printf("\n The values accepted ar: %d,%f,%c,%s", a , d,ch,name);
    return 0;
}
