package lsieun.utils;

import lsieun.classfile.Attributes;
import lsieun.classfile.ClassFile;
import lsieun.classfile.FieldInfo;
import lsieun.classfile.Fields;

import java.util.ArrayList;
import java.util.List;


public class FieldUtils {
    public static FieldInfo findField(ClassFile classFile, String nameAndType) {
        return findField(classFile.fields, nameAndType);
    }

    public static FieldInfo findField(Fields fields, String nameAndType) {
        if(StringUtils.isBlank(nameAndType)) return null;

        FieldInfo[] entries = fields.entries;
        for(FieldInfo item: entries) {
            String value = item.value;
            if(nameAndType.equals(value)) {
                return item;
            }
        }
        System.out.println("Field DOES NOT EXIST: " + nameAndType);
        displayAvailableFields(fields);
        return null;
    }

    public static void displayAvailableFields(Fields fields) {
        FieldInfo[] entries = fields.entries;
        if(entries != null && entries.length > 0) {
            System.out.println("Available Fields:");
            for(FieldInfo item : entries) {
                Attributes attributes = item.attributes;
                String attrNames = AttributeUtils.getAttributeNames(attributes);

                String format = "    Method='%s', AccessFlags='%s', Attrs='%s'";
                String line = String.format(format, item.value, item.getAccessFlagsString(), attrNames);
                System.out.println(line);
            }
        }
    }

    public String getFieldNames(Fields fields) {
        FieldInfo[] entries = fields.entries;

        List<String> list = new ArrayList();
        for(FieldInfo item : entries) {
            String value = item.value;
            list.add(value);
        }
        return StringUtils.list2str(list, ", ");
    }
}
