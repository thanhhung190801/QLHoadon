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
public class HoaDonTheoGio  extends HoaDon{
    int sogio;

    public HoaDonTheoGio() {
    }

    public HoaDonTheoGio(int sogio, String maHoaDon, String NameOfGuest, boolean isTheoNgay, Date ngayxuat, float sotien) {
        super(maHoaDon, NameOfGuest, isTheoNgay, ngayxuat, sotien);
        this.sogio = sogio;
    }

    public int getSogio() {
        return sogio;
    }

    public void setSogio(int sogio) {
        this.sogio = sogio;
    }

    @Override
    public String toString() {
        return "Hoa don theo gio "+super.toString() + "sogio=" + sogio + "Thanh Tien = "+thanhTien()+ '}';
    }
//     @Override
    public double thanhTien() {
       return sotien*sogio;
    }
}
