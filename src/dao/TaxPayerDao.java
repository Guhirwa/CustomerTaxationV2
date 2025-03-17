/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import model.TaxPayer;

/**
 *
 * @author jeremie
 */
public class TaxPayerDao {
    private String db_url = "jdbc:postgresql://localhost:5432/taxation";
    private String db_username  = "postgres";
    private String db_passwd = "postgres";
    
    public int createTaxPayer(TaxPayer taxPayerObj){
        // surround with try and catch
        try{
            // create connection
            Connection con = DriverManager.getConnection(db_url,db_username, db_passwd);
            // prepare the statement
            PreparedStatement pst = con.prepareStatement("INSERT INTO tax_payer (tin,nid,names,amount) VALUES (?,?,?,?)");
            pst.setString(1,taxPayerObj.getTin());
            pst.setString(2, taxPayerObj.getNid());
            pst.setString(3, taxPayerObj.getNames());
            pst.setDouble(4, taxPayerObj.getAmount());
            
            // execute statement
            int rowAffected = pst.executeUpdate();
            // close connection
            con.close();
            return rowAffected;
            
        }catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
        
    }
}
