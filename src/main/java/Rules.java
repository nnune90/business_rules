/**
 * Created by localadmin on 1/20/17.
 */
public class Rules {
    String product;
    boolean generatePackingSlip;
    boolean generatePackingSlipForRoyaltyDept;

    Rules(String product) {
        this.product = product;
        GeneratePackingSlip();
        GeneratePackingSlipForRoyaltyDept();
    }

    public void GeneratePackingSlip() {
        if(product == "Physical" || product == "Book")
        { generatePackingSlip = true; }
    }

    public void GeneratePackingSlipForRoyaltyDept() {
        if (product == "Book") {
            generatePackingSlipForRoyaltyDept = true;
        }
    }

    public boolean ActivateMembership() {
        if (product == "Membership") {
            return true;
        }
        return false;
    }

    public boolean UpgradeMembership() {
        if(product == "UpgradeMembership")
        {return true;}
        return false;
    }

    public boolean EmailOwner() {
        if(product == "Membership" || product == "UpgradeMembership")
        {
            return true;
        }
        return false;
    }

    public boolean GenerateFirstAidSlip() {
        if(product == "Learning to Ski") {
            return true;
        }
        return false;
    }

    public boolean GenerateCommissionPaymentToAgent() {
        if(product == "Physical" || product == "Book") {
            return true;
        }
        return false;
    }
}
