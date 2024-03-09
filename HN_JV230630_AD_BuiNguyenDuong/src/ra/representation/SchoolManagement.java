package ra.representation;

import ra.business.entity.Mark;
import ra.business.entity.Student;
import ra.business.entity.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolManagement {
    public static List<Student> studentList;
    public static List<Subject> subjectList;
    public static  List<Mark> markList;

    public static <T> List<T>  readDatafromfile(String filename) {
        List<T> newList = new ArrayList<>();
        File file = new File(filename+".txt");
        if (file.exists()) {
            FileInputStream fis;
            ObjectInputStream ois;
            try {
                fis = new FileInputStream(file);
                ois= new ObjectInputStream(fis);
                newList = (List<T>) ois.readObject();
                ois.close();fis.close();
            }catch (Exception ex){
                System.err.println("Đã xảy ra lỗi khi đọc file");
            }
        }else {
            return newList;
        }
        return newList;
    }

    public static <T> void writeDataToFile(String filename, List<T> list) {
        File file = new File(filename + ".txt");
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception ex) {
            System.err.println("Có lỗi trong quá trình ghi file");
        }
    }

    public static void run(CommonFunc mana){
        mana.run();
    }

    public static void main(String[] args) {

        studentList = readDatafromfile("student");
        subjectList = readDatafromfile("subject");
        markList = readDatafromfile("mark");

        CommonFunc studentMana= new StudentManagement();
        CommonFunc subjectMana = new SubjectManagement();
        CommonFunc markmana = new MarkManagement();
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.println("***************MENU****************");
                System.out.println("1. Quản lý học sinh");
                System.out.println("2. Quản lý môn học");
                System.out.println("3. Quản lí điểm thi");
                System.out.println("4. Thoát");
                System.out.print("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        run(studentMana);
                        break;
                    case 2:
                        run(subjectMana);
                        break;
                    case 3:
                        run(markmana);
                        break;
                    case 4:
                        writeDataToFile("student",studentList);
                        writeDataToFile("subject",subjectList);
                        writeDataToFile("mark",markList);
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Vui lòng chọn lại");
                        break;

                }

            }catch (Exception exception){
                System.out.println("đã xảy ra lỗi");
            }

        }while (true);





    }
}
