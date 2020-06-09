package model;

import java.util.Date;

/**
 * Класс-модель описывающая таблицу course
 */
public class CourseModel {

    private int courseId;
    private String courseName;
    private int teacherId;
    private TeacherModel teacher;
    private Date courseStartDate;
    private Date courseEndDate;

    public CourseModel() {

    }

    public CourseModel(int courseId, String courseName, int teacherId, Date courseStartDate, Date courseEndDate) {
        teacher = new TeacherModel();
        teacher.setTeacherId(teacherId);
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
    }

    public CourseModel(String courseName, int teacherId, Date dateStart, Date dateEnd) {
        teacher = new TeacherModel();
        teacher.setTeacherId(teacherId);
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.courseStartDate = dateStart;
        this.courseEndDate = dateEnd;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public TeacherModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherModel teacher) {
        this.teacher = teacher;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public Date getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(Date courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherId=" + teacherId +
                ", courseStartDate=" + courseStartDate +
                ", courseEndDate=" + courseEndDate +
                '}';
    }
}
