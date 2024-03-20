package org.example.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.ProductDAO;
import org.example.dao.StoreDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ProductListGenerator {
    private static Random random = new Random();

    public static void addProducts(StoreDAO store, int numProducts, int memoSize) {
        for(int i=0; i<numProducts; i++) {
            ProductDAO product = generateRandomProduct(i, store, memoSize);
            if (store.getProducts() == null) {
                store.setProducts(new java.util.ArrayList<ProductDAO>());
            }
            store.getProducts().add(product);
        }
    }

    public static void addProducts(List<StoreDAO> stores, int numProducts, int memoSize) {
        for(StoreDAO store:stores) {
            addProducts(store, numProducts, memoSize);
        }
    }

    public static void addFlushProducts(List<StoreDAO> stores, int numProducts, int memoSize) {
        stores.parallelStream().forEach(store -> {
            addProducts(store, numProducts, memoSize);
            FileUtils.storeProductFile(store);
            store.setProducts(null);
            System.out.println(store.getStoreId() + " store generated and flushed");
        });
    }

    private static String randomString(int length) {

        int leftLimit = 97; // ' '
        int rightLimit = 122; // '~'

        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit +
                    (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char)randomLimitedInt);
        }
        return buffer.toString();
    }

    private static ProductDAO generateRandomProduct(int productId, StoreDAO store, int memoSize) {
        ProductDAO product = new ProductDAO();
        product.setProductId(productId);
        product.setStoreId(store.getStoreId());
        product.setLocationId(store.getLocationId());
        // Generate random field values
        product.setPrice(random.nextDouble() * 100);
        product.setDiscount(random.nextDouble() * 0.5);
        product.setMemo(randomString(memoSize));
        return product;
    }
}
