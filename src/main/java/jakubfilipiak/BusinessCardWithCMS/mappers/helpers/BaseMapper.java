package jakubfilipiak.BusinessCardWithCMS.mappers.helpers;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
public interface BaseMapper<F, T> {

    T toDto(F entity);

    F toEntity(T dto);
}
