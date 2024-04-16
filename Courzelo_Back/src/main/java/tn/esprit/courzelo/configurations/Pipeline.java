package tn.esprit.courzelo.configurations;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;
import java.util.Properties;

public class Pipeline {
    public static Properties properties;
    static String propertiesName = "tokenize, ssplit, pos, lemma, ner, parse, sentiment";

    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline() {
    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    public static StanfordCoreNLP getPipeline() {
        if (stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }


}

