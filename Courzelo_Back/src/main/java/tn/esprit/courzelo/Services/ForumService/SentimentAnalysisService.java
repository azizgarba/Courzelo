package tn.esprit.courzelo.Services.ForumService;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tn.esprit.courzelo.configurations.Pipeline;
import tn.esprit.courzelo.entities.UserCorzelo.UserCourzelo;


import java.util.List;

@Service
public class SentimentAnalysisService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SentimentAnalysisService.class);
    private StanfordCoreNLP stanfordCoreNLP;
    private SimpMessagingTemplate messagingTemplate;

    public SentimentAnalysisService() {
        stanfordCoreNLP = Pipeline.getPipeline();
    }

    public String analyzeSentiment(String text) {
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreSentence> sentences = coreDocument.sentences();
        for (CoreSentence sentence : sentences) {
            String sentiment = sentence.sentiment();
            if (sentiment.equals("Negative")) {
                LOGGER.info("Sentiment: {} - Sentence: {}", sentiment, sentence);
                // Construct the notification message
                String notificationMessage = "CCaution: Your message "+"'"+sentence+"'" +" contains negative sentiment. Please consider revising your wording for a more positive tone. "  ;
                return notificationMessage; // Return the notification message
            }
            LOGGER.info("No negative sentiment found in the message");
        }
        return null; // Return null if no negative sentiment is detected in the text
    }

 /*public String analyzeSentiment(String text) {
     CoreDocument coreDocument = new CoreDocument(text);
     stanfordCoreNLP.annotate(coreDocument);
     List<CoreSentence> sentences = coreDocument.sentences();
     for (CoreSentence sentence : sentences) {
         String sentiment = sentence.sentiment();
         LOGGER.info("Sentiment: {} - Sentence: {}", sentiment, sentence);
         return sentiment; // Retourne le premier sentiment détecté dans le texte
     }
     return null; // Retourne null si aucun sentiment n'est détecté
 }*/

}
