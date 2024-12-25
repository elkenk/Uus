package ee.ken.webShop.controller;

import ee.ken.webShop.entity.Order;
import ee.ken.webShop.entity.OrderRow;
import ee.ken.webShop.sevice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("orders")// localhost:8080/orders?personId=1 Body --> orderRows
    public Order addOrder(@RequestParam Long personId,  @RequestBody List<OrderRow> orderRows) {
        return orderService.addOrder(personId, orderRows);
    }
}
