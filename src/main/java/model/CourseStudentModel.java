package model;

public class CourseStudentModel {
    private StudentModel studentModel;
    private String mark;
    private CourseModel courseModel;
    private int studentId;
    private int courseId;


    public CourseStudentModel() {
    }

    public CourseStudentModel(StudentModel studentModel, String mark, CourseModel courseModel) {
        this.studentModel = studentModel;
        this.mark = mark;
        this.courseModel = courseModel;
    }


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

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public CourseModel getCourseModel() {
        return courseModel;
    }

    public void setCourseModel(CourseModel courseModel) {
        this.courseModel = courseModel;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
