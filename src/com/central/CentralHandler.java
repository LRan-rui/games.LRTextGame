package com.central;

import com.command.Command;
import com.save.SaveData;
import com.save.SaveDataManager;

/**
 * 单例类
 *
 * <p>用于分析处理指令信息。
 *
 * @author 凌然
 */
public class CentralHandler {

    private static final CentralHandler handler = new CentralHandler();
    private String rtn;
    private int x = 0;

    private CentralHandler() {
        System.out.println("核心被创建");
    }

    /**
     * 获取该类的唯一实例。
     *
     * @return 该类的唯一实例
     */
    public static CentralHandler getHandler() {
        return handler;
    }

    /**
     * 获取用户的操作输入文本，并进行相应的处理。
     *
     * @param command 用户提供的操作输入
     */
    public void Input(String command) {
        x++;
        command = command.trim();
        int len = command.length();
        for (int i = 1; i <= len && i <= 10; i++) {
            if (!Command(command, i).equals(Signal.COMMAND_NOT_FOUND_ERROR.getSignal())) {
                break;
            }
        }
    }

    /**
     * 返回用户操作的文本处理结果。
     *
     * @return 文本处理结果
     */
    public String ReturnText() {
        if (x >= 10) {
            SaveDataManager.saveData(SaveData.getSaveData());
            x = 0;
        }
        return rtn;
    }

    /**
     * 检查用户的操作输入是否为<strong>n</strong>字符命令，并返回对用户操作的文本处理结果 或否定代码<strong>{@code Signal.ERROR}</strong>的String值。
     *
     * @param commandText 用户的操作输入文本
     * @param n           n字符命令
     * @return 文本处理结果
     */
    private String Command(String commandText, int n) {
        String command = commandText.substring(0, n);
        String param = commandText.substring(n);
        return rtn = Command.Input(command, param);
    }

}
