
import com.example.CommandHandler;
import com.example.Course;
import com.example.Student;
import com.example.Teacher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CommandHandlerTest {
    @Test
    @DisplayName("Test sobre comando ENROLL")
    public void testEnrollStudentUpdatesStudentAndCourse(){

        Student student = new Student("Studiant Diez", "Calle Su casa 12", "mail@mail");
        Course course = new Course("Ethics", 20.00);

        var studentList = List.of(student);
        var courseList = List.of(course);
        List<Teacher> teacherList = List.of();

        CommandHandler commandHandler = new CommandHandler(studentList, courseList, teacherList);

        String commandWithIds = "ENROLL "+ student.getStudentId()+ " " + course.getCourseId();
        System.out.println(commandWithIds);

        commandHandler.executeCommand(commandWithIds);

        assertEquals("Ethics", student.getCourse().getName());

    }

    @Test
    @DisplayName("Test sobre comando ASSIGN")
    public void testAssignTeacher(){

        Teacher teacher = new Teacher("Ana Paula", 20000);
        Course course = new Course("Physics", 30.00);

        var teacherList = List.of(teacher);
        var courseList = List.of(course);
        List<Student> studentList = List.of();

        CommandHandler commandHandler = new CommandHandler(studentList, courseList, teacherList);

        String commandWithIds = "ASSIGN "+ teacher.getTeacherId()+ " " + course.getCourseId();
        System.out.println(commandWithIds);

        commandHandler.executeCommand(commandWithIds);

        assertEquals("Ana Paula", teacher.getName());

    }


}



