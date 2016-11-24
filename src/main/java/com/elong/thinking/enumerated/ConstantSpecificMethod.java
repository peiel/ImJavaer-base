package com.elong.thinking.enumerated;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo() {
            return "2016-08-23";
        }
    },
    CLASSPATH {
        String getInfo(){
            return System.getenv("path");
        }
    },
    VERSION{
        String getInfo(){
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod specificMethod : values()) {
            String info = specificMethod.getInfo();
            System.out.println(info);
        }
    }
}
