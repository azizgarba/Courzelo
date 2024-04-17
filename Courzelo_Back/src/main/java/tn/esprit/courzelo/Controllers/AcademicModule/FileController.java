package tn.esprit.courzelo.Controllers.AcademicModule;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.esprit.courzelo.Services.AcedemicModuleService.Course.IfileclassService;
import tn.esprit.courzelo.entities.AcademicProgramEntities.Filecalss;
import tn.esprit.courzelo.entities.AcademicProgramEntities.ResponseData;

import java.io.IOException;

@RestController
@AllArgsConstructor
@Tag(name = "File")
public class FileController {

    private final IfileclassService ifileclassService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseData uploadFile(@RequestPart("file") MultipartFile file, @RequestParam("courseId") String courseId) throws Exception {
        Filecalss cour = null;
        String downloadURL = "";

        // Save the attachment (file) and get the Filecalss entity
        cour = ifileclassService.saveAttachment(file,courseId);

        // Build download URL
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(cour.getId())  // Make sure getId() method is available in your Filecalss entity
                .toUriString();

        return new ResponseData(cour.getFileName(),
                downloadURL, file.getContentType(), file.getSize());
    }


    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Filecalss cour = null;
        cour = ifileclassService.getAttachment(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(cour.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + cour.getFileName() + "\"")
                .body(new ByteArrayResource(cour.getData()));
    }


    @GetMapping("/content/{fileId}")
    public void getFileContent(@PathVariable String fileId, HttpServletResponse response) throws Exception {
        try {
            Filecalss attachment = ifileclassService.getAttachment(fileId);
            byte[] fileContent = attachment.getData();
            String contentType = attachment.getFileType();

            // Set the content type based on the file type
            response.setContentType(contentType);

            // Set the content disposition to inline to display content in the browser
            response.setHeader("Content-Disposition", "inline; filename=" + attachment.getFileName());

            // Write the file content to the response
            response.getOutputStream().write(fileContent);
            response.getOutputStream().flush();
        } catch (IOException e) {
            // Handle exceptions
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

