package quanlihoadon;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class HoaDon implements IthanhToan{
    String maHoaDon,NameOfGuest;
    boolean isTheoNgay;
    Date ngayxuat;
    float sotien;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String NameOfGuest, boolean isTheoNgay, Date ngayxuat, float sotien) {
        this.maHoaDon = maHoaDon;
        this.NameOfGuest = NameOfGuest;
        this.isTheoNgay = isTheoNgay;
        this.ngayxuat = ngayxuat;
        this.sotien = sotien;
    }

    public float getSotien() {
        return sotien;
    }

    public void setSotien(float sotien) {
        this.sotien = sotien;
    }

  
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNameOfGuest() {
        return NameOfGuest;
    }

    public void setNameOfGuest(String NameOfGuest) {
        this.NameOfGuest = NameOfGuest;
    }

    public boolean isIsTheoNgay() {
        return isTheoNgay;
    }

    public void setIsTheoNgay(boolean isTheoNgay) {
        this.isTheoNgay = isTheoNgay;
    }

    public Date getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    @Override
    public String toString() {
        return  "maHoaDon=" + maHoaDon + ", NameOfGuest=" + NameOfGuest + ", isTheoNgay=" + isTheoNgay + ", ngayxuat=" + 
                new SimpleDateFormat("dd/MM/yyyy").format(ngayxuat) + ", ngayxuat=" +sotien+ '}';
    }
    
    public double thanhTien() {
        return 0;
    }
   
}
