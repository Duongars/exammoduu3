package ra.business.implement;

import ra.business.design.IOData;
import ra.business.entity.Mark;
import ra.representation.SchoolManagement;

import java.util.Scanner;

public class MarkImpl implements IOData {
    @Override
    public <T> void inputData() {

    }

    @Override
    public <T> void inputData(Scanner scanner) {
            Mark newSb = new Mark();
            newSb.setMarkId(newSb.generateId(scanner));
            newSb.setStudent(newSb.inputStudent(scanner));
            newSb.setPoint( newSb. inputPoint(scanner));
            newSb.setSubject( newSb.inputSubject(scanner)); ;
            SchoolManagement.markList.add(newSb);

    }

    @Override
    public void displayData() {

    }
}
