public class Todo {

    private String text = "";

    Todo(){}

    Todo(String text) {
        setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
