package com.command;


import com.central.Signal;
import com.command.action.EnergyManager;
import com.command.action.Logging;
import com.command.action.Mining;
import com.command.craft.Craft;
import com.command.fight.EquipmentManager;
import com.command.fight.Stat;
import com.command.quest.QuestManager;
import com.command.shop.ShopManager;
import com.data.item.UseItem;

import java.util.HashMap;


/**
 * 提供命令处理方法
 */
public class Command {
    /**
     * 命令名称与命令本身的HashMap键值对
     */
    private static final HashMap<String, CommandCode> COMMAND = new HashMap<>();

    //初始化HashMap键值对
    static {
        for (CommandCode c : CommandCode.values()) {
            for (String s : c.getCommandName()) {
                COMMAND.put(s, c);
            }
        }
    }

    /**
     * Command类的唯一公共方法
     *
     * <p>接受命令command和参数param（可空）并查找对应CommandCode枚举，
     * 返回对应命令的文本执行结果。
     *
     * @param command 命令名称
     * @param param   命令参数
     * @return 命令对应的文本返回结果
     */
    public static String Input(String command, String param) {
        CommandCode c = COMMAND.get(command);
        return c != null ? c.Run(param) : Signal.COMMAND_NOT_FOUND_ERROR.getSignal();
    }

    /**
     * Command的内部枚举
     *
     * <p>提供所有命令的枚举和对应信息，及一些相关私有方法。
     */
    private enum CommandCode {
        EXIT(new String[]{"退出",}, "退出游戏"),
        INTRODUCTION(new String[]{"你好", "你是", "?", "？"}, "介绍游戏"),
        PLAYER_INFORMATION(new String[]{"我的信息",}, "角色的详细信息"),
        BOX_INFORMATION(new String[]{"我的背包"}, "查看背包"),
        CHARACTERS_INFORMATION(new String[]{"我的角色"}, "查看角色"),
        SET_CHARACTERS(new String[]{"修改角色"}, "修改角色为新角色"),
        SET_PLAYER_ID(new String[]{"改名", "修改名字"}, "修改角色的名字"),
        HELP(new String[]{"帮助", "[帮助]"}, "命令列表,或返回命令的别名，如“帮助帮助”"),
        HELP_THING(new String[]{"介绍"},"介绍某物品或任务"),
        //--------------------------------------------------------------------------------------
        HONE(new String[]{"修炼", "修行", "观悟"}, "开始修炼或结束修炼"),
        EXIT_HONE(new String[]{"结束修炼"}, "强制结束修炼，可能没有收益"),
        BREAKTHROUGH(new String[]{"突破",}, "提升等级"),
        //--------------------------------------------------------------------------------------
        SET_EQUIPMENT(new String[]{"装备"}, "装备装备"),
        REMOVE_EQUIPMENT(new String[]{"卸下"}, "卸下装备"),
        //--------------------------------------------------------------------------------------
        CRAFT(new String[]{"合成"},"合成物品"),
        TO_CRAFT(new String[]{"预合成"},"查看合成物品所需材料"),
        TO_USE(new String[]{"使用"},"使用物品"),
        //--------------------------------------------------------------------------------------
        RECOVER_ENERGY(new String[]{"回复体力", "恢复体力"}, "根据休息时间回复体力"),
        MINING(new String[]{"挖矿", "采矿"}, "挖矿n次"),
        LOGGING(new String[]{"采伐","砍伐","砍树"},"采伐n次"),
        //--------------------------------------------------------------------------------------
        ALL_QUEST(new String[]{"我的任务","任务"},"任务清单"),
        ACHIEVE_QUEST(new String[]{"完成任务", "提交"}, "完成一个任务"),
        //--------------------------------------------------------------------------------------
        BUY(new String[]{"购买", "买"}, "购买商品"),
        //--------------------------------------------------------------------------------------
        ROLL(new String[]{"抽卡"}, "介绍抽卡"),
        SOLO_ROLL(new String[]{"单抽", "一抽"}, "抽一发卡"),
        MULTI_ROLL(new String[]{"十连", "十抽"}, "抽十张卡"),
        //--------------------------------------------------------------------------------------
        STAT_INFORMATION(new String[]{"我的属性", "属性"}, "查看属性");

        private final String[] commandName;
        private final String description;

        CommandCode(String[] strings, String description) {
            this.commandName = strings;
            this.description = description;
        }

        /**
         * Command内置命令HELP的方法
         *
         * <p>根据参数param是否为<strong>空</strong>返回不同值，
         * 为空时调用返回getCommandDescription；
         * 不为<strong>空</strong>时查找param对应的命令并返回详细值。
         *
         * @param param 命令的名称
         * @return 格式化的命令列表或命令的详细信息
         */
        private static String getHelp(String param) {
            if (param.isBlank()) {
                return getCommandDescription();
            }
            CommandCode c = COMMAND.get(param);
            if (c == null) {
                return Signal.COMMAND_NOT_FOUND_ERROR.getSignal() + ":" + param;
            }//不是最优写法
            StringBuilder rtn = new StringBuilder(param + ": " + c.description + "\n命令别称: ");
            for (String s : c.getCommandName()) {
                rtn.append(s).append(" ");
            }
            return rtn.toString();
        }

        /**
         * Command内置命令HELP的<strong>辅助</strong>方法
         *
         * <p>遍历CommandCode枚举，将命令主要称呼和其详细信息格式化输出。
         *
         * @return 格式化的命令列表
         */
        private static String getCommandDescription() {
            StringBuilder rtn = new StringBuilder("【命令列表】\n");
            for (CommandCode c : CommandCode.values()) {
                rtn.append("%s%s: %s\n".formatted(c.commandName[0],"\u3000".repeat(4-c.commandName[0].length()),c.description));
            }

            return rtn.toString();
        }

        /**
         * 执行对应命令的方法
         *
         * @param param 命令参数
         * @return 命令的文本返回结果
         */
        private String Run(String param) {
            String rtn = "";
            switch (this) {
                case EXIT: {
                    rtn = Central.exit();
                    break;
                }
                case INTRODUCTION: {
                    rtn = "我是一款文字游戏喵,输入[帮助]获取命令列表";
                    break;
                }
                case PLAYER_INFORMATION: {
                    rtn = Information.getPlayerInformation();
                    break;
                }
                case BOX_INFORMATION: {
                    rtn = Information.getBoxInformation();
                    break;
                }
                case CHARACTERS_INFORMATION: {
                    rtn = Information.getCharactersInformation();
                    break;
                }
                case SET_CHARACTERS: {
                    rtn = PlayerCharacterManager.setCharacter(param);
                    break;
                }
                case SET_PLAYER_ID: {
                    rtn = Information.setPlayerID(param);
                    break;
                }
                case HELP: {
                    rtn = getHelp(param);
                    break;
                }
                case  HELP_THING: {
                    rtn = Information.getThingInformation(param);
                    break;
                }
//--------------------------------------------------------------------------------------
                case HONE: {
                    rtn = Hone.hone();
                    break;
                }
                case EXIT_HONE: {
                    rtn = Hone.exitHone();
                    break;
                }
                case BREAKTHROUGH: {
                    rtn = Hone.Breakthrough();
                    break;
                }
//--------------------------------------------------------------------------------------
                case SET_EQUIPMENT: {
                    rtn = EquipmentManager.setEquipment(param);
                    break;
                }
                case REMOVE_EQUIPMENT: {
                    rtn = EquipmentManager.removeEquipment(param);
                    break;
                }
//--------------------------------------------------------------------------------------
                case CRAFT: {
                    rtn = Craft.craft(param);
                    break;
                }
                case TO_CRAFT: {
                    rtn = Craft.toCraft(param);
                    break;
                }
                case TO_USE: {
                    rtn = UseItem.useItem(param);
                    break;
                }
//--------------------------------------------------------------------------------------
                case RECOVER_ENERGY: {
                    rtn = EnergyManager.recoverEnergy();
                    break;
                }
                case MINING: {
                    rtn = Mining.mining(param);
                    break;
                }
                case  LOGGING: {
                    rtn = Logging.logging(param);
                    break;
                }
//--------------------------------------------------------------------------------------
                case BUY: {
                    rtn = ShopManager.buyShopItem(param);
                    break;
                }
//--------------------------------------------------------------------------------------
                case ALL_QUEST: {
                    rtn = QuestManager.getQuestList();
                    break;
                }
                case ACHIEVE_QUEST: {
                    rtn = QuestManager.achieveQuest(param);
                    break;
                }
//--------------------------------------------------------------------------------------
                case ROLL: {
                    rtn = Roll.roll();
                    break;
                }
                case SOLO_ROLL: {
                    rtn = Roll.soloRoll();
                    break;
                }
                case MULTI_ROLL: {
                    rtn = Roll.multiRoll();
                }
                break;
//--------------------------------------------------------------------------------------
                case STAT_INFORMATION: {
                    rtn = Stat.getStatInformation();
                    break;
                }
            }
            return rtn;
        }

        public String[] getCommandName() {
            return commandName;
        }

    }

}


