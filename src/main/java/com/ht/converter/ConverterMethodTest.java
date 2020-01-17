package com.ht.converter;

import com.ht.common.ThreadPoolManager;


public class ConverterMethodTest {

    public static void main(String[] args) {


        ThreadPoolManager poolManager = ThreadPoolManager.getsInstance();

        System.out.println("多线程开始执行转换start=====>>>>>>>>>>" );
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 1; i ++  ) {
            ConverterTask task = new ConverterTask(String.valueOf(i));
            poolManager.execute(task);
        }

        poolManager.shutDown();

        /*判断线程池中的任务是否执行完毕*/
        while (true) {
            if (poolManager.isTerminated()) {
                long end = System.currentTimeMillis();
                System.out.println("多线程开始执行转换时间end=====>>>>>>>>>>" + (end - start) + "ms" );
                break;
            }
        }
    }


}
