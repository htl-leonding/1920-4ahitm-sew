package at.htl.mock;

import java.util.LinkedList;
import java.util.List;

public class Classroom {

    public List<String> students = new LinkedList<>();

    public Classroom() {
    }

    public void addX(String name) {
        students.add(name);
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }
}
