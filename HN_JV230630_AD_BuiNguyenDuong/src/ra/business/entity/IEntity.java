package ra.business.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public interface IEntity extends Serializable {

    public <T> void inputData(Scanner scanner);

    default public <T> void inputData(Scanner scanner,String type){};
    public void displayData();

    public default void updateData(Scanner scanner, String[] strMethod, String[] strField) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("lựa chọn");
        int num = Integer.parseInt(scanner.nextLine());
        Field emField = this.getClass().getDeclaredField(strField[num]);
        emField.setAccessible(true);
        Method emMethods = this.getClass().getDeclaredMethod("input"+strMethod[num],Scanner.class);
        emMethods.setAccessible(true);
        emField.set(this, emMethods.invoke(this,scanner));
    }


}
