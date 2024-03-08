

    function nhapThongTinSinhVien() {
    var tenSinhVien = prompt("Nhập tên sinh viên:");
    if (tenSinhVien === null) {
        return;
    }
    
    var ngaySinh = prompt("Nhập ngày sinh của sinh viên (dd-mm-yyyy):");
    if (ngaySinh === null) {
        return; 
    }
    
    var maSinhVien = prompt("Nhập mã sinh viên:");
    if (maSinhVien === null) {
        return; 
    }
    
    var cccd = prompt("Nhập số CCCD của sinh viên:");
    if (cccd === null) {
        return; 
    }
    
    var regexCCCD = /^\d{12}$/;
    if (!regexCCCD.test(cccd)) {
        alert("Số CCCD không hợp lệ. Vui lòng nhập 12 chữ số.");
        return;
    }
    
    var gioiTinh = prompt("Nhập giới tính của sinh viên:");
    if (gioiTinh === null) {
        return;
    }
    
    var queQuan = prompt("Nhập quê quán của sinh viên:");
    if (queQuan === null) {
        return; 
    }
    
    var sdt = prompt("Nhập số điện thoại của sinh viên:");
    if (sdt === null) {
        return; 
    }
    
    var regexSDT = /^\d{10}$/;
    if (!regexSDT.test(sdt)) {
        alert("Số điện thoại không hợp lệ. Vui lòng nhập đúng 10 chữ số.");
        return;
    }

    var email = prompt("Nhập địa chỉ email của sinh viên:");
    if (email === null) {
        return; 
    }
    if (!email.endsWith("@gmail.com")) {
        alert("Địa chỉ email không hợp lệ.");
        return;
    }

    var nganhHoc = prompt("Nhập ngành học của sinh viên:");
    if (nganhHoc === null) {
        return; 
    }

    var table = document.getElementById("studentTableBody");
    var newRow = table.insertRow();

    newRow.innerHTML = `
        <td><input type='checkbox'></td>
        <td>${tenSinhVien}</td>
        <td>${ngaySinh}</td>
        <td>${maSinhVien}</td>
        <td>${cccd}</td>
        <td>${gioiTinh}</td>
        <td>${queQuan}</td>
        <td>${sdt}</td>
        <td>${email}</td>
        <td>${nganhHoc}</td>
        <td><i style='color:blue;' class='fas fa-edit'></i></td>
        <td><i style='color:red;' class='fas fa-times'></i></td>
    `;
}

        function xoaThongTinSinhVien(){
            var table = document.getElementById("studentTableBody");
                    var rows = table.getElementsByTagName("tr");

                    for (var i = rows.length - 1; i >= 0; i--) {
                        var checkbox = rows[i].getElementsByTagName("input")[0];
                        if (checkbox && checkbox.type == "checkbox" && checkbox.checked) {
                            table.deleteRow(i);
                        }
                    }
        }
        function suaThongTinSinhVien() {
            var table = document.getElementById("studentTableBody");
            var rows = table.getElementsByTagName("tr");
        
            for (var i = 0; i < rows.length; i++) {
                var checkbox = rows[i].getElementsByTagName("input")[0];
        
                if (checkbox && checkbox.type == "checkbox" && checkbox.checked) {
                    var cells = rows[i].getElementsByTagName("td");
                    var tenSinhVien = cells[1].innerHTML;
                    var maSinhVien = cells[2].innerHTML;
                    var gioiTinh = cells[3].innerHTML;
                    var queQuan = cells[4].innerHTML;
                    var sdt = cells[5].innerHTML;
                    var email = cells[6].innerHTML;
                    var nganhHoc = cells[7].innerHTML;
        
                    // Hiển thị thông tin trong các ô nhập liệu hoặc prompt
                    var newTenSinhVien = prompt("Nhập tên sinh viên:", tenSinhVien);
                    var newMaSinhVien = prompt("Nhập mã sinh viên:", maSinhVien);
                    var newGioiTinh = prompt("Nhập giới tính của sinh viên:", gioiTinh);
                    var newQueQuan = prompt("Nhập quê quán của sinh viên:", queQuan);
                    var newSdt = prompt("Nhập số điện thoại của sinh viên:", sdt);
                    var newEmail = prompt("Nhập địa chỉ email của sinh viên:", email);
                    var newNganhHoc = prompt("Nhập ngành học của sinh viên:", nganhHoc);
        
                    // Cập nhật thông tin của sinh viên
                    cells[1].innerHTML = newTenSinhVien;
                    cells[2].innerHTML = newMaSinhVien;
                    cells[3].innerHTML = newGioiTinh;
                    cells[4].innerHTML = newQueQuan;
                    cells[5].innerHTML = newSdt;
                    cells[6].innerHTML = newEmail;
                    cells[7].innerHTML = newNganhHoc;
        
                    // Sau khi cập nhật, thoát khỏi vòng lặp
                    return;
                }
            }
        }
