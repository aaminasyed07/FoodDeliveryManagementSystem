
package com.FoodDeliveryManagementSystem.persistance;

import com.FoodDeliveryManagementSystem.model.Order;
import com.FoodDeliveryManagementSystem.service.OrderData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Json {

    public static void saveOrder(Order order) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        OrderData data = new OrderData(order);

        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File("order.json"), data);

        System.out.println("Order saved successfully!");
    }
}
