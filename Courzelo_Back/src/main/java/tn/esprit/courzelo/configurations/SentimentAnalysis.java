package tn.esprit.courzelo.configurations;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.simple.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.simple.Sentence;



import javax.xml.bind.JAXBContext;
import java.util.ArrayList;
import java.util.List;

import static tn.esprit.courzelo.configurations.Pipeline.getPipeline;
import static tn.esprit.courzelo.configurations.Pipeline.propertiesName;


import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

import java.util.*;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import java.util.ArrayList;
import java.util.List;

public class SentimentAnalysis {
    private static final Logger LOGGER = LoggerFactory.getLogger(SentimentAnalysis.class);




    public String summarizeText(String text) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
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

    public static void main(String[] args) {
        // Set up Stanford CoreNLP pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,natlog,openie,sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Text to summarize
        String text = "Love is an ethereal force that transcends boundaries and defies rationality. It is a symphony of emotions, weaving together passion, tenderness, and vulnerability into a tapestry of connection. Love has the power to uplift, to heal, and to ignite the soul with an unparalleled sense of belonging. It knows no bounds, flourishing in the simplest gestures and resonating in the grandest of declarations. Love is both a journey and a destination, a delicate dance between two hearts intertwined in a cosmic embrace. In its purest form, love is the essence of humanity, binding us together in a shared experience of joy, sorrow, and everything in between.";

        // Create a CoreNLP document from the text
        CoreDocument document = new CoreDocument(text);

        // Annotate the document
        pipeline.annotate(document);


        // Extract the most important sentences
        List<String> keySentences = document.sentences().stream()
                .map(sentence -> sentence.text())
                .toList();

        // Print the summary
        System.out.println("Summary of the text:");
        for (String sentence : keySentences) {
            System.out.println(sentence);
        }
    }
    }




