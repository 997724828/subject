package club.yuyang.subject.enums;

/**用于星期的枚举类型
 * @author yuyang
 * @date 2019/10/29 13:47
 */
public enum EnumWeek {
    MON(1,"星期一"),TUS(2,"星期二"),WEN(3,"星期三"),THU(4,"星期四"),FRI(5,"星期五"),SAT(6,"星期六"),SUN(0,"星期日");


    private final int weekId;
    private final String weekName;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    EnumWeek(int weekId,String weekName) {
        this.weekId = weekId;
        this.weekName = weekName;
    }

    public int getWeekId() {
        return weekId;
    }

    // 普通方法
     public static String getWeekName(int weekId) {
        for (EnumWeek e : EnumWeek.values()) {
            if (e.getWeekId() == weekId) {
                return e.weekName;
            }
        }
        return null;
    }
}
