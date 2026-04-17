import com.central.CentralHandler;
import com.save.SaveData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CentralHandler handler = CentralHandler.getHandler();
        SaveData.Start();
        Scanner scanner = new Scanner(System.in);
        //MainWindow.start();
        while (true) {
            System.out.print(">>>");
            handler.Input(scanner.nextLine());
            System.out.println(handler.ReturnText());
        }
    }
}