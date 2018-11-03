package Servlets.Util;

import java.io.File;

public class util {
    public static void main(String[] args){
        String file = new File("").getAbsoluteFile().toString();
        System.out.println(file);
    }
}
