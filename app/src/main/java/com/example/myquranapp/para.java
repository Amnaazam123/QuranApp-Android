package com.example.myquranapp;

public class para {
    private int paraId;
    private String paraNameU;
    private String paraNameE;

    public int getParaId() {
        return paraId;
    }

    public void setParaId(int paraId) {
        this.paraId = paraId;
    }

    @Override
    public String toString() {
        return "para{" +
                "paraId=" + paraId +
                ", paraNameU='" + paraNameU + '\'' +
                ", paraNameE='" + paraNameE + '\'' +

                '}';
    }

    public para(int paraId, String paraNameU, String paraNameE) {
        this.paraId = paraId;
        this.paraNameU = paraNameU;
        this.paraNameE = paraNameE;
    }

    public String getParaNameU() {
        return paraNameU;
    }

    public void setParaNameU(String paraNameU) {
        this.paraNameU = paraNameU;
    }

    public String getParaNameE() {
        return paraNameE;
    }

    public void setParaNameE(String paraNameE) {
        this.paraNameE = paraNameE;
    }


}






