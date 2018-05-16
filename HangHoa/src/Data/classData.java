/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cuhoa_000
 */
public class classData {
    private Connection conn=null;
    private Statement stm=null;
    private ResultSet rs=null;
    private CallableStatement cstmDB = null;
    private  String hostName = "localhost";
 
    private String dbName = "quanlyheo";
    private String userName = "root";
    private String password = "";
    private boolean connectDB()
    {
    boolean res=true;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        conn = DriverManager.getConnection(connectionURL, userName,
             password);
        if(conn==null)
        {
            res=false;
        }
    }
    catch(SQLException | ClassNotFoundException exc)
    {
        System.out.println("Ngoai le tai classData.Data");
        res= false;
    }
   return res;
    }
    public ResultSet getData(String str)
    {
        ResultSet res=null;
        //System.out.println(str);
        try
        {
            if(connectDB())
            {
//                cstmDB = conn.prepareCall(str);   //query in format "{? = call myfunc}"
//                res = cstmDB.executeQuery();  
                
                stm = conn.createStatement();
                res = stm.executeQuery(str);
                
            }
                    
        }
        catch(Exception exc)
        {
            res=null;
            System.out.println("Ngoai le tai ResultSet classData.Data");
        }
        return res;
    }
    public boolean updateData(String sql) throws SQLException
    {
        boolean res=true;
        try
        {
            System.out.println(sql);
            if(connectDB())
            {
               
                stm=conn.createStatement();
                stm.executeUpdate(sql);
                
            }
        }
        catch(Exception exc)
        {
            res=false;
            System.out.println("Ngoai le o updateData classData.Data");
        }
        return res;
    }

            
 

}

