/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlihoadon;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class MangHoaDon {
    private ArrayList<HoaDon>list = new ArrayList<>();
     Scanner kb  = new Scanner(System.in);
    public void input() throws ParseException{
       int n =0;
        do {            
            System.out.println("Nhap vao so hoa don can them ");
            n = kb.nextInt();
        } while (n<=0);
        
        for (int i = 0; i < n; i++) {
            System.out.println("1.Nhap Thong tin cho hoa don theo ngay :");
            System.out.println("2.Nhap Thong tin cho hoa don theo gio :");
            int choose = kb.nextInt();
            if (choose == 1) {
                HoaDontheoNgay h = new HoaDontheoNgay();
                System.out.println("Nhap ma hoa don ");
                h.setMaHoaDon(kb.nextLine());
                System.out.println("Nhap ten khach hang ");
                h.setNameOfGuest(kb.nextLine());
                System.out.println("Nhap ngay vao ");
                h.setNgayxuat(new SimpleDateFormat("dd/MM/yyyy").parse(kb.nextLine()));
                System.out.println("Nhap so tien ");
                h.setSotien(kb.nextFloat());
                System.out.println("Nhap so ngay thue ");
                h.setSongay(kb.nextInt());
            }
            else if (choose == 2) {
                HoaDonTheoGio h = new HoaDonTheoGio();
                System.out.println("Nhap ma hoa don ");
                h.setMaHoaDon(kb.nextLine());
                System.out.println("Nhap ten khach hang ");
                h.setNameOfGuest(kb.nextLine());
                System.out.println("Nhap ngay vao ");
                h.setNgayxuat(new SimpleDateFormat("dd/MM/yyyy").parse(kb.nextLine()));
                System.out.println("Nhap so tien ");
                h.setSotien(kb.nextFloat());
                System.out.println("Nhap so gio thue ");
                h.setSogio(kb.nextInt());
            }
        }
    }
    public void display(String nd){
        System.out.println(nd);
        int i =0;
        for (HoaDon h : list) {
           i++;
            System.out.println((i)+"."+h);
        }
    }
    public void docFile() throws FileNotFoundException, ParseException{
         kb = new Scanner(new File("hoadon.txt"));
        while(kb.hasNextLine()){
            String id = kb.next();
            String name ="";
            while(kb.hasNext()&&!kb.hasNextBoolean()){
                name+=kb.next();
            }
            boolean isngay =kb.nextBoolean();
            String date = kb.next();
            float sotien =kb.nextFloat();
            int number1=kb.nextInt();
            HoaDon a ;
            if(isngay){
                a = new HoaDontheoNgay(number1,id, name, isngay, new SimpleDateFormat("dd/MM/yyyy").parse(date), sotien);
            }else              
                a = new HoaDonTheoGio(number1,id, name, isngay, new SimpleDateFormat("dd/MM/yyyy").parse(date), sotien);
            list.add(a);
        }
        
        
    }
    public void getNgayThanhTienmin(){
        double min =0;int count=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).thanhTien()<min){
                min=list.get(i).thanhTien();
                count=i;
            }
        }
        System.out.println("ngay co thanh tien nho nhat la "
                + new SimpleDateFormat("dd/MM/yyyy").format(list.get(count).getNgayxuat()));
    }
    public void getNgayThanhTienMaxTheoNgay() {
        double min = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof HoaDontheoNgay) {
                if (list.get(i).thanhTien() < min) {
                    min = list.get(i).thanhTien();
                    count = i;
                }
            }
        }
        System.out.println("ngay co thanh tien nho nhat theo ngay la "
                + new SimpleDateFormat("dd/MM/yyyy").format(list.get(count).getNgayxuat()));
    }
       public void getNgayThanhTienMaxTheoGio() {
        double min = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof HoaDonTheoGio) {
                if (list.get(i).thanhTien() < min) {
                    min = list.get(i).thanhTien();
                    count = i;
                }
            }
        }
        System.out.println("ngay co thanh tien nho nhat theo gio la "
                + new SimpleDateFormat("dd/MM/yyyy").format(list.get(count).getNgayxuat()));
    }
    public void ThongKeTheoNgay(){
        System.out.println("Nhap vao ngay can thong ke: ");
        String dayKeyboard =kb.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if(new SimpleDateFormat("dd/MM/yyyy").format(list.get(i).getNgayxuat()).equals(dayKeyboard)){
                System.out.println(i+1+"."+list.get(i));
            }
        }
    }
    public void sortOfId(){
        list.sort(new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon a, HoaDon b) {
               return (a.thanhTien()>b.thanhTien())?1:0;
            }
        });
        display("Danh sach sau khi sap xep tang dan theo thanh tien");
    }
     public void deleteByid(){
        System.out.println("Nhap vao ma hoa don can xoa: ");
        String dayKeyboard =kb.nextLine();
        int local=0; 
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMaHoaDon().equalsIgnoreCase(dayKeyboard)){
                list.remove(i);
                local=i;
            }
        }
        display("Danh sach sau khi xoa ma hoa don "+list.get(local).getMaHoaDon());
    }
     public static void main(String[] args) throws FileNotFoundException, ParseException {
        MangHoaDon m = new MangHoaDon();
        m.docFile();
        m.display("Danh sach hoa don la: ");
//        m.ThongKeTheoNgay();
//        m.getNgayThanhTienMaxTheoNgay();
//        m.getNgayThanhTienMaxTheoGio();
//        m.getNgayThanhTienmin();
//        m.deleteByid();
//        m.sortOfId();
        
        
    }
}

