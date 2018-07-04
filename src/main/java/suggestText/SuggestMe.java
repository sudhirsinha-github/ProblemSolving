package suggestText;

import java.io.File;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Created by sudhirkumar on 11/7/17.
 */
public class SuggestMe {

    public static void main(String[] args) throws Exception {
        File dir = new File("/Users/sudhirkumar/Workspace/Learn/src/main/java/suggestText/dym");

        Directory directory = FSDirectory.open(dir);

        SpellChecker spellChecker = new SpellChecker(directory);

        @SuppressWarnings("deprecation")
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_36, new WhitespaceAnalyzer(Version.LUCENE_36));

        spellChecker.indexDictionary(new PlainTextDictionary(new File("/Users/sudhirkumar/Workspace/Learn/src/main/java/suggestText/standard_domains_.txt")), config, false);

        String wordForSuggestions = "tesyt.co.uk";

        int suggestionsNumber = 1;

        String[] suggestions = spellChecker.suggestSimilar(wordForSuggestions, suggestionsNumber);

        if (suggestions != null && suggestions.length > 0) {
            for (String word : suggestions) {
                System.out.println("Did you mean ->" + word);
            }
        } else {
            System.out.println("No suggestions found for word:" + wordForSuggestions);
        }
    }
}
