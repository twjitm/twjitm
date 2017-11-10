package com.twjitm.receipt.entity;

import com.twjitm.receipt.service.Impl.ReceiptServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 文江 on 2017/9/6.
 * 辅助类
 */
public class Equzlize {

    public static void main(String[] args) {
        List<Integer> uIds = new ArrayList<Integer>();
        for (int i = 1; i < 6; i++) {
            uIds.add(i);
        }
        List<Receipt> reports = new ArrayList<Receipt>();
        Receipt receipt1 = new Receipt();
        Receipt receipt2 = new Receipt();
        Receipt receipt3 = new Receipt();
        Receipt receipt4 = new Receipt();
        Receipt receipt5 = new Receipt();
        receipt1.setUid(1);
        receipt1.setMoney(3);
        receipt2.setUid(2);
        receipt2.setMoney(3);
        receipt3.setUid(3);
        receipt3.setMoney(4);
        receipt4.setUid(4);
        receipt4.setMoney(2);
        receipt5.setUid(5);
        receipt5.setMoney(0);
        reports.add(receipt1);
        reports.add(receipt2);
        reports.add(receipt3);
        reports.add(receipt4);
        reports.add(receipt5);
        ReceiptServiceImpl receiptService = new ReceiptServiceImpl();
        receiptService.getEquzlizeList(reports, uIds);
    }


    private Integer equxUid;
    private Integer beqUzUid;
    private Double muchMoney;

    public Integer getEquxUid() {
        return equxUid;
    }

    public void setEquxUid(Integer equxUid) {
        this.equxUid = equxUid;
    }

    public Integer getBeqUzUid() {
        return beqUzUid;
    }

    public void setBeqUzUid(Integer beqUzUid) {
        this.beqUzUid = beqUzUid;
    }

    public Double getMuchMoney() {
        return muchMoney;
    }

    public void setMuchMoney(Double muchMoney) {
        this.muchMoney = muchMoney;
    }
    //    1      2        3      4         5
    //     3      3        4      2         0
    //               2.4
    //    1     2         3
    //    0.6   0.6      1.6

    //   4          5
    //  -0.4       -2.4
}
