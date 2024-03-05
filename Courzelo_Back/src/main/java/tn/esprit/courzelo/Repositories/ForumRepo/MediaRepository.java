package tn.esprit.courzelo.Repositories.ForumRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.courzelo.entities.ForumEntities.DatabaseSequence;
import tn.esprit.courzelo.entities.ForumEntities.Media;
import tn.esprit.courzelo.entities.ForumEntities.MediaType;


import java.util.Optional;


public interface MediaRepository extends MongoRepository<Media, String> {

    Optional<Media> findOneByUserIdAndMediaType(String userId, MediaType mediaType);

    void deleteAllByUserIdAndMediaType(String userId, MediaType mediaType);
    Media findMediaById(String id );


}

