package com.twjitm.answer.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by 文江 on 2017/12/7.
 */
public class ChartVo {
    private Map<String, List<Choices>>mapCho;
    private Map<String,List<Explain>>mapExp;

    public Map<String, List<Choices>> getMapCho() {
        return mapCho;
    }

    public void setMapCho(Map<String, List<Choices>> mapCho) {
        this.mapCho = mapCho;
    }

    public Map<String, List<Explain>> getMapExp() {
        return mapExp;
    }

    public void setMapExp(Map<String, List<Explain>> mapExp) {
        this.mapExp = mapExp;
    }
}
