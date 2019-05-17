package factory.admin;

import domain.admin.Class;

public class ClassFactory {

    public static Class getClass(String classGroup) {
    return new Class.Builder().classGroup(classGroup).build();
}
}
