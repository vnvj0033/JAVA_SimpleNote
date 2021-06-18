public class Note {

    private String text = "";

    Note(){}

    Note(String text) {
        setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
