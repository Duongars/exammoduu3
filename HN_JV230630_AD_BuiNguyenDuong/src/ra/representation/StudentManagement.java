package ra.representation;

import ra.business.entity.Student;

import java.util.Scanner;

public class StudentManagement extends CommonFunc {

    private String[] updateList ={"tên","ngày sinh","giới tính","số diện thoại","thoát"};
    private String[] inputMethods= {"inputStudentName","inputBirthday","inputGender","inputPhone"};

    private    String[] strField ={"studentName","birthDay","gender","phone"};
    public void run(){


        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        boolean isRunning = true;
        do {
            System.out.println("**********************STUDENT-MANAGEMENT************************");
            System.out.println("1.Thêm mới học sinh");
            System.out.println("2.Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3.Thay đổi thông tin học sinh");
            System.out.println("4.Xóa học sinh (kiểm tra xem nếu sinh viên có điểm thi thì không xóa được)");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:this.inputItem(student,scanner);
                    break;
                case 2:
                    this.showData(SchoolManagement.studentList);
                    break;
                case 3:
                    this.upDateData(SchoolManagement.studentList,scanner,"sinh viên",updateList, "getStudentId",inputMethods,strField);
                    break;
                case 4:
                    this.deleteIteminList(SchoolManagement.subjectList,scanner,"getStudentId");
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-5");
            }
        } while (isRunning);


    }
}
