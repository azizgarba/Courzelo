package tn.esprit.courzelo.Services.ForumService;

import lombok.AllArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.courzelo.Repositories.ForumRepo.MediaRepository;
import tn.esprit.courzelo.entities.ForumEntities.Media;
import tn.esprit.courzelo.entities.ForumEntities.MediaType;

@Service
@AllArgsConstructor
public class MediaServiceImpl {
    MediaRepository mediaRepository;

    public String uploadMessageMedia(Integer chatId, MultipartFile file, MediaType mediaType, String userId,
                                     String fileType)
            throws Exception {
        Media media = new Media();

        if (userId == null) {
            throw new Exception("Every media must have a userId");
        }

        if (chatId == null) {
            throw new Exception("Message media must contain a chatId");
        }

        media.setUserId(userId);
        media.setFileType(fileType);
        media.setPicture(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));

        String title = "uploaded media";
        if (file.getOriginalFilename() != null) {
            title = file.getOriginalFilename().replaceAll(" ", "-");
        }
        media.setTitle(title);
        media.setChatId(chatId);
        media.setMediaType(mediaType);

        String mediaId = mediaRepository.insert(media).getId();

        if (mediaId == null) {
            throw new Exception("Unable to upload media");
        }
        return mediaId;
    }

    public Media getMedia(String userId, MediaType mediaType) {
        return mediaRepository.findOneByUserIdAndMediaType(userId, mediaType).get();
    }

    public Media getMediaById(String mediaId) {
        return mediaRepository.findMediaById(mediaId);
    }

}


