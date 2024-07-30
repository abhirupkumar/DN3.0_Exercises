public class Main {
    public static void main(String[] args) {
        Student student = new Student("Meenakshi Sharma", "50", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentName("Aisha Mehta");
        controller.setStudentGrade("B");
        controller.updateView();
    }
}
