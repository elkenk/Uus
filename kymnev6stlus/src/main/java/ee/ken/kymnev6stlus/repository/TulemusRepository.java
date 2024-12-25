package ee.ken.kymnev6stlus.repository;

import ee.ken.kymnev6stlus.entity.Tulemus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TulemusRepository extends JpaRepository<Tulemus, Long> {

    List<Tulemus> findBySportlane_Id(Long id);
}
