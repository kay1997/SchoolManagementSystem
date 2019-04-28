package factory;

import domain.Class;

public class ClassFactory {

    public static Class getClass(String classGroup) {
    return new Class.Builder().classGroup(classGroup).build();
}
}
