package com.yws.starter;

public class HelloService {

    private HelloProperties helloProperties;

    public String hello(String name) {
        return helloProperties.getPrefix() + name + helloProperties.getSuffix();
    }


    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
