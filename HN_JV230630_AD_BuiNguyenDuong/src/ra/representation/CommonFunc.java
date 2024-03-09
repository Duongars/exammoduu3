package ra.representation;

import ra.business.entity.IEntity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import static ra.business.MyRegex.Myfunc.* ;

public class CommonFunc {
    public void run() {
    }

    public <T> void inputItem(IEntity item, Scanner scanner){
        System.out.println("nhập số phần tử cần thêm");
            try {
                int num = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i <num ; i++) {
                    item.inputData(scanner);
                }
            }catch (Exception ex){
                System.out.println("đã xảy ra lỗi");
            }
    }

    public <T> void inputItem( IEntity item, Scanner scanner,String type){
        System.out.println("nhập số phần tử cần thêm");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i <num ; i++) {
                item.inputData(scanner,type);
            }
        }catch (Exception ex){
            System.out.println("đã xảy ra lỗi");
        }
    }



    public <T> void showData(List<T> list){
            for (int i = 0; i <list.size() ; i++) {
                System.out.println(list.get(i).toString());
            }
    }


    public <T> void upDateData(List<T> list,Scanner scanner, String upDateName,String [] updateList,String getMethodName, String[] inputMethods,String[] fields){
        boolean isUpdating = true;
            System.out.printf("cập nhật %s\n",upDateName);
            try {
                System.out.printf("nhập vào id %s ",upDateName);
                String itemTobeUpdate = scanner.nextLine();
              int findItemIndex =  findItembyId(list,getMethodName,itemTobeUpdate);
                if (findItemIndex>=0) {
                    do {
                        this.generateUpdateList(updateList);
                        System.out.println("lựa chọn của bạn");
                        int choice = Integer.parseInt(scanner.nextLine());
                        if (choice<=inputMethods.length&& choice>0){
                            String inputMethod = inputMethods[choice-1];
                            String fieldName = fields[choice-1];
                            Method input = list.get(findItemIndex).getClass().getDeclaredMethod(inputMethod,Scanner.class);
                            Field field = list.get(findItemIndex).getClass().getDeclaredField(fieldName);
                            field.setAccessible(true);
                            input.setAccessible(true);
                            field.set(list.get(findItemIndex),input.invoke(list.get(findItemIndex),scanner));
                        }else if (choice==updateList.length){
                            isUpdating = false;
                        }
                    }while (isUpdating);
                }else {
                    System.out.println("không tìm thấy kết quả tương ứng");
                }

            }catch (Exception ex){
                System.out.println("Đã xảy ra lỗi");
            }

    }


    public <T> void deleteIteminList(List<T> list,Scanner scanner,String getMethodName){
        try {
            System.out.println("nhập id phần tử cần xóa");
            String itemTobeDelete = scanner.nextLine();
            int findItemIndex =  findItembyId(list,getMethodName,itemTobeDelete);
            if (findItemIndex>=0){
                list.remove(findItemIndex);
                System.out.println("Xóa thành công");
            }else {
                System.out.println("không tìm thấy kết quả tương ứng");
            }
        } catch (Exception ex){
            System.out.println("Đã xảy ra lỗi");
        }
    }





    public void generateUpdateList(String [] updateList){
        for (int i = 0; i <updateList.length ; i++) {
            System.out.printf("%d. cập nhật %s\n",(i+1), updateList[i]);
        }
    }
}
