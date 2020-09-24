package lsieun.utils;

import lsieun.classfile.Attributes;
import lsieun.classfile.MethodInfo;
import lsieun.classfile.attrs.AttributeInfo;
import lsieun.classfile.attrs.Code;

import java.util.ArrayList;
import java.util.List;

public class AttributeUtils {
    public static AttributeInfo findAttribute(Attributes attributes, String attrName) {
        if(StringUtils.isBlank(attrName)) return null;

        AttributeInfo[] entries = attributes.entries;
        for(int i=0; i<entries.length; i++) {
            AttributeInfo item = entries[i];
            String name = item.name;
            if(attrName.equals(name)) {
                return item;
            }
        }

        //System.out.println("Attribute DOES NOT EXIST: " + attrName);
        return null;
    }

    public static Code findCodeAttribute(MethodInfo methodInfo) {
        Attributes attributes = methodInfo.attributes;
        AttributeInfo attr = findAttribute(attributes, "Code");
        if(attr == null) {
            throw new RuntimeException("Code Attribute Not Found");
        }
        return (Code) attr;
    }


    public static String getAttributeNames(Attributes attributes) {
        AttributeInfo[] entries = attributes.entries;

        List<String> attr_list = new ArrayList<>();
        for(int i=0; i<entries.length; i++) {
            AttributeInfo item = entries[i];
            String name = item.name;
            attr_list.add(name);
        }

        String attrNames = StringUtils.list2str(attr_list, "[", "]", ", ");
        if(attrNames == null) {
            attrNames = "[]";
        }
        return attrNames;
    }
}
