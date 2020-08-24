package com.dip.bootcamp.utilities;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ResourceHelper {

    public static void CopyFile(InputStream srcStream, Path destination) throws IOException {
        System.out.println(srcStream);
        System.out.println(destination);
        Files.copy(srcStream, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    public static Boolean DeleteFile(File fileToDelete) throws IOException {

        Boolean retVal = Boolean.FALSE;
        try {
            retVal = Files.deleteIfExists(fileToDelete.toPath()); //surround it in try catch block
        } catch (IOException ex) {
            // ex.printStackTrace();
        }
        return retVal;
    }

    // get file from classpath, resources folder
    public static File getFileFromResources(String fileName) throws UnsupportedEncodingException {

        ClassLoader classLoader = ResourceHelper.class.getClassLoader();

        System.out.println("Nama File");
        System.out.println(fileName);

        String path = classLoader.getResource(fileName).toString();
        path = URLDecoder.decode(path, "UTF-8");
        path = path.replaceAll("file:/", "");
        path = path.replaceAll("\\u0020", "\\ ");
        File verLocation = new File(path);

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(path);
        }

    }

    public static String getStringPath(String path) throws UnsupportedEncodingException {
        String outString = path;
        path = URLDecoder.decode(path, "UTF-8");
        path = path.replaceAll("file:/", "");

        path = path.replaceAll("\\u0020", "\\ ");
        File verLocation = new File(path);
        return verLocation.getParent();
    }

    public static String getResourcePath() throws UnsupportedEncodingException {
        File tmpFile = getFileFromResources(InformationConstant.TMP_RESOURCE_FILE);
        String parentPath = getStringPath(tmpFile.getParent());
        return parentPath;
    }

    public static String getFilePathFromResource(String fileName, String fileExtension) throws IOException {

        System.out.println("File Name" + fileName);
        System.out.println("File Extension " + fileExtension);

        InputStream in = null;
        Path out = null;

        String fileTitle = fileName + fileExtension;
        String fileTitleTemp = fileName + "-temp";


        File folderTemp = new File(System.getProperty("user.dir") + InformationConstant.PRINT_TEMPLATE_PATH);
        if (!folderTemp.exists()) {
            if (folderTemp.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        File fileTemp = new File(System.getProperty("user.dir") + InformationConstant.PRINT_TEMPLATE_PATH + fileTitleTemp + fileExtension);

        if (!fileTemp.exists()) {
            out = Paths.get(System.getProperty("user.dir"), InformationConstant.PRINT_TEMPLATE_PATH + fileTitleTemp + fileExtension);
            in = ResourceHelper.class.getResourceAsStream("/document-templates/" + fileName + fileExtension);
            CopyFile(in, out);
        } else {
            DeleteFile(fileTemp);
            out = Paths.get(System.getProperty("user.dir"), InformationConstant.PRINT_TEMPLATE_PATH + fileTitleTemp + fileExtension);
            in = ResourceHelper.class.getResourceAsStream("/document-templates/" + fileName + fileExtension);
            CopyFile(in, out);
        }

        if (in == null) {
            System.out.println("INPUT STREAM TIDAK KOSONG");
        } else {
            System.out.println("INPUT TIDAK KOSONG");
        }

        return String.valueOf(out);

    }


    public static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            // e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    // e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }

}
