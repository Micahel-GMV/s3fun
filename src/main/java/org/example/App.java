package org.example;

import org.apache.commons.lang3.time.StopWatch;
import org.example.dao.StoreDAO;
import org.example.tools.FileUtils;
import org.example.tools.ProductListGenerator;
import org.example.tools.StoreListGenerator;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        new FileUtils().cleanOutputDir();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // Generate stores
        List<StoreDAO> stores = new StoreListGenerator().generateStores(256, 10);

        // Add 5 products to each store
        new ProductListGenerator().addFlushProducts(stores, 13000, 5120);

        stopWatch.stop();
        System.out.println("Files generated in " + stopWatch.getTime() + " ms");

    }
}
