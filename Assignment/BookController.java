package Assignment;

import Assignment.Book

import java.util.ArrayList;
import java.util.Scanner;

//lam nhiem vu dieu huong danh sách bài viết nhap va hien thi thong tin

public class BookController{

    //tao ra noi luu tru danh sach bài viết
    //Bien nay nam ngoai pham vi cua ham create de duoc su dung trong
    //cac ham khac cua lop DanhSachBaiVietController.
    //Viec khai bao o day giup du lieu nhap vao duoc giu lai khi goi cac ham khac
    ArrayList<Book> Books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    //1. Cho phep tao moi thong tin danh sách bài viết
    public void create() {


        System.out.println("Vui long nhap thong tin danh sach bai viet.");
        System.out.println("Nhap id: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Nhap tieu de: ");
        String title = scanner.nextLine();
        System.out.println("Nhap mo ta: ");
        String description = scanner.nextLine();
        System.out.println("Nhap noi dung bai viet: ");
        String content = scanner.nextLine();
        System.out.println("Nhap anh dai dien: ");
        String img = scanner.nextLine();
        System.out.println("Nhap ten tac gia: ");
        String author = scanner.nextLine();
        System.out.println("Nhap ngay viet: ");
        String date = scanner.nextLine();


//Tao ra mot doi tuong danhsachbaiviet tu thong tin nhap vao
        Book danhSachBaiViet = new Book();
        danhSachBaiViet.setId(id);
        danhSachBaiViet.setTitle(title);
        danhSachBaiViet.setDescription(description);
        danhSachBaiViet.setContent(content);
        danhSachBaiViet.setAuthor(author);
        danhSachBaiViet.setDate(date);
        danhSachBaiViet.setImg(img);

        //Dua daanhsachbaiviet  va list
        Books.add(danhSachBaiViet);
    }

    //2. Cho phep hien thi
    public void showListDanhSachBaiViet () {
        System.out.println("Hien thi danh sach bai viet");
        System.out.println("-----------------------------");
        System.out.printf("%-10s || %-30s || %-30s || %-30s || %-30s ||%-30s || %-30s\n", "Id", "Tieu De", "Mo Ta", "Ngay Viet", "Anh Dai Dien", "Ten Tac Gia", "Noi Dung Chinh");
        System.out.println("------------------------------");
        for (int i = 0; i < Books.size(); i++) {
            Book ds = Books.get(i);
            System.out.printf("%-10s || %-30s || %-30s || %-30s || %-30s || %-30s || %-30s\n", ds.getId(), ds.getTitle(), ds.getDescription(), ds.getDate(), ds.getImg(), ds.getAuthor(), ds.getContent());
        }
        System.out.println("Enter de tiep tuc");
        scanner.nextLine();

    }

    //3. Cho phep thay doi
    //4. Cho phep xoa
}
