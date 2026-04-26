import com.example.lrtextgame.central.CentralHandler;
import com.example.lrtextgame.save.SaveData;
import com.example.lrtextgame.winodw.MainWindow;

import java.util.Scanner;

/**
 * 程序入口
 * @author 凌然
 */
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