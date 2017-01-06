package com.elong.enumerated;

/**
 * 创建人 : peierlong
 * 描述 : 为枚举中的类型添加描述
 */
public enum OzWitch {
    PEI("peierlong"), ER("erlongpei"), LONG("longerpei");

    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
//        PEI.setDescription("hehehe");
        for (OzWitch ozWitch : OzWitch.values()) {
            System.out.println(ozWitch + " " + ozWitch.getDescription());
        }
    }

}
