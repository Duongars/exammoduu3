package ra.business.entity;

import ra.representation.SchoolManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ra.business.MyRegex.Myfunc.*;
import  static ra.business.MyRegex.MyRegex.*;
public class Student implements IEntity{


//
    private int studentId;
    private String studentName;
    private Date birthDay;

    private String address;

    private boolean gender;

    private String phone;

    public Student() {
    }

    public Student(int studentId, String studentName, Date birthDay, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public boolean isGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public <T> void inputData(Scanner scanner) {
        Student newEm = new Student();
        newEm.studentId = generateId();
        newEm.studentName = inputStudentName(scanner);
        newEm.birthDay = inputBirthday(scanner);
        newEm.gender = inputGender(scanner);
        newEm.phone = inputPhone(scanner);
        SchoolManagement.studentList.add(newEm);
    }

    public int generateId (){
        int max=0;
        for (int i = 0; i < SchoolManagement.studentList.size() ; i++) {
            if (SchoolManagement.studentList.get(i).getStudentId()>max){
                max =SchoolManagement.studentList.get(i).getStudentId();
            }
        }

        return max+1;
    }


  public String   inputStudentName (Scanner scanner){
      do {
          try {
              System.out.println("nhập tiêu tên sinh vien");
              String name = scanner.nextLine();
              if (name.length() > 0) {
                  return name;
              } else {
                  System.out.println("không dươc bỏ trống");
              }
          }catch (Exception ex){
              System.out.println("đã xảy ra lỗi");
          }
      }while (true);
  }

  public Date inputBirthday(Scanner scanner){
      System.out.println("nhập vào ngày sinh sinh viên");
      return validateAndInputDate(scanner);
  }

public boolean inputGender (Scanner scanner){
    System.out.printf("chọn giới tính sinh viên ");
        System.out.printf("1.Nam -- 2.Nữ ");
        do {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice==1){
                return true;
            }else if (choice==2){
                return false;
            }else {
                System.out.printf("giá trị bạn đã nhập không tồn tại");
            };
        }while (true);
}

  public  String inputPhone (Scanner scanner){
      System.out.println("nhập số diên thoại sinh viên");
    do {
        try{
            String phone = scanner.nextLine();
            if (Pattern.matches(phoneRegex,phone)){
                System.out.println("nhập số dien thoại thành công");
                return phone;
            }else {
                System.out.println("vui lòng nhập lại");
            }
        }catch (Exception ex){
            System.out.println("Đã xảy ra lỗi khi nhập ");
        }

    }while (true);
  }


//    studentId – mã học sinh – int (Tự động tăng)
    //▪ studentName – tên học sinh – String (Không được để trống)
//▪ birthDay – ngày sinh – Date
//▪ address – địa chỉ – String (không được để trống)
//▪ gender - giới tính - boolean (true là ‘Nam’ , false là ‘Nữ’)
//▪ phone - số điện thoại - String (10 hoặc 11 số , bắt đầu bằng số 0, không trùng lặp)

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return   "Mã sinh viên : "+this.studentId + " -- Tên sinh viên : "+ this.studentName+ " -- Ngày sinh : "+ sdf.format(this.birthDay)+ " -- Số diện thoại : "+this.phone +" -- email: " +" -- Giới tính: "+(this.gender?"Nam":"Nữ" ) ;
    }

    @Override
    public void displayData() {

    }
}
