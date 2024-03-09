package ra.business.MyRegex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Myfunc {

    public static <T> int findItembyId (List<T> list, String getMethodName, String tofindValue) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       try {
           for (int i = 0; i < list.size(); i++) {
               Method getMethod = list.get(i).getClass().getDeclaredMethod(getMethodName);
               getMethod.setAccessible(true);
               String result = String.valueOf(getMethod.invoke(list.get(i),null))  ;
               if (result.equals(tofindValue)){
                   return i;
               }
           }
           return -1;
       }catch (Exception ex){
           System.out.println("đã xảy ra lỗi khi tìm kiếm");
       }
     return -1;
    }




    public static Date validateAndInputDate (Scanner scanner){
        do {
            try {
                Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
                System.out.println("nhập vào ngày định dạng dd/mm/yyyy");
                String dateString = scanner.nextLine();
                Matcher dateMatcher = dateRegexPattern.matcher(dateString);
                if (dateMatcher.matches()){
                    dateMatcher.reset();
                    if (dateMatcher.find()){
                        String day = dateMatcher.group(1);
                        String month = dateMatcher.group(2);
                        int year = Integer.parseInt(dateMatcher.group(3));
                        if ("31".equals(day) &&
                                ("4".equals(month) || "6".equals(month) || "9".equals(month) ||
                                        "11".equals(month) || "04".equals(month) || "06".equals(month) ||
                                        "09".equals(month))){
                            System.out.println("vui lòng nhập lại");
                        }else if ("2".equals(month) || "02".equals(month)){
                            if (year % 4 == 0){
                                if ("30".equals(day) || "31".equals(day)){
                                    System.out.println("vui lòng nhập lại");
                                }else {
                                    SimpleDateFormat fm=new SimpleDateFormat("dd/MM/yyyy");
                                    return fm.parse(dateString);
                                }
                            }else {
                                if ("29".equals(day) || "30".equals(day) || "31".equals(day)){
                                    System.out.println("vui lòng nhập lại");
                                }else {
                                    SimpleDateFormat fm=new SimpleDateFormat("dd/MM/yyyy");
                                    return fm.parse(dateString);
                                }
                            }
                        }else {
                            SimpleDateFormat fm=new SimpleDateFormat("dd/MM/yyyy");
                            return fm.parse(dateString);
                        }
                    }else {
                        System.out.println("vui lòng nhập lại");
                    }
                }else {
                    System.out.println("vui lòng nhập lại");
                }
            }catch (Exception ex){
                System.out.println("vui lòng nhập lại");
            }
        }while (true);
    }









}
