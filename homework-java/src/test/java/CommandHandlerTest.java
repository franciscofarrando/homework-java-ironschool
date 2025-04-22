
import com.example.CommandHandler;
import com.example.Course;
import com.example.Student;
import com.example.Teacher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommandHandlerTest {
    @Test
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
}
