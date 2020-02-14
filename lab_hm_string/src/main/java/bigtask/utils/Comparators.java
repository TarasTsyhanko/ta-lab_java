package bigtask.utils;

import bigtask.model.Sentence;
import bigtask.model.SentenceElement;
import bigtask.model.Word;

import java.util.Comparator;

public class Comparators {
    public static Comparator<Word> compareWord = Comparator.comparing(SentenceElement::getText);
    public static Comparator<Word> compareWordByLength = Comparator.comparingInt(o -> o.getText().length());
    public static Comparator<Word> compareWordByNumberDuplicate = Comparator.comparingInt(Word::getNumberOfDuplicates);
    public static Comparator<Word> compareWordBySecondLetter = Comparator.comparingInt(o -> ElementsUtils.getFirstConsonantFromWord(o.getText()));
    public static Comparator<Word> compareWordByVowelsPercent = Comparator.comparing(o -> ElementsUtils.getPercentOfVowelsInWord(o.getText()));
    public static Comparator<Word> compareWordByNumberOfLetter = Comparator.comparingInt(o -> ElementsUtils.getNumberOfSameConsonantFromWord(o.getText()));
    public static Comparator<Sentence> compareByWords = (o1, o2) -> {
        int n = 0;
        int m = 0;
        for (SentenceElement member : o1.getOnlyWordsFromSentence()) {
            n++;
        }
        for (SentenceElement member : o2.getOnlyWordsFromSentence()) {
            m++;
        }
        return n - m;
    };
}
