package bigtask.model;

import bigtask.utils.Comparators;
import bigtask.utils.ElementsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static bigtask.utils.Constants.*;

public class Sentence {
    private List<SentenceElement> elements;

    public Sentence(String str) {
        elements = new ArrayList<>();
        Pattern re = Pattern.compile(SENTENCES_MEMBER_REGEX);
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
            if (ElementsUtils.isSentencesElement(reMatcher.group(), PUNCTUATION_MARK_REGEX)) {
                elements.add(new PunctuationMark(reMatcher.group()));
            }
            if (ElementsUtils.isSentencesElement(reMatcher.group(), NUMBER_REGEX)) {
                elements.add(new Number(reMatcher.group()));
            }
            if (ElementsUtils.isSentencesElement(reMatcher.group(), WORD_REGEX))
                elements.add(new Word(reMatcher.group()));
        }
    }

    public Sentence(List<SentenceElement> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public boolean isWordPresent(Word word) {
        for (SentenceElement element : elements) {
            if (word.getText().equalsIgnoreCase(element.getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean isSentenceQuestion() {
        return elements.get(elements.size() - 1).getText().equals("?");
    }

    public List<SentenceElement> getElements() {
        return elements;
    }

    public List<Word> getOnlyWordsFromSentence() {
        return elements
                .stream()
                .filter(member1 -> member1.getClass().equals(Word.class))
                .map(word -> new Word(word.getText()))
                .collect(Collectors.toList());
    }

    public List<SentenceElement> getUniqueWordsFromSentence() {
        return elements.stream()
                .filter(m -> m.getClass().equals(Word.class))
                .distinct()
                .map(w -> new Word(w.getText()))
                .collect(Collectors.toList());
    }

    public List<SentenceElement> deleteWordsInSentenceByLength(int wordLength) {
        return getAllWordWhichStartWithConsonant()
                .stream()
                .filter(word -> !(word.getClass().equals(Word.class) && ((Word) word).isWordSameLength(wordLength)))
                .collect(Collectors.toList());
    }

    public List<SentenceElement> getAllWordsInSentenceByLength(int wordLength) {
        return getOnlyWordsFromSentence()
                .stream()
                .filter(word -> word.isWordSameLength(wordLength))
                .collect(Collectors.toList());
    }

    public Word getFirstWordFromSentence() {
        return new Word(elements.get(0).getText());
    }

    public List<SentenceElement> getAllWordWhichStartWithConsonant() {
        return elements
                .stream()
                .filter(word -> !word.getClass().equals(Word.class) || ((Word) word).isFirstLetterConstant())
                .collect(Collectors.toList());
    }

    public List<SentenceElement> getAllWordWhichStartWithVowel() {
        return getOnlyWordsFromSentence()
                .stream()
                .filter(Word::isFirstLetterVowel)
                .collect(Collectors.toList());
    }

    public Word getTheLongestWordInSentence() {
        List<Word> words = elements.stream()
                .filter(word -> word.getClass().equals(Word.class))
                .map(text -> new Word(text.getText()))
                .sorted(Comparators.compareWordByLength)
                .collect(Collectors.toList());
        return words.get(words.size() - 1);
    }

    public boolean isInSentenceFirstLetterVowel() {
        return ElementsUtils.isSentencesElement(elements.get(0).getText(), WORD_START_VOWEL_REGEX);
    }

    public void setElement(int index, SentenceElement member) {
        this.elements.set(index, member);
    }

    public List<SentenceElement> getSentenceWhereFirstAndLastLetterAreDeleted(String first, String last) {
        return getOnlyWordsFromSentence()
                .stream()
                .map(word -> word.deleteFirstAndLastInputLetter(first, last))
                .map(Word::new)
                .collect(Collectors.toList());
    }

    public List<SentenceElement> getSentenceWhereReplaceWordByInput(int wordLength, String someText) {
        return getOnlyWordsFromSentence()
                .stream()
                .map(word -> word.replaceWordByInput(wordLength, someText))
                .map(Word::new)
                .collect(Collectors.toList());
    }
}
