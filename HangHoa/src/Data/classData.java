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
public class classData 
{
     private String ulr="jdbc:sqlserver://localhost:1433;databaseName=HTKT";
     private String username="sa";
     private String password="sa";
     
     private CallableStatement cstmDB=null;
     
    private Connection con=null;
    public classData()
    {}
    public boolean ConnectDB()
    {
        boolean res=true;
        try
        {
           
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con =DriverManager.getConnection(ulr,username,password);
          
        }
        catch (Exception exc)
        {
            System.out.println("Ket noi khong thanh cong!");
            res=false;
        }
        if(con==null)
        {   res=false;   }
        return res;
    }
    private boolean closeDB()
    {
        boolean res=true;
        try
        {
            if(!con.isClosed())
            con.close();
        }
        catch(Exception exc)
        {res= false;}
        return res;
    }
    public ResultSet getData(String str)
    {
        ResultSet res=null;
        try
        {
            if(ConnectDB())
            {
                cstmDB=con.prepareCall(str);
                res=cstmDB.executeQuery();
            }
        }
        catch(Exception exc)
        {
            res=null;
            System.out.println("Ngoai le tai classData!" +exc);
        }
        finally
        {
           // closeDB();
        }
        return res;
    }
    public boolean updateData(String str)// throws SQLException
    {
        boolean res=true;
        try
        {
            if(ConnectDB())
            {
                cstmDB=con.prepareCall(str);
                cstmDB.executeUpdate();;
            }
        }
        catch(Exception exc)
        {
            res=false;
            System.out.println("Loi khi updateData!");
        }
        finally
        {closeDB();}
        return res;
    }

    
}