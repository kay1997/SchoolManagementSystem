package com.factory.admin;

import com.domain.admin.Class;
import com.util.Misc;

public class ClassFactory {

    public static Class getClass(String classID, String classGroup) {

    return new Class.Builder().classID(classID).classGroup(classGroup).build(); }
}
