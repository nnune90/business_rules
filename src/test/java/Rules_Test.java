import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by localadmin on 1/20/17.
 */

//If the payment is for a physical product, generate a packing slip for shipping.
public class Rules_Test {
    @Test
    public void GeneratePackingSlip() {
        Rules rule = new Rules("Physical");
        assertTrue(rule.generatePackingSlip);

        Rules rule2 = new Rules("Membership");
        assertFalse(rule2.generatePackingSlip);
    }

    //If the payment is for a book, create a duplicate packing slip for the royalty department.
    @Test
    public void GenerateDuplicatePackingSlip_Book() {
        Rules rule = new Rules("Book");

        assertTrue(rule.generatePackingSlip);
        assertTrue(rule.generatePackingSlipForRoyaltyDept);

        Rules rule2 = new Rules("Physical");
        assertFalse(rule2.generatePackingSlipForRoyaltyDept);
    }

    //If the payment is for a membership, activate that membership.
    @Test
    public void ActivateMembership(){
        Rules rule = new Rules("Membership");
        assertTrue(rule.ActivateMembership());

        Rules rule2 = new Rules("UpgradeMembership");
        assertFalse(rule2.ActivateMembership());
    }

    //If the payment is an upgrade to a membership, apply the upgrade.
    @Test
    public void UpgradeMembership(){
        Rules rule = new Rules("UpgradeMembership");
        assertTrue(rule.UpgradeMembership());

        Rules rule2 = new Rules("Membership");
        assertFalse(rule2.UpgradeMembership());
    }

    //If the payment is for a membership or upgrade, e-mail the owner and inform them of the activation/upgrade.
    @Test
    public void EmailOwner_MembershipRule() {
        Rules rule = new Rules("UpgradeMembership");
        assertTrue(rule.EmailOwner());

        Rules rule2 = new Rules("Membership");
        assertTrue(rule2.EmailOwner());

        Rules rule3 = new Rules("Book");
        assertFalse(rule3.EmailOwner());
    }

    //If the payment is for the video “Learning to Ski,” add a free “First Aid” video to the packing slip (the result of a court decision in 1997).
    @Test
    public void AddAidPackingSlip() {
        Rules rule = new Rules("Learning to Ski");
        assertTrue(rule.GenerateFirstAidSlip());

        Rules rule2 = new Rules("Book");
        assertFalse(rule2.GenerateFirstAidSlip());
    }

    //If the payment is for a physical product or a book, generate a commission payment to the agent.
    @Test
    public void GenerateCommissionPaymentToAgent() {
        Rules rule = new Rules("Physical");
        assertTrue(rule.GenerateCommissionPaymentToAgent());

        Rules rule2 = new Rules("Book");
        assertTrue(rule2.GenerateCommissionPaymentToAgent());

        Rules rule3 = new Rules("Membership");
        assertFalse(rule3.GenerateCommissionPaymentToAgent());
    }

}
