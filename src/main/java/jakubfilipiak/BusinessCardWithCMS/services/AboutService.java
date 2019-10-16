package jakubfilipiak.BusinessCardWithCMS.services;

import jakubfilipiak.BusinessCardWithCMS.mappers.AboutMapper;
import jakubfilipiak.BusinessCardWithCMS.models.AboutEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.AboutDto;
import jakubfilipiak.BusinessCardWithCMS.repositories.AboutRepository;
import jakubfilipiak.BusinessCardWithCMS.utils.AboutFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Service
public class AboutService {

    private AboutRepository aboutRepository;
    private AboutMapper aboutMapper;
    private AboutFactory aboutFactory;

    public AboutService(AboutRepository aboutRepository,
                        AboutMapper aboutMapper,
                        AboutFactory aboutFactory) {
        this.aboutRepository = aboutRepository;
        this.aboutMapper = aboutMapper;
        this.aboutFactory = aboutFactory;
    }

    public List<AboutDto> getAboutsDto() {
        List<AboutEntity> entities = aboutRepository.findAll();
        if (entities.isEmpty()) {
            AboutEntity addedEntity = addEmptyAbout();
            entities.add(addedEntity);
            return entities.stream()
                    .map(this::mapEntityToDto)
                    .collect(Collectors.toList());
        }
        if (entities.size() == 1) {
            return entities.stream()
                    .map(this::mapEntityToDto)
                    .collect(Collectors.toList());
        }
        // TODO: what when more than one 'about'?
        return null;
    }

    private AboutEntity addEmptyAbout() {
        return aboutRepository.save(new AboutEntity.AboutEntityBuilder().build());
    }

    public AboutDto mapEntityToDto(AboutEntity entity) {
        return aboutMapper.toDto(entity);
    }

    public Optional<AboutDto> mapParamsToDto(String id, String description) {
        return Optional.ofNullable(aboutFactory.dtoFromSentData(id, description));
    }

    public AboutEntity updateAbout(AboutDto aboutDto) {
        Optional<AboutEntity> aboutEntityOpt = aboutRepository.findById(UUID.fromString(aboutDto.getId()));
        if (aboutEntityOpt.isPresent()) {
            AboutEntity aboutEntityToSave = mapDtoToEntity(aboutDto);
            return aboutRepository.save(aboutEntityToSave);
        }
        return null;
    }

    private AboutEntity mapDtoToEntity(AboutDto dto) {
        return aboutMapper.toEntity(dto);
    }
}
