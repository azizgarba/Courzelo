package tn.esprit.courzelo.Services.AcedemicModuleService.Course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.courzelo.Repositories.ModuleRepo.CourseRepo;
import tn.esprit.courzelo.Repositories.ModuleRepo.Filerepo;

import tn.esprit.courzelo.entities.AcademicProgramEntities.Course;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Filecalss;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Module;

import java.io.IOException;


@Service
@Slf4j
@RequiredArgsConstructor
public class fileclassImpl implements IfileclassService {
    private final Filerepo filerepo;
    private  final CourseRepo courseRepo;


    @Override
    public Filecalss saveAttachment(MultipartFile file, String courseId) throws Exception {
        Course course = courseRepo.findById(courseId).orElseThrow(() ->
                new IllegalArgumentException("No course found with this id " + courseId));

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence " + fileName);
            }

            String contentType = file.getContentType();
            byte[] fileData = file.getBytes();

            Filecalss attachment = new Filecalss(fileName, contentType, fileData);
            attachment.setCourse(course);  // Associate the file with the course

            return filerepo.save(attachment);

        } catch (IOException e) {
            throw new Exception("Could not save file: " + fileName, e);
        }
    }

    @Override
    public byte[] getAttachmentContent(String fileId) throws Exception {
        Filecalss attachment = filerepo.findById(fileId).orElseThrow(() ->
                new IllegalArgumentException("No file found with this id " + fileId));

        return attachment.getData();
    }
    @Override
    public Filecalss getAttachment(String fileId) throws Exception {
        return filerepo
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }


    // New method to get content by file ID
    public byte[] getContent(String fileId) throws Exception {
        Filecalss attachment = getAttachment(fileId);
        return attachment.getData();
    }


}
