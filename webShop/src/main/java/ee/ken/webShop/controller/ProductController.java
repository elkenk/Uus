package ee.ken.webShop.controller;

import ee.ken.webShop.entity.Product;
import ee.ken.webShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")

public class ProductController {

    @Autowired
    ProductRepository productRepository;
//localhost:8080/public-products?category=ALL
    @GetMapping("public-products")
    public Page<Product> getPublicProducts(Pageable pageable, @RequestParam Long categoryId) {
        if (categoryId == 0){
        return productRepository.findAll(pageable);
    } else {
        return productRepository.findByCategory_IdOrderByIdAsc(categoryId, pageable);
        }
    }

    @GetMapping("products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("products")
    public List<Product> addProducts(@RequestBody Product product) {
       // if(productRepository.findById(product.getId()).isEmpty()) {
            productRepository.save(product);
     //   }
        return productRepository.findAll();
    }

    @DeleteMapping("products/{id}")
    public List<Product> deleteProducts(@PathVariable Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
    // Patch-ga saab muute ühte kindlat välja.(active-> inactive) kogus++, kogus--
    // Put võimaldab muuta kõiki välju
    @PutMapping("products")
    public List<Product> editProducts(@RequestBody Product product) {
      //  if(productRepository.findById(product.getId()).isPresent()) {
            productRepository.save(product);
    //    }
        return productRepository.findAll();
    }

    @GetMapping("product/{id}") //Ühe toote leidmiseks
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @PutMapping("product-list")
    public List<Product> getProductList(@RequestBody List<Product> products) {
        productRepository.saveAll(products);
        return productRepository.findAll();
    }
}
