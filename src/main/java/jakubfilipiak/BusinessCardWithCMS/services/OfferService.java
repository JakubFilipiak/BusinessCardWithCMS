package jakubfilipiak.BusinessCardWithCMS.services;

import jakubfilipiak.BusinessCardWithCMS.mappers.OfferMapper;
import jakubfilipiak.BusinessCardWithCMS.models.FileEntity;
import jakubfilipiak.BusinessCardWithCMS.models.OfferEntity;
import jakubfilipiak.BusinessCardWithCMS.models.OfferImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferDto;
import jakubfilipiak.BusinessCardWithCMS.models.dto.OfferImageDto;
import jakubfilipiak.BusinessCardWithCMS.repositories.OfferRepository;
import jakubfilipiak.BusinessCardWithCMS.utils.OfferFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Service
public class OfferService {

    private OfferRepository offerRepository;
    private FileService fileService;
    private OfferImageService offerImageService;
    private OfferMapper offerMapper;
    private OfferFactory offerFactory;

    public OfferService(OfferRepository offerRepository,
                        FileService fileService,
                        OfferImageService offerImageService,
                        OfferMapper offerMapper,
                        OfferFactory offerFactory) {
        this.offerRepository = offerRepository;
        this.fileService = fileService;
        this.offerImageService = offerImageService;
        this.offerMapper = offerMapper;
        this.offerFactory = offerFactory;
    }

    public List<OfferDto> getOffersDto() {
        return offerRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public OfferEntity addOffer(OfferDto offerDto, MultipartFile file) throws IOException {
        OfferEntity offerEntity = offerMapper.toEntity(offerDto);
        if (isSaveWithImage(offerDto, file)) {
            Optional<FileEntity> fileEntityOpt = fileService.createFileEntity(file);
            if (fileEntityOpt.isPresent()) {
                Optional<OfferImageEntity> offerImageEntityOpt = offerImageService
                        .createOfferImageEntity(fileEntityOpt.get(), offerDto.getImage().getAlt());
                if (offerImageEntityOpt.isPresent()) {
                    offerEntity.setImage(offerImageEntityOpt.get());
                } else {
                    fileService.undoFileEntityCreation(fileEntityOpt.get());
                    throw new UnknownError("Error when creating OfferImageEntity");
                }
            } else {
                throw new IOException("Error when saving file");
            }
        }
        System.out.println(offerEntity);
        return offerRepository.save(offerEntity);
    }

    private boolean isSaveWithImage(OfferDto offerDto, MultipartFile file) {
        return offerDto.getImage().getAlt() != null && file != null;
    }

    public Optional<OfferDto> mapParamsToDto(String title, String description, String offerImageAlt) {
        return Optional.ofNullable(offerFactory.dtoFromSentData(title, description, offerImageAlt));
    }

    public OfferDto mapEntityToDto(OfferEntity entity) {
        OfferDto dto = offerMapper.toDto(entity);
        if (entity.getImage() != null)
        dto.setImage(offerImageService.mapEntityToDto(entity.getImage()));
        return dto;
    }
}
