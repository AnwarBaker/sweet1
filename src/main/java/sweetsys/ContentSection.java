package sweetsys;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ContentSection {

    private static final Logger logger = Logger.getLogger(ContentSection.class.getName());
    public static final boolean IN=false;

    public void updateUserrecipes(UserShareProducts pro) {
        boolean found = false;
        for (int i = 0; i < UserShareProducts.getUserproducts().size(); i++) {
            if (UserShareProducts.getUserproducts().get(i).getProductName().equalsIgnoreCase(pro.getProductName())) {
                UserShareProducts.getUserproducts().set(i, pro);
                found = true;
                break;
            }
        }
        UserShareProducts.setUserproducts(UserShareProducts.getUserproducts());

        if (!found) {
            logger.log(Level.WARNING, "You entered wrong details, try again.");
        }
    }

    public void deleteUserrecipes(UserShareProducts pro) {
        boolean found = false;
        for (int i = 0; i < UserShareProducts.getUserproducts().size(); i++) {
            if (UserShareProducts.getUserproducts().get(i).getProductName().equalsIgnoreCase(pro.getProductName())) {
                UserShareProducts.getUserproducts().remove(i);
                found = true;
                break;
            }
        }
        UserShareProducts.setUserproducts(UserShareProducts.getUserproducts());

        if (!found) {
            logger.log(Level.WARNING, "Non-existent product.");
        }
    }
}
