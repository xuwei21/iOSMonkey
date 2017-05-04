package com.pingan.monkey;

import com.alibaba.fastjson.JSONObject;
import macaca.client.MacacaClient;

/**
 * Created by xuwei21 on 16/12/23.
 */
public class MonkeyTapSpecialPointEvent extends MonkeyEvent{
    private int width, height;
    private MacacaClient driver;


    public MonkeyTapSpecialPointEvent(MacacaClient driver, int width, int height) {
        super(MonkeyEvent.EVENT_TYPE_TAP);
        this.width = width;
        this.height = height;
        this.driver = driver;

    }


    public int injectEvent() throws Exception {
        System.out.println("sending SpecialPoint Tap Event : Tap->(" + this.width + ", " + this.height + ")");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", this.width);
        jSONObject.put("y", this.height);
        driver.touch("tap", jSONObject);
        //driver.touchAsync("tap", jSONObject);
        return MonkeyEvent.INJECT_SUCCESS;
    }
}
