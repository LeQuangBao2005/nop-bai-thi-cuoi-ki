/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<SanPham> getTop10() {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select top 10 * from SanPham order by gia desc";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }

    //Phương thức đọc hoa theo thể loại
    public ArrayList<SanPham> getByCategoryId(int maloai) {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select * from SanPham where maloai=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maloai);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }

    //phuong thuc doc tat ca san pham (SanPham) từ CSDL
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select * from SanPham";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }

    //phuong thuc them mới sản phẩm (SanPham)
    public boolean Insert(SanPham hoa) {
        String sql = "insert into hoa (tenhoa,gia,hinh,maloai,ngaycapnhat) values (?,?,?,?,?)";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, hoa.getTenhoa());
            ps.setDouble(2, hoa.getGia());
            ps.setString(3, hoa.getHinh());
            ps.setInt(4, hoa.getMaloai());
            ps.setDate(5, hoa.getNgaycapnhat());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return false;
    }

    //phuong thuc cập nhật sản phẩm (SanPham)
    public boolean Update(SanPham hoa) {
        String sql = "update hoa set tenhoa=?,gia=?,hinh=?,maloai=?,ngaycapnhat=? where mahoa=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, hoa.getTenhoa());
            ps.setDouble(2, hoa.getGia());
            ps.setString(3, hoa.getHinh());
            ps.setInt(4, hoa.getMaloai());
            ps.setDate(5, hoa.getNgaycapnhat());
            ps.setInt(6, hoa.getMahoa());
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return false;
    }

    //phuong thuc xoá sản phẩm (SanPham)
    public boolean Delete(int mahoa) {
        String sql = "delete from hoa where mahoa=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mahoa);
            int kq = ps.executeUpdate();
            if (kq > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return false;
    }

    //phuong thuc lấy thông tin sản phẩm (SanPham) theo mã hoa 
    public SanPham getById(int mahoa) {
        SanPham kq = null;
        String sql = "select * from SanPham where mahoa=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mahoa);
            rs = ps.executeQuery();
            if (rs.next()) {
                kq = new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return kq;
    }

    public static void main(String[] args) {
        SanPhamDAO hoaDao = new SanPhamDAO();
        System.out.println("Lay tat ca hoa");
        ArrayList<SanPham> dsSanPham = hoaDao.getAll();
        for (SanPham hoa : dsSanPham) {
            System.out.println(hoa);
        }

        //tìm hoa theo mahoa=1
        System.out.println("Tim hoa co mahoa=1");
        SanPham kq = hoaDao.getById(1);
        if (kq != null) {
            System.out.println(kq);
        }
    }
}
