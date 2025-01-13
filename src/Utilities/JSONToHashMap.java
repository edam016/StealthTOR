package Utilities;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONToHashMap {

    public static Map<String, List<String>> parseJsonToHashMap(String filePath) {
        Map<String, List<String>> destinationMap = new HashMap<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            content = content.trim().substring(1, content.length() - 1);
            String[] orders = content.split("},");
            for (String order : orders) {
                order = order.trim();
                if (order.endsWith("}")) {
                    order = order.substring(0, order.length() - 1);
                }
                String[] parts = order.split(":", 2);
                if (parts.length < 2) {
                    System.out.println("Invalid Order Entry: " + order);
                    continue;
                }
                String orderId = parts[0].trim().replace("\"", ""); 
                String details = parts[1].trim();


                String destination = details.split(":")[1].trim().replace("\"", ""); 
                destinationMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(orderId);
            }
        } catch (Exception e) {
            System.out.println("Error processing JSON: " + e.getMessage());
            e.printStackTrace(); 
        }
        return destinationMap;
    }
}