package jakubfilipiak.BusinessCardWithCMS.services;

import jakubfilipiak.BusinessCardWithCMS.mappers.CompanyImageMapper;
import jakubfilipiak.BusinessCardWithCMS.models.CompanyImageEntity;
import jakubfilipiak.BusinessCardWithCMS.models.FileEntity;
import jakubfilipiak.BusinessCardWithCMS.models.dto.CompanyImageDto;
import jakubfilipiak.BusinessCardWithCMS.repositories.CompanyImageRepository;
import jakubfilipiak.BusinessCardWithCMS.utils.CompanyImageFactory;
import jakubfilipiak.BusinessCardWithCMS.utils.CompanyImageName;
import jakubfilipiak.BusinessCardWithCMS.utils.FileUrlGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static jakubfilipiak.BusinessCardWithCMS.utils.CompanyImageName.fromString;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Service
public class CompanyImageService {

    private CompanyImageRepository companyImageRepository;
    private FileService fileService;
    private CompanyImageMapper companyImageMapper;
    private CompanyImageFactory companyImageFactory;
    private FileUrlGenerator fileUrlGenerator;

    public CompanyImageService(CompanyImageRepository companyImageRepository,
                               FileService fileService,
                               CompanyImageMapper companyImageMapper,
                               CompanyImageFactory companyImageFactory,
                               FileUrlGenerator fileUrlGenerator) {
        this.companyImageRepository = companyImageRepository;
        this.fileService = fileService;
        this.companyImageMapper = companyImageMapper;
        this.companyImageFactory = companyImageFactory;
        this.fileUrlGenerator = fileUrlGenerator;
    }

    public CompanyImageDto getCompanyImageDtoByName(String name) throws IllegalArgumentException {
        checkCompanyImageNameCorrectness(name);
        String nameAccordingToConvention = createNameAccordingToConvention(name);
        Optional<CompanyImageEntity> companyImageEntityOpt = companyImageRepository.findByName(
                nameAccordingToConvention);
        if (companyImageEntityOpt.isPresent())
            return mapEntityToDto(companyImageEntityOpt.get());
        CompanyImageEntity addedEntity = addEmptyCompanyImageByName(nameAccordingToConvention);
        return companyImageMapper.toDto(addedEntity);
    }

    private CompanyImageEntity addEmptyCompanyImageByName(String name) {
        return companyImageRepository.save(
                new CompanyImageEntity.CompanyImageEntityBuilder()
                        .name(name)
                        .build());
    }

    private String createNameAccordingToConvention(String name) {
        return CompanyImageName.fromString(name).get().toString();
    }

    private void checkCompanyImageNameCorrectness(String name) throws IllegalArgumentException {
        if (!isCompanyImageNameCorrect(name)) throw new IllegalArgumentException();
    }

    private boolean isCompanyImageNameCorrect(String name) {
        Optional<CompanyImageName> correctName = CompanyImageName.fromString(name);
        return correctName.isPresent();
    }

    public CompanyImageDto mapEntityToDto(CompanyImageEntity entity) {
        CompanyImageDto dto = companyImageMapper.toDto(entity);
        if (entity.getFile() != null) {
            String imagePath = fileUrlGenerator.generate(entity.getFile().getName());
            dto.setPath(imagePath);
        }
        return dto;
    }

    public Optional<CompanyImageDto> mapParamsToDto(String id, String name, String alt) {
        return Optional.ofNullable(companyImageFactory.dtoFromSentData(id, name, alt));
    }

    public CompanyImageEntity updateCompanyImage(CompanyImageDto companyImageDto, MultipartFile file) throws IOException {
        Optional<CompanyImageEntity> companyImageEntityOpt = companyImageRepository.findById(
                UUID.fromString(companyImageDto.getId()));
        if (companyImageEntityOpt.isPresent()) {
            if (companyImageDto.getName().equalsIgnoreCase(companyImageEntityOpt.get().getName())) {
                companyImageDto.setName(createNameAccordingToConvention(companyImageDto.getName()));
                CompanyImageEntity companyImageEntityToSave = mapDtoToEntity(companyImageDto);
                if (file != null) {
                    Optional<FileEntity> fileEntityOpt = fileService.createFileEntity(file);
                    if (fileEntityOpt.isPresent()) {
                        companyImageEntityToSave.setFile(fileEntityOpt.get());
                    } else {
                        throw new IOException("Error when saving file");
                    }
                }
                return companyImageRepository.save(companyImageEntityToSave);
            }
        }
        return null;
    }

    private CompanyImageEntity mapDtoToEntity(CompanyImageDto dto) {
        return companyImageMapper.toEntity(dto);
    }
}
