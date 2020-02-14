package bigtask.utils;

import bigtask.model.Sentence;
import bigtask.model.SentenceElement;
import bigtask.model.Word;

import java.util.Collection;
import java.util.List;

public class ConsoleOutputs {
    public static void printSentence(List<Sentence> sentences) {
        for (Sentence s : sentences) {
            for (SentenceElement e : s.getElements()) {
                System.out.print(e.getText());
            }
            System.out.println();
        }
    }

    public static void printSentenceWithOutMark(List<Sentence> sentences) {
        for (Sentence s : sentences) {
            for (SentenceElement e : s.getElements()) {
                System.out.print(e.getText() + " ");
            }
            System.out.println();
        }
    }

    public static void printWord(Collection<Word> words) {
        int i = 0;
        for (Word s : words) {
            System.out.print(s.getText() + " ");
            while (i > 10) {
                System.out.println();
                i = 0;
            }
            i++;
        }
    }

    public static void printWordByNewLine(List<Word> words) {
        String str = " ";
        for (Word word : words) {
            System.out.print(" " + word.getText());
            if (!(word.getText().charAt(0) == str.charAt(0))) {
                System.out.println();
            }
            str = word.getText();
        }

    }
}

