package org.example.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.StoreDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    private static final String outputPath = System.getProperty("user.dir") + "/output";

    public static void writeProductFiles(List<StoreDAO> stores) {
        for (StoreDAO store : stores) {
            storeProductFile(store);
        }
    }

    public static void storeProductFile(StoreDAO store) {
        ObjectMapper mapper = new ObjectMapper();

        String fileName = store.getLocationId() + "-" + store.getStoreId() + ".json";

        File file = new File(outputPath, fileName);

        try {
            FileWriter writer = new FileWriter(file);
            // Convert product list to JSON
            String json = mapper.writeValueAsString(store.getProducts());

            // Write JSON array to file
            writer.write(json);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanOutputDir() {
        File output = new File(outputPath);
        if(output.exists()) {
            File[] files = output.listFiles();
            if(files != null) {
                for(File file : files) {
                    file.delete();
                }
            }
        }
    }

}
