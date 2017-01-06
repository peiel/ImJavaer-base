package com.elong.annotations.database;

/**
 * 创建人 : peierlong
 * 描述 :
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;
    @SQLString(40)
    String lastName;
    @SQLInteger
    Integer age;
    @Constraints(primaryKey = true)
    String handler;
    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandler() {
        return handler;
    }

    @Override
    public String toString() {
        return handler;
    }
}
