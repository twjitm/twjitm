package com.twjitm.answer.enums;

/**
 * Created by 文江 on 2017/11/30.
 */
public enum Qtypes {
    TYPE_CHOICES(0, "一、选着题"),
    TYPE_JUDGE(1, "二、判断题"),
    TYPE_GAP(2, "三、填空题"),
    TYPE_NUOM(3, "四、名称解释题"),
    TYPW_SHORT(4, "五、简答题"),
    TYPE_SUBJECTATIVITY(5, "六、主观题");
    private int value;
    private String title;

    Qtypes(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getTitle(int value) {
        String title = null;
        switch (value) {
            case 0:
                title = TYPE_CHOICES.getTitle();
                break;
            case 1:
                title = TYPE_JUDGE.getTitle();
                break;
            case 2:
                title = TYPE_GAP.getTitle();
                break;
            case 3:
                title = TYPE_NUOM.getTitle();
                break;
            case 4:
                title = TYPW_SHORT.getTitle();
                break;
            case 5:
                title = TYPE_SUBJECTATIVITY.getTitle();
                break;
        }
        return title;
    }

    public static int[] getAllExplainTypeValue() {
        int[] value = {TYPE_JUDGE.getValue(), TYPE_GAP.getValue(), TYPE_NUOM.getValue(), TYPW_SHORT.getValue(), TYPE_SUBJECTATIVITY.getValue()};
        return value;
    }
}
