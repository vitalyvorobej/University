package model;

/**
 * Класс-модель описывающая таблицу student
 */
public class StudentModel {
    private int studentId;
    private String studentName;
    private String studentSecondName;
    private int userTableId;
    private UserTableModel userTableModel;

    public StudentModel() {
    }


    public StudentModel(int studentId, String studentName, String studentSecondName, int userTableId) {
        userTableModel = new UserTableModel();
        userTableModel.setUserTableId(userTableId);
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSecondName = studentSecondName;
        this.userTableId = userTableId;
    }

    public StudentModel(String studentName, String studentSecondName, int userTableId) {
        userTableModel = new UserTableModel();
        userTableModel.setUserTableId(userTableId);
        this.studentName = studentName;
        this.studentSecondName = studentSecondName;
        this.userTableId = userTableId;
    }

    public StudentModel(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSecondName() {
        return studentSecondName;
    }

    public void setStudentSecondName(String studentSecondName) {
        this.studentSecondName = studentSecondName;
    }

    public UserTableModel getUserTableModel() {
        return userTableModel;
    }

    public void setUserTableModel(UserTableModel userTableModel) {
        this.userTableModel = userTableModel;
    }

    public int getUserTableId() {
        return userTableId;
    }

    public void setUserTableId(int userTableId) {
        this.userTableId = userTableId;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentSecondName='" + studentSecondName + '\'' +
                ", userTableId=" + userTableId +
                ", userTableModel=" + userTableModel +
                '}';
    }
}
