package gol1bjon.developer.springbootapp.service;

import gol1bjon.developer.springbootapp.entity.file.FileClass;
import gol1bjon.developer.springbootapp.entity.file.FileStatus;
import gol1bjon.developer.springbootapp.mapper.FileMapper;
import gol1bjon.developer.springbootapp.payload.FileDTO;
import gol1bjon.developer.springbootapp.repository.FileRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
     private   final FileRepository fileRepository;


     private final FileMapper mapper;


     private String uploadDirectory="D:\\uploads\\";

    public FileService(FileRepository fileRepository, FileMapper mapper) {
        this.fileRepository = fileRepository;
        this.mapper = mapper;
    }
    private static String extensions ="{jpg};{png};{PNG};{jpeg};{JPEG};{mp4};{MP4};{webm};{WEBM};{gif}";

    public FileDTO save(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String generatedName = System.currentTimeMillis() + "." + extension;

        Path path = Paths.get(uploadDirectory + generatedName);

        String url = "http://localhost:8081" +"/api/v1/file/upload".concat(generatedName);

        FileClass fileClass = FileClass.builder()
                .generatedName(generatedName)
                .originalName(originalFilename)
                .fileSize(multipartFile.getSize())
                .fileStatus(FileStatus.DRAFT)
                .extension(extension)
                .uploadPath(path.toString())
                .contentType(multipartFile.getContentType())
                .url(url)
                .build();
        FileClass save = fileRepository.save(fileClass);

        return mapper.toDto(save);
    }
//
//    private String getExt(String fileName){
//        String ext = null;
//        if (fileName !=null && !fileName.isEmpty()){
//            int dot = fileName.lastIndexOf('.');
//            if (dot>0 && dot<= fileName.length()-2){
//                ext =fileName.substring(dot+1);
//            }
//        }
//        return ext;
//    }

}
