package ra.business.entity;

import ra.representation.SchoolManagement;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ra.business.MyRegex.Myfunc.*;
import static ra.business.MyRegex.MyRegex.*;
public class Subject implements IEntity{

//▪ subjectId – mã môn học – String(Gồm 5 kí tự bắt đầu bằng “MH” và 3 kí tự số bất kì ,
//                                  không trùng lặp )
//▪ subjectName – tên môn học – String (Không được để trống, không trùng nhau).


private  String subjectId;
private String  subjectName;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }


    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }




    @Override
    public <T> void inputData(Scanner scanner) {
        Subject newSb = new Subject();
        newSb.subjectId= inputSubjectId(scanner);
        newSb.subjectName = inputSubjectName(scanner);
        SchoolManagement.subjectList.add(newSb);

    }


    public String inputSubjectId (Scanner scanner){
         do {
        try {
            System.out.println("nhập mã môn học ắt đầu bằng 'MH' và 3 kí tự số bất kì");
            String sjId = scanner.nextLine();
            if (Pattern.matches(subjectIdRegex,sjId)){
                boolean isEsist = SchoolManagement.subjectList.stream().anyMatch(subject -> subject.getSubjectId().equals(sjId));
                if (isEsist) {
                    System.out.println("tên đã tồn tại");
                } else {
                    return sjId;
                }
            }else {
                System.out.println("tên vửa nhập sai qui tắc");
            }
        }catch (Exception ex){
            System.out.println("đã xảy ra lỗi");
        }
    }while (true);

    }

public  String inputSubjectName(Scanner scanner){
    do {
        try {
            System.out.println("nhập tên môn học");
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


    @Override
    public void displayData() {

    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return   "Mã môn học : "+this.subjectId + " -- Tên môn học : "+ this.subjectName;
    }
}
