package com.elong.enumerated;

/**
 * 包名: com.elong.enumerated
 * 创建人 : Elong
 * 时间: 2016/12/25 下午11:18
 * 描述 : 使用枚举来取代普通的定义常量方式
 */
public class HourlyEmployee {

    //普通的定义常量的方式
    private static final String SEXMAN = "男";
    private static final String SEXWOMAN = "女";

    public static void main(String[] args) {
        System.out.println(SEXMAN);
        System.out.println(SEXWOMAN);

        System.out.println(Sex.MAN.getSex());
        System.out.println(Sex.WOMAN.getSex());

    }

}

/**
 * 使用枚举类定义常量
 */
enum Sex {

    MAN {
        @Override
        public String getSex() {
            return "男";
        }
    },
    WOMAN {
        @Override
        public String getSex() {
            return "女";
        }
    };

    public abstract String getSex();
}




