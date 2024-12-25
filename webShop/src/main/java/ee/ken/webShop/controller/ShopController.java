package ee.ken.webShop.controller;

import ee.ken.webShop.entity.Shop;
import ee.ken.webShop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    @GetMapping("shops")
    public List<Shop> getShops() {
        return shopRepository.findAll();
    }

    @PostMapping("shops")
    public List<Shop> addShop(@RequestBody Shop shop) {
        shopRepository.save(shop);
        return shopRepository.findAll();
    }

    @DeleteMapping("shops/{id}")
    public List<Shop> deleteShop(@PathVariable Long id) {
        shopRepository.deleteById(id);
        return shopRepository.findAll();
    }

    @PutMapping("shops")
    public List<Shop> editShop(@RequestBody Shop shop) {
        shopRepository.save(shop);
        return shopRepository.findAll();
    }

    @GetMapping("shops/{id}")
    public Shop getShop(@PathVariable Long id) {
        return shopRepository.findById(id).orElseThrow();
    }
}
