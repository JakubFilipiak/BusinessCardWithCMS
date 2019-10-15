package jakubfilipiak.BusinessCardWithCMS.services;

import jakubfilipiak.BusinessCardWithCMS.mappers.OfferImageMapper;
import jakubfilipiak.BusinessCardWithCMS.models.FileEntity;
import jakubfilipiak.BusinessCardWithCMS.models.OfferImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferImageDto;
import jakubfilipiak.BusinessCardWithCMS.utils.FileUrlGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Service
public class OfferImageService {

    private OfferImageMapper offerImageMapper;
    private FileUrlGenerator fileUrlGenerator;

    public OfferImageService(OfferImageMapper offerImageMapper, FileUrlGenerator fileUrlGenerator) {
        this.offerImageMapper = offerImageMapper;
        this.fileUrlGenerator = fileUrlGenerator;
    }

    public Optional<OfferImageEntity> createOfferImageEntity(FileEntity fileEntity, String imageAlt) {
        OfferImageEntity offerImageEntity = new OfferImageEntity.OfferImageEntityBuilder()
                .alt(imageAlt)
                .file(fileEntity)
                .build();
        return Optional.of(offerImageEntity);
    }

    public OfferImageDto mapEntityToDto(OfferImageEntity entity) {
        OfferImageDto dto = offerImageMapper.toDto(entity);
        String imagePath = fileUrlGenerator.generate(entity.getFile().getName());
        dto.setPath(imagePath);
        return dto;
    }
}
