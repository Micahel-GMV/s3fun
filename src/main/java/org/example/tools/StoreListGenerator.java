package org.example.tools;

import org.example.dao.StoreDAO;

import java.util.ArrayList;
import java.util.List;

public class StoreListGenerator {
    public static List<StoreDAO> generateStores(int numStores, int numLocales) {

        List<StoreDAO> stores = new ArrayList<>();

        int storesPerLocale = (int) Math.ceil(numStores / numLocales);
        int currentLocaleStores = 1;
        int currentLocale = 1;

        for (int i = 1; i <= numStores; i++) {
                StoreDAO store = new StoreDAO();
                store.setStoreId(i);
                store.setLocationId(currentLocale);
                stores.add(store);
                if (++currentLocaleStores > storesPerLocale) {
                    currentLocaleStores = 1;
                    currentLocale++;
                }
        }

        return stores;

    }

}
