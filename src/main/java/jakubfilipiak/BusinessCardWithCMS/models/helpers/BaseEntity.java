package jakubfilipiak.BusinessCardWithCMS.models.helpers;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Jakub Filipiak on 20.09.2019
 */
@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private final UUID id = UUID.randomUUID();


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object that) {
        return this == that || (that instanceof BaseEntity
                && Objects.equals(id, ((BaseEntity) that).id));
    }
}
