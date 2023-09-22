    #include <stdio.h>

int main() {
    int a;
    printf("a = ");
    scanf("%d", &a);
    if (a>=75)
    printf("Loai A");
    else if (a>=60 && a<75)
    printf("Loai B");
    else if (a>=45 && a<60)
    printf("Loai C");
    else if (a>=30 && a<45)
    printf("Loai D");
    else if (a<30)
    printf("Loai A");
    return 0;
}
