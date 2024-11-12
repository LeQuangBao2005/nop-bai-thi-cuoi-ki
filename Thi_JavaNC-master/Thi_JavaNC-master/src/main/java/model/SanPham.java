/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class SanPham {

    private int maSP;
    private String tenSP;
    private double DonGia;
    private String Hinh;
    private int MaLoai;
    private Date NgayCapNhat;

    public SanPham() {
    }

    public SanPham(int magiay) {
        this.maSP = magiay;
    }

    public SanPham(int magiay, String tengiay, double gia, String hinh, int maloai, Date ngaycapnhat) {
        this.maSP = magiay;
        this.tenSP = tengiay;
        this.DonGia = gia;
        this.Hinh = hinh;
        this.MaLoai = maloai;
        this.NgayCapNhat = ngaycapnhat;
    }

    public String getTengiay() {
        return tenSP;
    }

    public void setMagiay(int magiay) {
        this.maSP = magiay;
    }

    public int getMagiay() {
        return maSP;
    }
    public void setTengiay(String tengiay){
        this.tenSP = tengiay;
    }

    public double getGia() {
        return DonGia;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        this.Hinh = hinh;
    }

    public int getMaloai() {
        return MaLoai;
    }

    public void setMaloai(int maloai) {
        this.MaLoai = maloai;
    }

    public Date getNgaycapnhat() {
        return NgayCapNhat;
    }

    public void setNgaycapnhat(Date ngaycapnhat) {
        this.NgayCapNhat = ngaycapnhat;
    }
    @Override
    public String toString() {
        String MaSP = null;
        return "SanPham{" + "mahoa=" + MaSP + ", tenhoa=" + tenSP + ", gia=" + DonGia + ", hinh=" + Hinh + ", maloai=" + MaSP + ", ngaycapnhat=" + NgayCapNhat + '}';
    }

    public String getTenhoa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getMahoa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
