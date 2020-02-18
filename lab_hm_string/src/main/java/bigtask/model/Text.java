package bigtask.model;

import bigtask.utils.Comparators;
import bigtask.utils.ElementsUtils;
import bigtask.utils.Readers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static bigtask.utils.Constants.FILE_PATH;
import static bigtask.utils.Constants.SENTENCES_REGEX;

public class Text {
    private static final Logger LOG = LogManager.getLogger(Text.class);
    private List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
        String text = Readers.readFile(FILE_PATH);
        Pattern re = Pattern.compile(SENTENCES_REGEX);
        Matcher reMatcher = re.matcher(text);
        while (reMatcher.find()) {
            sentences.add(new Sentence(reMatcher.group()));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public Word getCommonWord() {
        List<Word> words = indetificateWordDuplicate()
                .stream()
                .sorted(Comparators.compareWordByNumberDuplicate)
                .collect(Collectors.toList());
        return words.get(words.size() - 1);
    }

    public List<Sentence> getAllSentenceWithCommonWord(Word word) {
        return sentences
                .stream()
                .filter(sentence -> sentence.isWordPresent(word))
                .collect(Collectors.toList());
    }

    public List<Sentence> sortSentencesByWords() {
        return sentences.stream().sorted(Comparators.compareByWords).collect(Collectors.toList());
    }

    public Word uniqueWordFromFirstSentences() {
        for (SentenceElement mem : sentences.get(0).getElements()) {
            List<SentenceElement> list = sentences
                    .stream()
                    .flatMap(x -> x.getOnlyWordsFromSentence().stream()
                            .filter(m -> m.getText().equals(mem.getText())))
                    .collect(Collectors.toList());
            if (list.size() == 1) {
                return new Word(list.get(0).getText());
            }
        }
        return new Word("");
    }

    public List<Word> getAllWordSortByFirstLetter() {
        return sentences.stream()
                .flatMap(sentence -> sentence.getOnlyWordsFromSentence()
                        .stream())
                .sorted(Comparators.compareWord)
                .collect(Collectors.toList());
    }

    public List<Sentence> getAllQuestionSentences(int wordLength) {
        return sentences.stream()
                .filter(Sentence::isSentenceQuestion)
                .map(Sentence::getUniqueWordsFromSentence)
                .map(Sentence::new)
                .map(sentence -> sentence.getAllWordsInSentenceByLength(wordLength))
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    public List<Sentence> replaceFirstWordByLongestWord() {
        List<Sentence> sentences1 = sentences
                .stream()
                .filter(Sentence::isInSentenceFirstLetterVowel)
                .collect(Collectors.toList());
        for (Sentence s : sentences1) {
            Word longestWord = s.getTheLongestWordInSentence();
            int index = s.getElements().indexOf(s.getTheLongestWordInSentence());
            s.getElements().set(index, s.getElements().get(0));
            s.getElements().set(0, longestWord);
        }
        return sentences1;
    }

    public List<Word> sortWordsByFirstConstant() {
        List<Word> words =  sentences
                .stream()
                .flatMap(sentence -> sentence.getAllWordWhichStartWithVowel()
                        .stream())
                .map(word -> new Word(word.getText()))
                .sorted(Comparators.compareWordBySecondLetter)
                .collect(Collectors.toList());
        return words;
    }

    public List<Word> sortWordByVowelsPercent() {
        return sentences
                .stream()
                .flatMap(sentence -> sentence.getOnlyWordsFromSentence()
                        .stream())
                .sorted(Comparators.compareWordByVowelsPercent)
                .collect(Collectors.toList());
    }

    public List<Sentence> getAllSentencesWhereDeleteWordByLength(int wordLength) {
        return sentences
                .stream()
                .map(sentence -> sentence.deleteWordsInSentenceByLength(wordLength))
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    public List<Word> sortAllWordsBySomeLetter(String letter) {
        ElementsUtils.setLetter(letter);
        return sentences.stream()
                .map(Sentence::getAllWordWhichStartWithConsonant)
                .map(Sentence::new)
                .flatMap(sentence -> sentence.getOnlyWordsFromSentence()
                        .stream()).sorted(Comparators.compareWordByNumberOfLetter)
                .collect(Collectors.toList());

    }

    public List<Sentence> getAllSentencesWhereFirstAndLastLetterDeleted(String first, String last) {
        return sentences
                .stream()
                .map(sentence -> sentence.getSentenceWhereFirstAndLastLetterAreDeleted(first, last))
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    public List<Sentence> replaceWordsForLength(int wordLength, String someText) {
        return sentences
                .stream()
                .map(sentence -> sentence.getSentenceWhereReplaceWordByInput(wordLength, someText))
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    public List<Word> getAllPalindrome() {
        return sentences
                .stream()
                .flatMap(sentence -> sentence.getOnlyWordsFromSentence()
                        .stream()
                        .filter(Word::isWordPalindrome))
                .collect(Collectors.toList());
    }

    public List<Word> indetificateWordDuplicate() {
        List<Word> words = sentences
                .stream()
                .flatMap(sentence -> sentence.getOnlyWordsFromSentence()
                        .stream())
                .collect(Collectors.toList());
        for (Word word : words) {
            word.setNumberOfDuplicates((int) sentences
                    .stream()
                    .flatMap(sentence -> sentence.getOnlyWordsFromSentence()
                            .stream()
                            .filter(word1 -> word1.getText().equalsIgnoreCase(word.getText())))
                    .count());
        }
        return words;
    }

    public Set<Word> sortWordByNumberOfDuplicate() {
        return indetificateWordDuplicate()
                .stream()
                .sorted(Comparators.compareWordByNumberDuplicate)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
