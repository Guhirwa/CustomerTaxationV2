package model;

/**
 * Represents a tax payer model with properties and their getters/setters.
 */
public class TaxPayer {
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

    // Getters and Setters
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
