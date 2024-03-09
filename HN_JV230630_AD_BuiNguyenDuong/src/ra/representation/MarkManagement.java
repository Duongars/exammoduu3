package ra.representation;

import ra.business.entity.Mark;
import ra.business.entity.Subject;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static ra.business.MyRegex.Myfunc.*;

public class MarkManagement extends CommonFunc {
    private String[] updateList = {"điểm sinh viên", "thoát"};
    private String[] inputMethods = {"inputPoint"};

    private String[] strField = {"point"};

    public void run() {

//        private String[] updateList ={"tên","năm sinh","số đien thoại","email","trạng thái","thoát"};
//        private String[] inputMethods= {"inputEmName","inputBirthYear","inputPhone","inputEmail","inputEmStatus"};
//
//        private    String[] strField ={"empName","birthyear","phone","email","empStatus"};

        Scanner scanner = new Scanner(System.in);
        Mark employee = new Mark();
        boolean isRunning = true;
        do {
            System.out.println("*********************MARK-MANAGEMENT************************");
            System.out.println("1.Thêm mới điểm thi cho 1 sinh viên");
            System.out.println("2.Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần");
            System.out.println("3.Thay đổi điểm theo sinh viên");
            System.out.println("4.Xóa điểm thi của sinh viên");
            System.out.println("5.Hiển thị danh sách điểm thi theo mã môn học");
            System.out.println("6..Hiển thị đánh giá học lực của từng học sinh theo mã môn học");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    this.inputItem(employee, scanner);
                    break;
                case 2:
                    this.showData(SchoolManagement.markList);
                    break;
                case 3:
                    this.upDateData(SchoolManagement.markList, scanner, "điểm", updateList, "getMarkId", inputMethods, strField);
                    break;
                case 4:
                    this.deleteIteminList(SchoolManagement.markList, scanner, "getMarkId");
                    break;
                case 5: {
                    try {
                        System.out.println("vui lòng nhập mã môn học");
                        String subjectId = scanner.nextLine();
                        if (findItembyId(SchoolManagement.subjectList, "getSubjectId", subjectId) >= 0) {
                           SchoolManagement.markList.stream().filter(mark -> mark.getSubject().getSubjectId().equals(subjectId)).forEach(System.out::println);
                        } else {
                            System.out.println("không tìm thấy mã môn học");
                        }

                    } catch (Exception ex) {
                        System.out.println("đã xảy ra lỗi");
                    }
                }

                break;
                case 6:
//                {
                    try {
                        System.out.println("vui lòng nhập mã môn học");
                        String subjectId = scanner.nextLine();
                        if (findItembyId(SchoolManagement.subjectList, "getSubjectId", subjectId) >= 0) {

                            SchoolManagement.markList.stream().filter(mark -> mark.getSubject().getSubjectId().equals(subjectId)).forEach(mark -> {
                                if (mark.getPoint()<5){
                                    System.out.println(mark+"hoc luc yếu");
                                }else  if(mark.getPoint()<=6.5){
                                    System.out.println(mark+"hoc luc trung bỉnh");
                                }else  if(mark.getPoint()<=8){
                                    System.out.println(mark+"hoc luc khá");
                                }else {
                                    System.out.println(mark+"hoc luc giỏi");
                                }

                            });


                        } else {
                            System.out.println("không tìm thấy mã môn học");
                        }

                    } catch (Exception ex) {
                        System.out.println("đã xảy ra lỗi");
                    }
//
//                }
                break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-6");
            }
        } while (isRunning);

    }

    ;
}
