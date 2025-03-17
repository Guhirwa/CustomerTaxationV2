/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jeremie
 */
public class TaxPayer {
    // Private variables
    private String names;
    private String tin;
    private String nid;
    private Double amount;

    public TaxPayer() {
    }

    public TaxPayer(String names, String tin, String nid, Double amount) {
        this.names = names;
        this.tin = tin;
        this.nid = nid;
        this.amount = amount;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
    
}
