package org.example.excute;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SqlProcess {
    private static String readFile(){
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = "C:\\My_Project\\java\\LeetCode\\leetcode-solution\\src\\main\\java\\org\\example\\excute\\sqls";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            System.err.println("读取文件时发生错误: " + e.getMessage());
        }
        return stringBuilder.toString();
    }
    static String processSql(String sql_statement){
        StringBuilder stringBuilder = new StringBuilder();
        int startIndex = sql_statement.indexOf("(");
        String contentAfterBracket = sql_statement.substring(startIndex + 1, sql_statement.length() - 1);
        String contentBeforeBracket = sql_statement.substring(0, startIndex+1);
        stringBuilder.append(contentBeforeBracket+"\n");
        String[] columns = contentAfterBracket.split(",");
        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
//            System.out.println(column.trim());
            String line = column.trim();
            String[] ls = line.split(" ");
            if (ls.length>2 || ls[0].contains("-")|| ls[0].contains("(") || ls[0].equals("LEVEL")){
                int firstSpaceIndex = line.indexOf("VARCHAR")-1;
                String name = line.substring(0, firstSpaceIndex);   // 提取名称部分
                String rest = line.substring(firstSpaceIndex);      // 提取剩余部分
                String formattedLine = "\"" + name + "\"" + rest;   // 拼接字符串，添加引号
                if (i != columns.length-1){
                    stringBuilder.append(formattedLine+","+"\n");
                }else {
                    stringBuilder.append(formattedLine+");"+"\n");
                }
            }else {
                if (i != columns.length-1){
                    stringBuilder.append(line+","+"\n");
                }else {
                    stringBuilder.append(line+");"+"\n");
                }
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String content = "";

        try {
            FileWriter writer = new FileWriter("C:\\My_Project\\java\\LeetCode\\leetcode-solution\\src\\main\\java\\org\\example\\excute\\res");
            String s = readFile();
            String [] statement=s.split(";");
            for(int i=0;i<statement.length;i++){
                if (statement[i].contains("CREATE TABLE")){
                    String s1= processSql(statement[i]);
//                    System.out.println(s1);
//                    content+=s1+"\n";
                    writer.write(s1+"\n");
                }
                if (statement[i].contains("CREATE INDEX")){
//                    System.out.println();
                    writer.write(statement[i]+";\n");
//                    content+=statement[i]+";\n";
                }

            }


            writer.close();
            System.out.println("String has been written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
