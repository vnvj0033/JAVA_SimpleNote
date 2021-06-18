import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CourseTableModel extends AbstractTableModel {
    List<Course> courses = new ArrayList<>();

    public void add(Course course) {
        courses.add(course);
        fireTableRowsInserted(courses.size() - 1, courses.size());
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse(int index) {
        return courses.get(index);
    }

    @Override
    public int getRowCount() {
        return courses.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return courses.get(rowIndex).getText();
    }
}
