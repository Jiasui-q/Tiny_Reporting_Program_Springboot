/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.java.tiny_reporting.flow;

import com.java.tiny_reporting.flow.nodes.Node;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qinjiasui.qjs
 * @version FlowEngine: FlowEngine.java, v 0.1 2021年05月17日 下午2:07 qinjiasui.qjs Exp $
 */
public class FlowEngine {

    private static Flow flow;

    @Autowired
    public void init(){

    }

    public void setFlow(Flow flow){
        this.flow = flow;
    }

    public void executeFlow(){
        for(Node node: flow.getNodeList()){
            node.execute();
        }
    }
}
