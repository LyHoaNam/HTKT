/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Data.CTHD;
import Data.classData;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author HaiTruong
 */
public class BUS_CTHD {
     public static ArrayList<CTHD> getInfoCTHD() {
        ArrayList<CTHD> arr = new ArrayList<CTHD>();
        classData my = new classData();
        String quenry = "Select * From CTHD";
        try {
            my.openConnect();
            ResultSet rs = my.excuteQuery(quenry);
            while (rs.next()) {
                CTHD CTHD = new CTHD();

                CTHD.setMaHD(rs.getString("MaHD"));
                CTHD.setMSHH(rs.getString("setMSHH"));
                CTHD.setSoLuong(rs.getInt("SoLuong"));
                CTHD.setDonGia(rs.getFloat("DonGia"));
                arr.add(CTHD);

            }

        } catch (SQLException ex) {
            my.displayError(ex);
        }
        my.close();
        return arr;
    }

    
    
    public static ArrayList<CTHD> getInfoCTHDByID(String MaHD) {
        ArrayList<CTHD> result = new ArrayList<>();
        String query = "select * from CTHD where MaHD = '"+MaHD+"'";

        classData my = new classData();
        try {
            my.openConnect();
            ResultSet rs = my.excuteQuery(query);
            while (rs.next()) {
                CTHD CTHD = new CTHD();

                CTHD.setMaHD(rs.getString("MaHD"));
                CTHD.setMSHH(rs.getString("setMSHH"));
                CTHD.setSoLuong(rs.getInt("SoLuong"));
                CTHD.setDonGia(rs.getFloat("DonGia"));
                result.add(CTHD);


            }

            my.close();
        } catch (SQLException ex) {
            my.displayError(ex);
        }

        return result;
    }
    
 
    
    public static int ThemCTHD(String MaHD, String MSHH,  int SoLuong, float DonGia) {
        String sql = "Insert into CTHD Values(" + MaHD + "', '" + MSHH + "', '" + SoLuong + "', '"+ DonGia + "')";
        classData my = new classData();
        my.openConnect();
        int kq = my.executeUpdate(sql);
        my.close();
        return kq;
    }

}
