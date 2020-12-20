/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlihoadon;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class HoaDontheoNgay extends HoaDon{
   int songay;

    public HoaDontheoNgay() {
        super();
        songay=0;
    }
    public HoaDontheoNgay(int songay, String maHoaDon, String NameOfGuest, boolean isTheoNgay, Date ngayxuat, float sotien) {
        super(maHoaDon, NameOfGuest, isTheoNgay, ngayxuat, sotien);
        this.songay = songay;
    }

    public int getSongay() {
        return songay;
    }

    public void setSongay(int songay) {
        this.songay = songay;
    }

    @Override
    public String toString() {
        return "HoaDontheoNgay{"+ super.toString()+ "songay=" + songay + "Thanh Tien = "+thanhTien()+'}';
    }
     @Override
    public double thanhTien() {
        if(songay>7)
       return sotien*7+(songay-7)*sotien*0.8;
        return sotien*songay;
    }
   
}
