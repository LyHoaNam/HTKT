/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author cuhoa_000
 */
public class classData {
       
           // Kết nối vào SQLServer.
 // (Sử dụng thư viện điều khiển SQLJDBC)
    public void displayError(SQLException ex) {
        System.out.println(" Error Message:" + ex.getMessage());
        System.out.println(" SQL State:" + ex.getSQLState());
        System.out.println(" Error Code:" + ex.getErrorCode());
    }
    public Connection conn = null; 
 
    public static Connection getSQLServerConnection(String hostName,
         String sqlInstanceName, String database, String userName,
         String password) throws ClassNotFoundException, SQLException {
 
     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
 
     Connection connect = DriverManager.getConnection(connectionURL, userName,
             password);
     return connect;
 }
 
   public static Connection getSQLServerConnection()
         throws SQLException, ClassNotFoundException {
   
     String hostName = "localhost";
     String sqlInstanceName = "HAITRUONG-PC";
     String database = "HTKTT";
     String userName = "sa";
     String password = "123";

     return getSQLServerConnection(hostName, sqlInstanceName,
             database, userName, password);
 }
   public void openConnect()
   {
              try { 
           conn = getSQLServerConnection();
           //System.out.println("Success!!!");
       } catch (SQLException ex) { System.out.println("Not Success!!!");}
       catch (ClassNotFoundException ex) { System.out.println("Not Success!!!");}
   }
   
   public ResultSet excuteQuery(String sql){// danh cho cau lenh secect 
       ResultSet rs = null; 
       try { 
           Statement stm =  (Statement) conn.createStatement(); 
           rs = stm.executeQuery(sql); 
       } catch (SQLException ex) { 
           System.out.println("Not Success!!!");
       } 
       return rs; 
   } 
    public ResultSet excuteQuery(String sql, ArrayList<Object> arr) {// danh cho cau lenh secect 
        ResultSet rs = null;
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            if (arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {
                    stm.setObject(i + 1, arr.get(i));
                }
            }

            rs = stm.executeQuery();

        } catch (SQLException ex) {
            displayError(ex);
        }
        return rs;
    }

      public int executeUpdate(String sql){// danh cho cau lenh secect 
       int row_Affected = 0; 
       try { 
           Statement stm = (Statement) conn.createStatement(); 
           row_Affected = stm.executeUpdate(sql);
       } catch (SQLException ex) { 
           System.out.println("Not Success!!!");
       } 
       return row_Affected; 
   }
   
   public void close(){// dong ket noi co so du lieu 
       try { 
           if(conn!=null) 
               conn.close(); 
       } catch (SQLException ex) { 
           System.out.println("Not Success!!!");
       } 
   } 

   
   
     public static void main(String[] args) throws SQLException,
          ClassNotFoundException {
         
   Connection con = getSQLServerConnection();

    if (con != null) {
      System.out.println("Connected");
 
      DatabaseMetaData dm = (DatabaseMetaData) con.getMetaData();
      System.out.println("Driver name: " + dm.getDriverName());
      System.out.println("Driver version: " + dm.getDriverVersion());
      System.out.println("Product name: " + dm.getDatabaseProductName());
      System.out.println("Product version: " + dm.getDatabaseProductVersion()); 
    }
    else {
     System.err.println("Cannot connect database!!");
   }
  }

}

