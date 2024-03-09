package ra.business.entity;

import ra.representation.SchoolManagement;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Mark implements IEntity {
//
//    ▪ markId – mã điểm – int (tự tăng)
//▪ student – sinh viên – Student(Không được null)
//▪ subject - môn học - Subject(không được null)
//▪ point - double - (từ 0 đến 10)

  private    int markId;
  private Student student;

  private  Subject subject;

  private  double point;

    public Mark() {
    }

    public Mark(int markId, Student student, Subject subject, double point) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public int getMarkId() {
        return markId;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getPoint() {
        return point;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public <T> void inputData(Scanner scanner) {
        Mark newSb = new Mark();
        newSb.markId= generateId(scanner);
        newSb.student = inputStudent(scanner);
        newSb.subject = inputSubject(scanner);
        newSb.point = inputPoint(scanner);
        SchoolManagement.markList.add(newSb);
    }

    public int generateId(Scanner scanner){
        int max=0;
        for (int i = 0; i < SchoolManagement.markList.size() ; i++) {
            if (SchoolManagement.markList.get(i).getMarkId()>max){
                max =SchoolManagement.markList.get(i).getMarkId();
            }
        }
        return max+1;
    }


    public double inputPoint(Scanner scanner){
        do {
            try {
                System.out.println("nhập diểm sinh vien");
                Double point = Double.parseDouble(scanner.nextLine()) ;
                if (point>= 0 && point<=10) {
                    return point;
                } else {
                    System.out.println("nhập điểm từ 0 đến 10");
                }
            }catch (Exception ex){
                System.out.println("đã xảy ra lỗi");
            }
        }while (true);
    }

    public Student inputStudent(Scanner scanner){
        do {
            try {
                System.out.println("Chọn sinh viên cần nhập");
                SchoolManagement.studentList.stream().forEach(student -> System.out.println((SchoolManagement.studentList.indexOf(student)+1)+"."+student.toString()));
                System.out.println("lụa chọn của bạn là:");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice>0&& choice<=SchoolManagement.studentList.size()){
                    return SchoolManagement.studentList.get(choice-1);
                }else {
                    System.out.println("vui lòng nhâp lại");
                }
            }catch (Exception ex){
                System.out.println("Đã xảy ra lỗi khi nhập ");
            }
        }while (true);

    }

    public Subject inputSubject(Scanner scanner){
        do {
            try {
                System.out.println("Chọn môn học cần nhập");
                SchoolManagement.subjectList.stream().forEach(subject -> System.out.println((SchoolManagement.subjectList.indexOf(subject)+1)+"."+subject.toString()));
                System.out.println("lụa chọn của bạn là:");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice>0&& choice<=SchoolManagement.subjectList.size()){
                    return SchoolManagement.subjectList.get(choice-1);
                }else {
                    System.out.println("vui lòng nhâp lại");
                }
            }catch (Exception ex){
                System.out.println("Đã xảy ra lỗi khi nhập ");
            }
        }while (true);
    }

    //
//    ▪ markId – mã điểm – int (tự tăng)
//▪ student – sinh viên – Student(Không được null)
//▪ subject - môn học - Subject(không được null)
//▪ point - double - (từ 0 đến 10)

    @Override
    public String toString(){
        return   "Mã điểm : "+this.markId + " -- Sinh viên : "+ this.student+ " -- Môn học : "+ this.subject+ " -- Điểm : "+this.point ;
    }

    @Override
    public void displayData() {

    }
}
