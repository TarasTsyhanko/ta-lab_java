package readefile;

public abstract class MemberOfSentence {
    private String text;

    public MemberOfSentence(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
