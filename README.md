# 类QQ群机器人文字游戏
> 一个基于Java的文本文字游戏项目，目前处于demo阶段。
---
## 功能
 - 本地存档（JSON）
 - 抽卡系统
 - 升级系统
 - 商店系统（半成品）
 - 任务系统（半成品）
 - 战斗系统（大抵完成了）
 - 合成系统（合成表和物品太少）
---
## 关于项目
### 程序入口：src/Main
>其实src/window目录下存在基于Swing的UI界面（来自作者另外一个很不成熟的代码项目），入口在src/Main中被注释
---
## 项目结构
```
├─lib/gson-2.13.2.jar   Gson依赖项
└─src/com/example/lrtextgame
    ├─central   控制命令的输入和结果的输出
    ├─command   存放各种命令
    │  ├─command.java 接受来自central的命令，选择合适的方法执行
    │  ├─action       采集相关方法
    │  ├─craft        合成相关方法
    │  ├─fight        战斗相关方法
    │  ├─quest        任务相关方法
    │  └─shop         商店相关方法
    │  ...此处省略了单个文件提供的方法
    ├─data      数据枚举相关
    │  ├─character   角色相关枚举和方法
    │  └─item        物品相关枚举和方法
    │      ├─equipment    装备相关枚举和方法
    │      ├─material     材料相关枚举和方法
    │      └─semiProduct  半成品相关枚举和方法
    ├─save      存档相关
    └─winodw    EXE窗口相关方法（未启用）
    Main.java   程序入口
```
---
## 依赖
 - Gson 
bin/gson-2.13.2.jar