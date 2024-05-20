package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        createMenu();
    }

    public static void createMenu() {
        Scanner sc = new Scanner(System.in);
        DanhSachBaiVietController danhSachBaiVietController = new DanhSachBaiVietController();
        while (true) {
            System.out.println("Chuong Trinh Quan Ly Danh sach Bai Viet");
            System.out.println("=======================================");
            System.out.println("1. Them Moi Bai Viet");
            System.out.println("2. Hien Thi Danh Sach Bai Vua Nhap");
            System.out.println("3. Tim Kiem Bai Viet Theo Ma Trong ArrayList");
            System.out.println("4. Xoa Bai Viet Theo Ma Trong ArrayList");
            System.out.println("0. Thoat Khoi Chuong Trinh");
            System.out.println("========================================");
            System.out.println("Vui long nhap lua chon");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    danhSachBaiVietController.create();
                    break;
                case 2:
                    danhSachBaiVietController.showListDanhSachBaiViet();
                    break;
                case 3:
                    System.out.println("Chuc nang dang duoc phat trien");
                    break;
                case 4:
                    System.out.println("Chuc nang dang  duoc phat trien");
                case 0:
                    System.out.println("Tam biet. Hen gap lai");
                    break;
                default:
                    System.out.println("Vui long lua chon tu 0 den 4");
                    break;
            }
            if (choice == 0) {
                //Ket thuc chuong trinh
                break;
            }
        }
    }
}
