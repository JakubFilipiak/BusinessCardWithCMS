package jakubfilipiak.BusinessCardWithCMS.repositories;

import jakubfilipiak.BusinessCardWithCMS.models.FileEntity;
import jakubfilipiak.BusinessCardWithCMS.repositories.helpers.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@Repository
public interface FileRepository extends BaseRepository<FileEntity> {

    @Query("select f from FileEntity f where f.name = ?1")
    Optional<FileEntity> findByName(String name);
}
