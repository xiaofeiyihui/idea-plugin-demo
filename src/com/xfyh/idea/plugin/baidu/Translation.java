package com.xfyh.idea.plugin.baidu;

import java.util.List;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/12/12 18:18
 */
public class Translation {
    private String from;
    private String to;
    private List<TransResult> trans_result;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<TransResult> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(List<TransResult> trans_result) {
        this.trans_result = trans_result;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", trans_result=" + trans_result +
                '}';
    }
}
