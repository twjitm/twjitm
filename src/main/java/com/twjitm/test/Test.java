package com.twjitm.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by 文江 on 2017/9/24.
 */
public class Test {


    // public static void main(String[] args) {
    //  String value1 = "999";
    // String value2 = "999";
       /* Stack<Integer> stack = new Stack();
        Stack<Integer> stack1 = new Stack();
        for (int i = 0; i < 4; i++) {
            stack.push(9);
            stack1.push(9);
        }
        Stack<Integer> stack2 = accumulate(stack, stack1);
        for (int i = 0; i < stack2.size(); i++) {
            System.out.println(stack2.pop());
        }*/
    //  System.out.println(accumulateNum(value1, value2));

    // }

    /**
     * 2个大数相加加法
     *
     * @param value1
     * @param value2
     * @return
     */
    public static String accumulateNum(String value1, String value2) {
        StringBuffer result = new StringBuffer();
        value1 = new StringBuffer(value1).reverse().toString();
        value2 = new StringBuffer(value2).reverse().toString();
        int len1 = value1.length();
        int len2 = value2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        int nTakeOver = 0;
        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                value1 += "0";
            }
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                value2 += "0";
            }
        }
        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(value1.charAt(i) + "") + Integer.parseInt(value2.charAt(i) + "");
            if (nSum >= 10) {
                result.append(nSum + nTakeOver - 10);
                nTakeOver = 1;
            } else {
                if (nSum + nTakeOver >= 10) {
                    result.append(nSum + nTakeOver - 10);
                    nTakeOver = 1;
                } else {
                    result.append(nSum + nTakeOver);
                    nTakeOver = 0;
                }
            }
        }
        if (nTakeOver == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }


    public String addDoubleBagNum1(String value1, String value2) {
        char[] chars1 = value1.toCharArray();
        char[] chars2 = value2.toCharArray();
        Integer[] intarray1 = new Integer[chars1.length];
        Integer[] intarray2 = new Integer[chars2.length];
        int minLeng = intarray1.length > intarray2.length ? intarray1.length : intarray2.length;
        boolean nOverFlow;
        for (int i = minLeng - 1; i > 0; i--) {
            intarray1[i] = (nOverFlow = (intarray1[i] + intarray2[i]) > 10) ? intarray1[i] + intarray2[i] % 10 : intarray1[i] + intarray2[i];
            if (nOverFlow) {
                intarray1[i - 1]++;
            }
        }

        return "";
    }

    public static Stack<Integer> accumulate(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> temp = new Stack<Integer>();
        Stack<Integer> now = new Stack<Integer>();
        int carry;//进位
        int or;
        int ele1 = 0, ele2 = 0, eletemp;
        carry = 0;
        while (s1.isEmpty() == false || s2.isEmpty() == false) {
            while (s1.isEmpty() == false && s2.isEmpty() == false) {
                ele1 = s1.pop();//弹出栈顶元素，即最低位
                ele2 = s2.pop();//弹出栈顶元素，即最低位
                eletemp = ele1 + ele2;
                temp.push(eletemp);

            }
            while (s1.isEmpty() && s2.isEmpty() == false) {
                ele2 = s2.pop();
                eletemp = ele2;
                temp.push(eletemp);
            }
            while (s2.isEmpty() && s1.isEmpty() == false) {
                ele1 = s1.pop();
                eletemp = ele1;
                temp.push(eletemp);
            }
        }
        Integer j;
        j = temp.pop();
        while (j > 9 && temp.size() >= 1) {
            now.push(((j % 10) + carry));
            carry = 1;
            if (temp.isEmpty() == false) {
                j = temp.pop();
            }
        }
        while (j <= 9 && temp.size() >= 1) {
            now.push((j + carry));
            carry = 0;
            if (temp.isEmpty() == false) {
                j = temp.pop();
            }
        }
        now.push((j + carry));
        return now;
    }

    public static void main(String[] args) {
     //   create(World.class, World.class);
    //    mapTest();
     //   seqSum(14);
        forTest();
    }

    public static <X, Y extends X> void create(Class<Y> clazz, Class<X> inter) {
        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(obj.getClass().isAssignableFrom(inter));
        System.out.println(obj.getClass().equals(inter));
    }

    /**
     * 求逆序对
     */
    public static String getInverse(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int middleIndex = startIndex + endIndex / 2;//小于
        System.out.println(middleIndex);

        return "";
    }


    public void mroge(int[] array1, int[] array2[]) {

    }

    /**
     * 对于一个给定的正整数 n ，请你找出一共有多少种方式使 n 表示为若干个连续正整数的和，要求至少包括两个正整数。如 n=15 时，
     * 可以有 3 种方式：（ 1+2+3+4+5 ），（ 4+5+6 ），（ 7+8 ）。
     */
    public static String seqSum(int n) {

        if (n < 3) return null;
        for (int i = 2; i < n / 2; i++) {
            if ((2 * n) % i == 0) {
                int temp1 = 2 * n - i * i + i;
                int temp2 = 2 * n + i * i - i;
                if (temp1 % (2 * i) == 0 && temp2 % (2 * i) == 0) {
                    int start = temp1 / (2*i);
                    if(start==0)break;
                    int end = temp2 / (2*i);
                    System.out.println(start+":"+end);
                }
            }
        }
        return "";
    }




    public static void mapTest(){
        Map<String ,Object> hashMap=new HashMap<String, Object>();
        hashMap.put(null,null);

    }
    public static void forTest(){
        int a=0;
        for(int i=0;i<10;i++){
            a+=a++;
        }
        System.out.println(a);
    }

}
