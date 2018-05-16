/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author cuhoa_000
 */
import Data.classData;
import java.sql.ResultSet;
public class NhatKyBanHangBUS {
    classData DB=new classData();
    public ResultSet getHoaDon()
    {
        String sql="Select * from HoaDon";
        return DB.getData(sql);
    }
}
