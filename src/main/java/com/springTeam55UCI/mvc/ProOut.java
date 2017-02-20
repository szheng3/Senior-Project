package com.springTeam55UCI.mvc;


import java.io.File;
import java.io.PrintWriter;

/**
 * Created by Shuai Zheng on 11/23/16.
 */
public class ProOut {
    public static void main(String[] args) {
        ProOut test = new ProOut();
        test.ProFileOutApplication("/Users/zhengshuai", "now");


    }


    public void ProFileOutApplication(String Path, String Filename) {

        try {
            PrintWriter writer = new PrintWriter(Path + File.separator + "proguard.pro", "UTF-8");
            writer.println("-injars " + Filename);
            writer.println("-outjars obfuscation.jar");
            //need to be fixed in the windows
            writer.println("-libraryjars <java.home>/lib/rt.jar");

//
//            writer.println("-printmapping out.map\n" +
//                    "-renamesourcefileattribute SourceFile\n" +
//                    "-keepattributes SourceFile,LineNumberTable\n" +
//                    "\n" +
//                    "# Preserve all annotations.\n" +
//                    "\n" +
//                    "-keepattributes *Annotation*\n" +
//                    "\n" +
//                    "# You can print out the seeds that are matching the keep options below.\n" +
//                    "\n" +
//                    "#-printseeds out.seeds\n" +
//                    "\n" +
//                    "# Preserve all public applications.\n" +
//                    "\n" +
//                    "-keepclasseswithmembers public class * {\n" +
//                    "    public static void main(java.lang.String[]);\n" +
//                    "}\n" +
//                    "\n" +
//                    "# Preserve all native method names and the names of their classes.\n" +
//                    "\n" +
//                    "-keepclasseswithmembernames,includedescriptorclasses class * {\n" +
//                    "    native <methods>;\n" +
//                    "}\n" +
//                    "\n" +
//                    "# Preserve the special static methods that are required in all enumeration\n" +
//                    "# classes.\n" +
//                    "\n" +
//                    "-keepclassmembers,allowoptimization enum * {\n" +
//                    "    public static **[] values();\n" +
//                    "    public static ** valueOf(java.lang.String);\n" +
//                    "}\n" +
//                    "\n" +
//                    "# Explicitly preserve all serialization members. The Serializable interface\n" +
//                    "# is only a marker interface, so it wouldn't save them.\n" +
//                    "# You can comment this out if your application doesn't use serialization.\n" +
//                    "# If your code contains serializable classes that have to be backward \n" +
//                    "# compatible, please refer to the manual.\n" +
//                    "\n" +
//                    "-keepclassmembers class * implements java.io.Serializable {\n" +
//                    "    static final long serialVersionUID;\n" +
//                    "    static final java.io.ObjectStreamField[] serialPersistentFields;\n" +
//                    "    private void writeObject(java.io.ObjectOutputStream);\n" +
//                    "    private void readObject(java.io.ObjectInputStream);\n" +
//                    "    java.lang.Object writeReplace();\n" +
//                    "    java.lang.Object readResolve();\n" +
//                    "}\n" +
//                    "-ignorewarnings\n");

            writer.println("-printmapping out.map\n" +
                    "-renamesourcefileattribute SourceFile\n" +
                            "-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,EnclosingMethod\n" +
                    "\n" +
                    "# Preserve all annotations.\n" +
                    "\n" +
                    "-keepattributes *Annotation*\n" +
                    "\n" +
                    "# You can print out the seeds that are matching the keep options below.\n" +
                    "\n" +
                    "#-printseeds out.seeds\n" +
                    "\n" +
                    "# Preserve all public applications.\n" +
                    "\n" +
                    "-keepclasseswithmembers public class * {\n" +
                    "    public static void main(java.lang.String[]);\n" +
                    "}\n" +
                    "\n" +
                            "\n" +
                            "-keep public class * {\n" +
                            "    public protected *;\n" +
                            "}\n" +
                    "# Preserve all native method names and the names of their classes.\n" +
                    "\n" +
                    "-keepclasseswithmembernames,includedescriptorclasses class * {\n" +
                    "    native <methods>;\n" +
                    "}\n" +
                    "\n" +

                            "-keepclassmembernames class * {\n" +
                            "    java.lang.Class class$(java.lang.String);\n" +
                            "    java.lang.Class class$(java.lang.String, boolean);\n" +
                            "}\n" +

                    "# Preserve the special static methods that are required in all enumeration\n" +
                    "# classes.\n" +
                    "\n" +
                    "-keepclassmembers,allowoptimization enum * {\n" +
                    "    public static **[] values();\n" +
                    "    public static ** valueOf(java.lang.String);\n" +
                    "}\n" +
                    "\n" +
                    "# Explicitly preserve all serialization members. The Serializable interface\n" +
                    "# is only a marker interface, so it wouldn't save them.\n" +
                    "# You can comment this out if your application doesn't use serialization.\n" +
                    "# If your code contains serializable classes that have to be backward \n" +
                    "# compatible, please refer to the manual.\n" +
                    "\n" +
                    "-keepclassmembers class * implements java.io.Serializable {\n" +
                    "    static final long serialVersionUID;\n" +
                    "    static final java.io.ObjectStreamField[] serialPersistentFields;\n" +
                    "    private void writeObject(java.io.ObjectOutputStream);\n" +
                    "    private void readObject(java.io.ObjectInputStream);\n" +
                    "    java.lang.Object writeReplace();\n" +
                    "    java.lang.Object readResolve();\n" +
                    "}\n" +

                            "-keepclassmembers class * {\n" +
                            "    @fully.qualified.package.AnnotationType *;\n" +
                            "}\n" +
                            "-keep class javax.annotation.**\n" +
                            "{\n" +
                            "     *;\n" +
                            "}\n" +

                            "-keep class edu.umd.**\n" +
                            "{\n" +
                            "     *;\n" +
                            "}\n" +

                            "-ignorewarnings\n" +
                            "-dontoptimize" +
                            "\n" +
                            "-dontpreverify" +
                            "\n" +
//                    "-dontobfuscate\n" +
                            "-dontshrink\n" +
                            "-target 1.7"
            );

//
//            (-dontoptimize)
//            (-dontpreverify)

            writer.close();
        } catch (Exception e) {
            // do something
        }
    }

}
