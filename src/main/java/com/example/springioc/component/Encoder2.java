package com.example.springioc.component;

public class Encoder2 implements  IEncoder{
    private IEncoder iEncoder;

    public Encoder2(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    @Override
    public String encode(String message) {
        return this.iEncoder.encode(message);
    }
}
