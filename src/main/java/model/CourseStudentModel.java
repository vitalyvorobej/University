package model;

/**
 * Класс-модель описывающая таблицу courseStudent
 */
public class CourseStudentModel {
    private StudentModel studentModel;
    private String mark;
    private CourseModel courseModel;
    private int studentId;
    private int courseId;

    public CourseStudentModel(int studentId, String mark, int courseId) {
        studentModel = new StudentModel();
        studentModel.setStudentId(studentId);
        courseModel = new CourseModel();
        courseModel.setCourseId(courseId);
        this.studentId = studentId;
        this.mark = mark;
        this.courseId = courseId;
    }

    public StudentModel getStudentModel() {
        return studentModel;
    }


    public String getMark() {
        return mark;
    }


    public CourseModel getCourseModel() {
        return courseModel;
    }


    public int getStudentId() {
        return studentId;
    }


    public int getCourseId() {
        return courseId;
    }


    @Override
    public String toString() {
        return "CourseStudentModel{" +
                "studentModel=" + studentModel +
                ", mark='" + mark + '\'' +
                ", courseModel=" + courseModel +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
