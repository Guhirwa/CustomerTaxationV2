package dao;

import model.TaxPayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaxPayerDao {
    private final String dbUrl = "jdbc:mysql://localhost:3306/Taxation";
    private final String dbUsername = "@Guhirwa";
    private final String dbPassword = "@Guhirwa9188@";

    // Method to create a new tax payer  
    public int createTaxPayer(TaxPayer taxPayerObj) {
        String query = "INSERT INTO TaxPayer (tin, nid, name, amount) VALUES (?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, taxPayerObj.getTin());
            pst.setString(2, taxPayerObj.getNid());
            pst.setString(3, taxPayerObj.getNames());
            pst.setDouble(4, taxPayerObj.getAmount());

            return pst.executeUpdate(); // Returns number of rows affected  
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // Method to update a tax payer  
    public int updateTaxPayer(TaxPayer taxPayer) {
        String query = "UPDATE TaxPayer SET name = ?, nid = ?, amount = ? WHERE tin = ?";
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, taxPayer.getNames());
            pst.setString(2, taxPayer.getNid());
            pst.setDouble(3, taxPayer.getAmount());
            pst.setString(4, taxPayer.getTin());

            return pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // Method to delete a tax payer  
    public int deleteTaxPayer(String tin) {
        String query = "DELETE FROM TaxPayer WHERE tin = ?";
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, tin);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // Method to search for a specific tax payer  
    public TaxPayer searchTaxPayer(String tin) {
        String query = "SELECT * FROM TaxPayer WHERE tin = ?";

        TaxPayer taxPayer = null;
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, String.valueOf(tin));
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                taxPayer = new TaxPayer();
                taxPayer.setTin(rs.getString("tin"));
                taxPayer.setNid(rs.getString("nid"));
                taxPayer.setNames(rs.getString("name"));
                taxPayer.setAmount(rs.getDouble("amount"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return taxPayer;
    }

    // Method to retrieve all tax payers  
    public List<TaxPayer> findAllTaxPayers() {
        List<TaxPayer> taxPayers = new ArrayList<>();
        String query = "SELECT * FROM TaxPayer";

        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                TaxPayer taxPayer = new TaxPayer();
                taxPayer.setTin(rs.getString("tin"));
                taxPayer.setNid(rs.getString("nid"));
                taxPayer.setNames(rs.getString("name"));
                taxPayer.setAmount(rs.getDouble("amount"));
                taxPayers.add(taxPayer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return taxPayers;
    }
}
