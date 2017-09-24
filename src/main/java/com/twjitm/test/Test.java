package com.twjitm.test;

/**
 * Created by 文江 on 2017/9/24.
 */
public class Test {
    public static void main(String[] args) {
        String value1 = "12345678";
        String value2 = "12345";
        System.out.println(addDoubleBagNum(value1, value2));
    }

    /**
     * 2个大数相加加法
     *
     * @param value1
     * @param value2
     * @return
     */
    public static String addDoubleBagNum(String value1, String value2) {
        StringBuffer result = new StringBuffer();
        //1、反转字符串
        value1 = new StringBuffer(value1).reverse().toString();
        value2 = new StringBuffer(value2).reverse().toString();
        int len1 = value1.length();
        int len2 = value2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        boolean nOverFlow = false; //是否越界
        int nTakeOver = 0; //溢出数量
        //2.把两个字符串补齐，即短字符串的高位用0补齐
        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                value1 += "0";
            }
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                value2 += "0";
            }
        }

        //3.把两个正整数相加，一位一位的加并加上进位
        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(value1.charAt(i) + "") + Integer.parseInt(value2.charAt(i) + "");
            if (nSum >= 10) {
                if (i == (maxLen - 1)) {
                    nOverFlow = true;
                }
                nTakeOver = 1;
                result.append(nSum - 10);
            } else {
                nTakeOver = 0;
                result.append(nSum);
            }
        }
        //如果溢出的话表示位增加了
        if (nOverFlow) {
            result.append(nTakeOver);
        }
        return result.reverse().toString();
    }
}
