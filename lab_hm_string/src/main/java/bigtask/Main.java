package bigtask;

import bigtask.model.Text;
import bigtask.utils.ConsoleOutputs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Text text = new Text();
        ConsoleOutputs.printSentence(text.getAllSentenceWithCommonWord(text.getCommonWord()));
        ConsoleOutputs.printSentence(text.sortSentencesByWords());
        LOG.info(text.uniqueWordFromFirstSentences().getText());
        ConsoleOutputs.printSentenceWithOutMark(text.getAllQuestionSentences(5));
        ConsoleOutputs.printSentence(text.replaceFirstWordByLongestWord());
        ConsoleOutputs.printWordByNewLine(text.getAllWordSortByFirstLetter());
        ConsoleOutputs.printWord(text.sortWordByVowelsPercent());
        ConsoleOutputs.printWord(text.sortWordsByFirstConstant());
        ConsoleOutputs.printWord(text.sortAllWordsBySomeLetter("i"));
        ConsoleOutputs.printWord(text.sortWordByNumberOfDuplicate());
        ConsoleOutputs.printSentence(text.getAllSentencesWhereDeleteWordByLength(4));
        ConsoleOutputs.printWord(text.getAllPalindrome());
        ConsoleOutputs.printSentenceWithOutMark(text.getAllSentencesWhereFirstAndLastLetterDeleted("j", "a"));
        ConsoleOutputs.printSentenceWithOutMark(text.replaceWordsForLength(4, "October"));
    }
}
