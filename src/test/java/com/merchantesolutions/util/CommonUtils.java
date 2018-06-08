package com.merchantesolutions.util;

import com.google.gson.Gson;
import com.merchantesolutions.api.model.CommentsDatum;
import com.merchantesolutions.api.model.PostsDatum;
import com.merchantesolutions.api.model.users.UsersDatum;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class CommonUtils {

public static String getJsonFromObject(Object object) {
    Gson gson = new Gson();

    if(object instanceof CommentsDatum) {
     return  gson.toJson((CommentsDatum) object);
    }

    return null;
}

public static Object getObjectFromJsonFile(String fileName) {

    Gson gson = new Gson();
    Object object = null;
    String filePath = "src\\test\\resources\\" + fileName;

    try {
        File dir = new File("./");
        System.out.println("absolutePath:" + dir.getAbsolutePath());

        Reader reader = new FileReader(filePath);
        //To convert Json into Java Object

        if(fileName.contains("getPosts")) {
            object = gson.fromJson(reader, PostsDatum[].class);
        } else if(fileName.contains("getComments")) {
            object = gson.fromJson(reader, CommentsDatum[].class);
        } else if(fileName.contains("getUsers")) {
            object = gson.fromJson(reader, UsersDatum[].class);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return object;
}


}
