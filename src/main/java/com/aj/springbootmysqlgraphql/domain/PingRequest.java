package com.aj.springbootmysqlgraphql.domain;

public class PingRequest {

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "PingRequest{" +
                "input='" + input + '\'' +
                '}';
    }
}
