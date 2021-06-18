public class Course {

    private String text = "";

    Course(){}

    Course(String text) {
        setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
