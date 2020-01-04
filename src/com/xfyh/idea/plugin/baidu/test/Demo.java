package com.xfyh.idea.plugin.baidu.test;

import com.xfyh.idea.plugin.baidu.TransApi;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/12/12 18:03
 */
public class Demo {
    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20191210000364918";
    private static final String SECURITY_KEY = "MVWhS2jvR1o9L1AT2AhR";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "content";
        System.out.println(api.getTransResult(query, "en", "zh"));
    }
}
