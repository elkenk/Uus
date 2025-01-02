package ee.ken.kymnev6stlus.repository;

import ee.ken.kymnev6stlus.entity.Sportlane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportlaneRepository extends JpaRepository<Sportlane, Long> {

   Page<Sportlane> findAllByOrderByIdAsc(Pageable pageable);
   //List<Sportlane> findByNameOrderByNameAsc(String name, Pageable pageable);
}
