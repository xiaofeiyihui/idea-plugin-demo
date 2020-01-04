package com.xfyh.idea.plugin.baidu;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/12/12 18:27
 */
public class TransResult {
    private String src;
    private String dst;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    @Override
    public String toString() {
        return "TransResult{" +
                "src='" + src + '\'' +
                ", dst='" + dst + '\'' +
                '}';
    }
}
