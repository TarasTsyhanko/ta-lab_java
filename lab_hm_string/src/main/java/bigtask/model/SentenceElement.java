package bigtask.model;

import java.util.Objects;

public abstract class SentenceElement {
    protected String text;

    public SentenceElement() {
    }
    public SentenceElement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SentenceMember{" +
                "text='" + text + '\'' +
                '}';
    }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SentenceElement that = (SentenceElement) o;
      return text.equalsIgnoreCase(that.text);
  }

  @Override
  public int hashCode() {
       return Objects.hash(text);
   }
}
