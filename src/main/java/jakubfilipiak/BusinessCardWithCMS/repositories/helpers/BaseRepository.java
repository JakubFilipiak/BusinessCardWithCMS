package jakubfilipiak.BusinessCardWithCMS.repositories.helpers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

/**
 * Created by Jakub Filipiak on 25.09.2019
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, UUID> {

}
