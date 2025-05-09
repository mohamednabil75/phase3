package Managers;

import Models.Asset;
import java.net.Authenticator;

import .Authenticator;

public class PolicyManager {

    public static boolean canManageAsset(Asset asset) {

        if (asset.portfolioId == Authenticator.isLoggedIn()) {
            return true;
        }
        
        return false;
    }

}
