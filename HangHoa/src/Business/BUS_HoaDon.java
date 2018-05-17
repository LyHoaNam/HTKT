/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Data.HoaDon;
import Data.classData;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author HaiTruong
 */
public class BUS_HoaDon {
        public static ArrayList<HoaDon> getInfoHoaDon() {
        ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
        classData my = new classData();
        String quenry = "Select * From HoaDon";
        try {
            my.openConnect();
            ResultSet rs = my.excuteQuery(quenry);
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();

                HoaDon.setMaHD(rs.getString("MaHD"));
                HoaDon.setThueSuat(rs.getString("ThueSuat"));
                HoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                HoaDon.setMSCH(rs.getString("MSCH"));
                HoaDon.setMSKH(rs.getString("MSKH"));
                HoaDon.setSoseri(rs.getString("Soseri"));
                HoaDon.setType(rs.getInt("type"));
                HoaDon.setNgayTao(rs.getDate("NgayTao"));
                arr.add(HoaDon);

            }

        } catch (SQLException ex) {
            my.displayError(ex);
        }
        my.close();
        return arr;
    }

    
    
    public static ArrayList<HoaDon> getInfoHoaDonByID(String MaHD) {
        ArrayList<HoaDon> result = new ArrayList<>();
        String query = "select * from HoaDon where MaHD = '"+MaHD+"'";

        classData my = new classData();
        try {
            my.openConnect();
            ResultSet rs = my.excuteQuery(query);
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();

                HoaDon.setMaHD(rs.getString("MaHD"));
                HoaDon.setThueSuat(rs.getString("ThueSuat"));
                HoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                HoaDon.setMSCH(rs.getString("MSCH"));
                HoaDon.setMSKH(rs.getString("MSKH"));
                HoaDon.setSoseri(rs.getString("Soseri"));
                HoaDon.setType(rs.getInt("type"));
                HoaDon.setNgayTao(rs.getDate("NgayTao"));
                result.add(HoaDon);


            }

            my.close();
        } catch (SQLException ex) {
            my.displayError(ex);
        }

        return result;
    }
    
 
    
    public static int ThemHoaDon(String MaHD, String ThueSuat,  Date NgayThanhToan, String MSCH, String MSKH,  String Soseri,  int type, Date NgayTao) {
        String sql = "Insert into HoaDon Values(" + MaHD + "', '" + ThueSuat + "', '" + NgayThanhToan + "', '"+ MSCH + "', '" + MSKH + "', " + type + ", '"+ NgayTao + "')";
        classData my = new classData();
        my.openConnect();
        int kq = my.executeUpdate(sql);
        my.close();
        return kq;
    }
}
