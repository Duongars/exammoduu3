package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Student;
import ra.representation.SchoolManagement;

import java.util.Scanner;

public class StudentImpl implements IOData {
    @Override
    public <T> void inputData() {

    }

    @Override
    public <T> void inputData(Scanner scanner) {
        Student newEm = new Student();
        newEm.setStudentId(newEm.generateId());
        newEm. setStudentName(newEm.inputStudentName(scanner));
        newEm.setBirthDay(newEm. inputBirthday(scanner));
        newEm.setGender(newEm. inputGender(scanner));
        newEm.setPhone(newEm. inputPhone(scanner));;
        SchoolManagement.studentList.add(newEm);
    }


    @Override
    public void displayData() {

    }
}
