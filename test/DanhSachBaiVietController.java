package test;

//lam nhiem vu dieu huong danh sách bài viết nhap va hien thi thong tin

import java.util.ArrayList;
import java.util.Scanner;

//lam nhiem vu dieu huong danh sách bài viết nhap va hien thi thong tin

public class DanhSachBaiVietController {

    //tao ra noi luu tru danh sach bài viết
    //Bien nay nam ngoai pham vi cua ham create de duoc su dung trong
    //cac ham khac cua lop DanhSachBaiVietController.
    //Viec khai bao o day giup du lieu nhap vao duoc giu lai khi goi cac ham khac
    ArrayList<DanhSachBaiViet> danhSachBaiViets = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    //1. Cho phep tao moi thong tin danh sách bài viết
    public void create() {


        System.out.println("Vui long nhap thong tin danh sach bai viet.");
        System.out.println("Nhap id: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Nhap tieu de: ");
        String tieuDe = scanner.nextLine();
        System.out.println("Nhap mo ta: ");
        String moTa = scanner.nextLine();
        System.out.println("Nhap noi dung bai viet: ");
        String noiDungChinh = scanner.nextLine();
        System.out.println("Nhap anh dai dien: ");
        String anhDaiDien = scanner.nextLine();
        System.out.println("Nhap ten tac gia: ");
        String tenTacGia = scanner.nextLine();
        System.out.println("Nhap ngay viet: ");
        String ngayViet = scanner.nextLine();


//Tao ra mot doi tuong danhsachbaiviet tu thong tin nhap vao
        DanhSachBaiViet danhSachBaiViet = new DanhSachBaiViet();
        danhSachBaiViet.setId(id);
        danhSachBaiViet.setTieuDe(tieuDe);
        danhSachBaiViet.setMoTa(moTa);
        danhSachBaiViet.setNoiDungChinh(noiDungChinh);
        danhSachBaiViet.setTenTacGia(tenTacGia);
        danhSachBaiViet.setNgayViet(ngayViet);
        danhSachBaiViet.setAnhDaiDien(anhDaiDien);

        //Dua daanhsachbaiviet  va list
        danhSachBaiViets.add(danhSachBaiViet);
    }

    //2. Cho phep hien thi
    public void showListDanhSachBaiViet () {
        System.out.println("Hien thi danh sach bai viet");
        System.out.println("-----------------------------");
        System.out.printf("%-10s || %-30s || %-30s || %-30s || %-30s ||%-30s || %-30s\n", "Id", "Tieu De", "Mo Ta", "Ngay Viet", "Anh Dai Dien", "Ten Tac Gia", "Noi Dung Chinh");
        System.out.println("------------------------------");
        for (int i = 0; i < danhSachBaiViets.size(); i++) {
            DanhSachBaiViet ds = danhSachBaiViets.get(i);
            System.out.printf("%-10s || %-30s || %-30s || %-30s || %-30s || %-30s || %-30s\n", ds.getId(), ds.getTieuDe(), ds.getMoTa(), ds.getNgayViet(), ds.getAnhDaiDien(), ds.getTenTacGia(), ds.getNoiDungChinh());
        }
        System.out.println("Enter de tiep tuc");
        scanner.nextLine();

    }

    //3. Cho phep thay doi
    //4. Cho phep xoa
}