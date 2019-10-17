package jakubfilipiak.BusinessCardWithCMS.repositories;

import jakubfilipiak.BusinessCardWithCMS.models.CompanyImageEntity;
import jakubfilipiak.BusinessCardWithCMS.repositories.helpers.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Repository
public interface CompanyImageRepository extends BaseRepository<CompanyImageEntity> {

    @Query("select c from CompanyImageEntity c where c.name = ?1")
    Optional<CompanyImageEntity> findByName(String name);
}
