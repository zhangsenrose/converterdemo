package com.ht.converter;

public class ConverterTask implements Runnable {

    private String fileName;


    public ConverterTask(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void run() {
        //执行处理方法
        /*转换器处理类*/
        Converter converter = new Converter();
        converter.convert(fileName);
    }
}
