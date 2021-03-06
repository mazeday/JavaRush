package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        //тут д/б проверка аргументов
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File folder = new File(path);
        File result = new File(resultFileAbsolutePath);

        File resultRenamed = new File(result.getParent() + File.separator + "allFilesContent.txt");
        FileUtils.renameFile(result, resultRenamed);

        //должен быть сразу после переименования, потомучтоЪ
        FileOutputStream fileOutputStream = new FileOutputStream(resultRenamed);

        //как только закрыл здесь - прошёл валидатор.
        fileOutputStream.close();

        //сбор файлов в заданом каталоге <50 байт, сортировка
        ArrayList<File> files = new ArrayList<>();
        files = folderOpener(folder);
        sortFilesByName(files);

        //а хотел вот так поработать с потоками.
        /*
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        */

        //вот теперb проходит. wat
        fileOutputStream = new FileOutputStream(resultRenamed);
        /*
        try{
            fileOutputStream = new FileOutputStream(resultRenamed);
        */

        for(File file: files){
            FileInputStream fileInputStream = new FileInputStream(file);

            byte buff[] = new byte[fileInputStream.available()];
            fileInputStream.read(buff);
            fileOutputStream.write(buff);

            fileOutputStream.flush();
            fileOutputStream.write("\n".getBytes()); //можно использовать System.lineSeparator(), но на всякий случай так, а вдруг ВАЛИДАТОР

            fileInputStream.close();
        }
        fileOutputStream.close();

    }
    //сортировка
    public static void sortFilesByName(ArrayList<File> list){
        list.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return (o1.getName()).compareTo(o2.getName());
            }
        });
    }

    //перебор файлов и каталогов в рекурсии (не уверен что рекурсия - здравое решение)
    public static ArrayList<File> folderOpener(File directory){
        ArrayList<File> fileList = new ArrayList<>();
        File file = new File(directory.getAbsolutePath());

        for(File entry: file.listFiles()){
            if(entry.isDirectory()) {
                ArrayList<File> innerFiles = folderOpener(entry);
                for(File inner: innerFiles){
                    fileList.add(inner);
                }
            }else{
                if (entry.length() > 50) {
                    FileUtils.deleteFile(entry);
                } else {
                    fileList.add(entry);
                }
            }
        }
        return fileList;
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}