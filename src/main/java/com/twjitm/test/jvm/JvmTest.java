package com.twjitm.test.jvm;

import java.util.*;

/**
 * Created by 文江 on 2018/1/29.
 */
public class JvmTest<E> extends HashSet<E> {
    private static final Date START_DATE;
    private static final Date END_DATE;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1993, Calendar.JANUARY, 1, 0, 0, 0);
        START_DATE = calendar.getTime();
        calendar.set(2018, Calendar.JANUARY, 1, 0, 0, 0);
        END_DATE = calendar.getTime();
    }


    private int addcount = 0;

    public JvmTest() {
    }

    public JvmTest(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addcount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addcount += c.size();
        return super.addAll(c);
    }

    public int getAddcount() {
        return addcount;
    }

    public static void main(String[] args) {
        JvmTest<String> test = new JvmTest();
        test.addAll(Arrays.asList("twj", "itm"));
        System.out.println(test.getAddcount());
//        long maxMemory = Runtime.getRuntime().maxMemory();
//        System.out.println(maxMemory / (1024 * 1024));
//        while (true) {
//            try {
//                Thread.sleep(1000);
//                System.out.println("hahahah");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        //  System.out.println(4^(4>>>32));


    }
}
