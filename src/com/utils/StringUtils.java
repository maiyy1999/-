package com.utils;

public class StringUtils {
    /**
     * 判断字符串是否不为空
     * @param str
     * @return  true：表示不为空，false：表示字符串为空
     */
    public static boolean isNotNull(String str){
        return str!=null && !"".equals(str);
    }

    /**
     * 将字符串转换为Integer
     * @param str       要转换的字符串
     * @param defValue  如果转换失败则返回的默认值
     * @return
     */
    public static String str2Int(String str, String defValue){
        // 1、判断字符串是否不为空
        if(isNotNull(str)){
            try {
                return str;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return defValue;
    }

}
