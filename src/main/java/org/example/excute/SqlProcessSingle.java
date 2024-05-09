package org.example.excute;

public class SqlProcessSingle {
    static String processSql(String sql_statement){
        StringBuilder stringBuilder = new StringBuilder();
        int startIndex = sql_statement.indexOf("(");
        String contentAfterBracket = sql_statement.substring(startIndex + 1, sql_statement.length() - 2);
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
        String s = processSql("CREATE TABLE IM_RMW_STC.ZHONE_ZHONECOPPER_CARD (\n" +
                "\tSTATUS VARCHAR(256),\n" +
                "\tCARDNAME VARCHAR(256),\n" +
                "\tSUBID VARCHAR(256),\n" +
                "\tPART NUMBER VARCHAR(256),\n" +
                "\tSHELF VARCHAR(256),\n" +
                "\tSERIAL NUMBER VARCHAR(256),\n" +
                "\tTASKID VARCHAR(256),\n" +
                "\tIP ADDRESS VARCHAR(256),\n" +
                "\tSHELFNAME VARCHAR(256),\n" +
                "\tSLOT VARCHAR(256),\n" +
                "\tDEVICE NAME VARCHAR(256),\n" +
                "\tSLOTNAME VARCHAR(256),\n" +
                "\tFILENAME VARCHAR(256),\n" +
                "\tEMSNAME VARCHAR(256)\n" +
                ");");
        System.out.println(s);
    }

}
