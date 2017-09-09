package com.twjitm.receipt.service;

import com.twjitm.receipt.entity.Equzlize;
import com.twjitm.receipt.entity.Receipt;
import com.twjitm.receipt.enums.ReceiptStateType;

import java.util.List;

/**
 * Created by 文江 on 2017/9/6.
 */
public interface IReceiptService {
    public void addReceipt(Receipt receipt);

    public void updateReceipt(Receipt receipt);

    public List<Receipt> getReceiptByState(ReceiptStateType type);

    public List<Equzlize> getEquzlizeList(List<Receipt> reports, List<Long> uIds);

    public boolean sendMailToConcurrentPerson(String mailContext, List<String> mails);

}
