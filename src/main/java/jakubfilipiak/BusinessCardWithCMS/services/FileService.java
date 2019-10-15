package jakubfilipiak.BusinessCardWithCMS.services;

import jakubfilipiak.BusinessCardWithCMS.models.FileEntity;
import jakubfilipiak.BusinessCardWithCMS.repositories.FileRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Jakub Filipiak on 27.09.2019
 */
@Service
public class FileService {

    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Value("${custom.storage.path}")
    private String storagePath;

    public Optional<FileEntity> createFileEntity(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String uniqueFileName = createUniqueName(originalFileName);
        String fullPathName = createFullPathName(uniqueFileName);
        try {
            saveMultipartFile(file, fullPathName);
            FileEntity fileEntity = new FileEntity.FileEntityBuilder()
                    .name(uniqueFileName)
                    .originalName(originalFileName)
                    .build();
            return Optional.of(fileEntity);
        } catch (IOException e) {
            deleteLocalFile(fullPathName);
            return Optional.empty();
        }
    }

    private String createUniqueName(String originalFileName) {
        return UUID.randomUUID().toString() + retrieveFileExtension(originalFileName);
    }

    private String retrieveFileExtension(String fileName) {
        int extensionStartIndex = fileName.lastIndexOf(".");
        return fileName.substring(extensionStartIndex);
    }

    private String createFullPathName(String uniqueFileName) {
        return storagePath + uniqueFileName;
    }

    private void saveMultipartFile(MultipartFile file, String fullPathName) throws IOException {
        InputStream fileStream = file.getInputStream();
        File targetFile = new File(fullPathName);
        FileUtils.copyInputStreamToFile(fileStream, targetFile);
    }

    private void deleteLocalFile(String fullPathName) {
        File file = new File(fullPathName);
        if (file.exists()) file.delete();
    }

    public void undoFileEntityCreation(FileEntity fileEntity) {
        deleteLocalFile(createFullPathName(fileEntity.getName()));
    }

    public Optional<File> getLocalFileByName(String name) {
        Optional<FileEntity> fileEntityOpt = getFileByName(name);
        if (fileEntityOpt.isPresent()) {
            FileEntity fileEntity = fileEntityOpt.get();
            String localFilePath = createLocalPath(fileEntity.getName());
            return Optional.of(new File(localFilePath));
        }
        return Optional.empty();
    }

    public String createLocalPath(String fileName) {
        return storagePath + fileName;
    }

    private Optional<FileEntity> getFileByName(String name) {
        return fileRepository.findByName(name);
    }
}
