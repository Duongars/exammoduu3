package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Subject;
import ra.representation.SchoolManagement;

import java.util.Scanner;

public class SubjectImpl implements IOData {
    @Override
    public <T> void inputData() {



    }

    @Override
    public <T> void inputData(Scanner scanner) {{
            Subject newSb = new Subject();
            newSb.setSubjectId(newSb.inputSubjectId(scanner));;
            newSb.setSubjectName(newSb. inputSubjectName(scanner)); ;
            SchoolManagement.subjectList.add(newSb);
        }

    }

    @Override
    public void displayData() {

    }
}
