package tn.esprit.courzelo.Services.AcedemicModuleService.Course;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Filecalss;

public interface IfileclassService {

    Filecalss saveAttachment(MultipartFile file, String courseId) throws Exception;
    Filecalss getAttachment(String fileId) throws Exception;
    byte[] getAttachmentContent(String fileId) throws Exception;
}
