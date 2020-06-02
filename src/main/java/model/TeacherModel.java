package model;

public class TeacherModel {
    private int teacherId;
    private String teacherName;
    private String teacherSecondName;
    private int userTableId;
    private UserTableModel userTableModel;

    public TeacherModel() {
    }


    public TeacherModel(String teacherName, String teacherSecondName, int userTableId) {
        userTableModel = new UserTableModel();
        userTableModel.setUserTableId(userTableId);
        this.teacherName = teacherName;
        this.teacherSecondName = teacherSecondName;
        this.userTableId = userTableId;
    }

    public TeacherModel(int teacherId, String teacherName, String teacherSecondName, int userTableId) {
        userTableModel = new UserTableModel();
        userTableModel.setUserTableId(userTableId);
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSecondName = teacherSecondName;
        this.userTableId = userTableId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSecondName() {
        return teacherSecondName;
    }

    public void setTeacherSecondName(String teacherSecondName) {
        this.teacherSecondName = teacherSecondName;
    }

    public int getUserTableId() {
        return userTableId;
    }

    public void setUserTableId(int userTableId) {
        this.userTableId = userTableId;
    }

    public UserTableModel getUserTableModel() {
        return userTableModel;
    }

    public void setUserTableModel(UserTableModel userTableModel) {
        this.userTableModel = userTableModel;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSecondName='" + teacherSecondName + '\'' +
                ", userTableId=" + userTableId +
                ", userTableModel=" + userTableModel +
                '}';
    }
}
