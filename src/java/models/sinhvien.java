package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class sinhvien {

	private int maSV;
	private String tenSV;
	private String diaChi;
	private int sdt;
	private String email;
	Lop lop;

    public sinhvien( String tenSV, String diaChi, int sdt, String email, Lop lop,int maSV) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.lop = lop;
    }
	
}
