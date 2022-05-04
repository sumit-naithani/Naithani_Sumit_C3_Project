import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {
    OrderService orderService = new OrderService();
    RestaurantService service = new RestaurantService();
    Restaurant restaurant;


    @BeforeEach
    void init() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = service.addRestaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup", 119);
        restaurant.addToMenu("Vegetable lasagne", 269);
        restaurant.addToMenu("Dal Makhhani", 500);
    }

    @Test
    public void getting_order_total_for_list_of_items_from_mennu() throws itemNotFoundException {
        List<String> orderItems = new ArrayList<>();
        orderItems.add("Sweet corn soup");
        orderItems.add("Vegetable lasagne");
        assertEquals(388, orderService.getOrderTotal(orderItems));
    }
}
