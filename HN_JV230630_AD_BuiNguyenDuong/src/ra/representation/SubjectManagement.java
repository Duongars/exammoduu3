package ra.representation;

import ra.business.entity.Subject;

import java.util.Scanner;

public class SubjectManagement extends CommonFunc {
    private String[] updateList ={"tên","thoát"};
    private String[] inputMethods= {"inputSubjectName"};

    private    String[] strField ={"subjectName"};

    public void run(){
        Scanner scanner = new Scanner(System.in);
        Subject subject = new Subject();
        boolean isRunning = true;
        do {
            System.out.println("***********************SUBJECT-MANAGEMENT*************************");
            System.out.println("1.Thêm mới môn học");
            System.out.println("2.Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3.Thay đổi thông tin học môn học");
            System.out.println("4.Xóa môn học (kiểm tra xem nếu môn học có điểm thi thì không xóa được)");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:this.inputItem(subject,scanner);
                    break;
                case 2:
                    this.showData(SchoolManagement.subjectList);
                    break;
                case 3:
                    this.upDateData(SchoolManagement.subjectList,scanner,"môn học",updateList, "getSubjectId",inputMethods,strField);
                    break;
                case 4:
                    this.deleteIteminList(SchoolManagement.subjectList,scanner,"getSubjectId");
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-5");
            }
        } while (isRunning);

    };
}
