package ee.ken.webShop.controller;

import ee.ken.webShop.entity.Category;
import ee.ken.webShop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("categories")
    public List<Category> addCategory(@RequestBody Category category) {
        // if(categoryRepository.findById(category.getId()).isEmpty()) {
        categoryRepository.save(category);
    //}
        return categoryRepository.findAll();
    }

    @DeleteMapping("categories/{id}")
    public List<Category> deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return categoryRepository.findAll();
    }
    // Patch-ga saab muute ühte kindlat välja.(active-> inactive) kogus++, kogus--
    // Put võimaldab muuta kõiki välju
    @PutMapping("categories")
    public List<Category> editCategory(@RequestBody Category category) {
       // if(categoryRepository.findById(category.getId()).isPresent()) {
            categoryRepository.save(category);
      //  }
        return categoryRepository.findAll();
    }

    @GetMapping("category/{id}") //Ühe toote leidmiseks
    public Category getCategoriy(@PathVariable Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}
