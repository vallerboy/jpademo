package pl.oskarpolak.jpademo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.jpademo.models.BarcodeEntity;

@Repository
public interface BarcodeRepository extends CrudRepository<BarcodeEntity, Integer> {
}
