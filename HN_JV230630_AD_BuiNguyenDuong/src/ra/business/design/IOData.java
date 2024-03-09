package ra.business.design;

import java.util.Scanner;

public interface  IOData {
    public <T> void inputData();

    <T> void inputData(Scanner scanner);

    public void displayData();

}
