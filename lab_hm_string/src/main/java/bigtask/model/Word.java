package bigtask.model;

import bigtask.utils.ElementsUtils;

import static bigtask.utils.Constants.WORD_START_CONSONANT_REGEX;
import static bigtask.utils.Constants.WORD_START_VOWEL_REGEX;

public class Word extends SentenceElement {
    private int numberOfDuplicates;
    public Word(String text) {
        super(text);
    }

    public Word() {
    }

    public int getNumberOfDuplicates() {
        return numberOfDuplicates;
    }

    public void setNumberOfDuplicates(int numberOfDuplicates) {
        this.numberOfDuplicates = numberOfDuplicates;
    }

    public String replaceWordByInput(int wordLength, String someText) {
        return text.length() == wordLength ? someText : text;
    }

    public boolean isFirstLetterVowel() {
        return ElementsUtils.isSentencesElement(text, WORD_START_VOWEL_REGEX);
    }

    public boolean isFirstLetterConstant() {
        return ElementsUtils.isSentencesElement(text, WORD_START_CONSONANT_REGEX);
    }

    public boolean isWordSameLength(int wordLength) {
        return text.length() == wordLength;
    }

    public boolean isWordPalindrome() {
        StringBuilder s = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            s.append(text.charAt(i));
        }
        return s.toString().equalsIgnoreCase(text) && s.length() != 1;
    }

    public String deleteFirstAndLastInputLetter(String first, String last) {
        return text.length() > 1
                && (first.equalsIgnoreCase(text.substring(0, 1))
                && last.equalsIgnoreCase(text.substring(text.length() - 1)))
                ? text.substring(1, text.length() - 1)
                : text;
    }
}
