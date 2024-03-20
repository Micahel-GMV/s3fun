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
        int numStores = 256;
        new FileUtils().cleanOutputDir();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // Generate stores
        List<StoreDAO> stores = new StoreListGenerator().generateStores(numStores, 10);

        // Add 5 products to each store
        new ProductListGenerator().addFlushProducts(stores, 130000, 2048);

        stopWatch.stop();
        System.out.println("Files generated in " + stopWatch.getTime() + " ms" + " it is " + stopWatch.getTime()/numStores + " per store.");

    }
}
