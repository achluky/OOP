package demomvc;

import demomvc.Controller.StudentsController;
import demomvc.model.Student;
import demomvc.view.StudentView;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        Student model = new  Student();
        model.setName("Robert");
        model.setRollNo("10");
        
        StudentView view = new StudentView();
        
        StudentsController controller =  new StudentsController(model,view);
        
        controller.updateView();
        
        controller.setStudentName("John");
        controller.updateView();
    }
    
}
