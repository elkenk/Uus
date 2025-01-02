package ee.ken.webShop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Läheb üle terve rakenduse
public class WebConfig implements WebMvcConfigurer {

    // --> see koht asendab selle, et iga controlleri päises ei peaks kirjutama
    // @CrossOrigin()
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**") // kõikidele API otspunktidele peale
                .allowedOrigins("http://localhost:3000")
                .allowedHeaders("*") // kõik headerid on lubatud
                .allowedMethods("*");
    }

}
