/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Data.KhachHang;
import Data.classData;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author HaiTruong
 */
public class BUS_KhachHang {
    public static ArrayList<KhachHang> getInfoKhachHang() {
        ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
        classData my = new classData();
        String quenry = "Select * From KhachHang";
        try {
            my.openConnect();
            ResultSet rs = my.excuteQuery(quenry);
            while (rs.next()) {
                KhachHang KhachHang = new KhachHang();

                KhachHang.setMSKH(rs.getString("MSKH"));
                KhachHang.setHoTenKhach(rs.getString("HoTenKhach"));
                KhachHang.setDiaChiKhach(rs.getString("DiaChiKhach"));
                KhachHang.setMaSoThue(rs.getString("MaSoThue"));
                KhachHang.setTaiKhoan(rs.getString("TaiKhoan"));
                arr.add(KhachHang);

            }

        } catch (SQLException ex) {
            my.displayError(ex);
        }
        my.close();
        return arr;
    }

    
    
    public static ArrayList<KhachHang> getInfoKhachHangByID(String MSKH) {
        ArrayList<KhachHang> result = new ArrayList<>();
        String query = "select * from KhachHang where MSKH = '"+MSKH+"'";

        classData my = new classData();
        try {
            my.openConnect();
            ResultSet rs = my.excuteQuery(query);
            while (rs.next()) {
                KhachHang KhachHang = new KhachHang();

                KhachHang.setMSKH(rs.getString("MSKH"));
                KhachHang.setHoTenKhach(rs.getString("HoTenKhach"));
                KhachHang.setDiaChiKhach(rs.getString("DiaChiKhach"));
                KhachHang.setMaSoThue(rs.getString("MaSoThue"));
                KhachHang.setTaiKhoan(rs.getString("TaiKhoan"));
                result.add(KhachHang);


            }

            my.close();
        } catch (SQLException ex) {
            my.displayError(ex);
        }

        return result;
    }
    
 
    
    public static int ThemKhachHang(String MSKH, String HoTenKhach,  String DiaChiKhach, String MaSoThue, String TaiKhoan) {
        String sql = "Insert into KhachHang Values(" + MSKH + "', '" + HoTenKhach + "', '" + DiaChiKhach + "', '"+ MaSoThue + "', '" + TaiKhoan + "')";
        classData my = new classData();
        my.openConnect();
        int kq = my.executeUpdate(sql);
        my.close();
        return kq;
    }


}
