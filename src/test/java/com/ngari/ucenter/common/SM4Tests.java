package com.ngari.ucenter.common;

import com.ngari.ucenter.common.security.sm4.SM4Utils;
import com.ngari.ucenter.common.utils.DateFormatUtils;
import com.ngari.ucenter.common.utils.SecurityUtils;
import org.junit.Test;
import java.util.Date;

public class SM4Tests {
    @Test
    public void sm4EBCTest(){
        String plainText = "Hello World";
        String s = SecurityUtils.byteToHex(plainText.getBytes());
        System.out.println("原文哈希:" + s);
        SM4Utils sm4 = new SM4Utils();
        //sm4.secretKey = "JeF8U9wHFOMfs2Y8";
        sm4.secretKey = "64EC7C763AB7BF64E2D75FF83A319918";
        sm4.hexString = true;

        System.out.println("ECB模式加密");
        String cipherText = sm4.encryptData_ECB(plainText);
        System.out.println("密文: " + cipherText);

        String plainText2 = sm4.decryptData_ECB(cipherText);
        System.out.println("明文: " + plainText2);
        System.out.println("");

    }

    @Test
    public void sm4CBCTest(){
        String plainText = "Hello World";
        String s = SecurityUtils.byteToHex(plainText.getBytes());
        System.out.println("原文" + s);
        SM4Utils sm4 = new SM4Utils();
        System.out.println("CBC模式加密");
        sm4.iv = "31313131313131313131313131313131";
        String cipherText2 = sm4.encryptData_CBC(plainText);
        System.out.println("加密密文: " + cipherText2);
        System.out.println("");

        String plainText3 = sm4.decryptData_CBC(cipherText2);
        System.out.println("解密明文: " + plainText3);

    }

    @Test
    public void sm4PerformanceTest(){
          String a[]={"浙江",
                  "杭州市西湖区文一西路",
                  "医院行政楼303",
                  "浙江杭州",
                  "邵逸夫医院",
                  "邵逸夫医院",
                  "三墩镇山联村",
                  "滨江戈雅公寓",
                  "浙江省杭州市滨江区潮人汇9楼k",
                  "杭州市",
                  "杭州市江干区天成嘉园",
                  "江干区景芳东区",
                  "",
                  "九堡",
                  "滨江区潮人汇",
                  "",
                  "滨江区",
                  "浙江省杭州市",
                  "浙江杭州体育场178号",
                  "杭州江干区凯旋路",
                  "杭州市江干区九堡镇金堡街287号蓝桥名苑南苑2-2-601",
                  "杭州市西湖区双浦镇板桥村二组41号",
                  "延安西路649弄",
                  "丁桥",
                  "上海市徐汇区",
                  "三里亭苑二区11-1-602",
                  "浙江省杭州市余杭区良渚街道蔚蓝郡5-1101",
                  "",
                  "",
                  "江南大道",
                  "文二新村13幢3单元307"
          };
          Date startTime = new Date();
          String ecbStartTime = DateFormatUtils.getDatetime(startTime);
          int count = 0;
        System.out.println("===========ECB模式加密开始===========" + ecbStartTime + "===========");
        for(int i=0;i<a.length;i++){
            String plainText = a[i];
            String s = SecurityUtils.byteToHex(plainText.getBytes());
            SM4Utils sm4 = new SM4Utils();
            sm4.secretKey = "64EC7C763AB7BF64E2D75FF83A319918";
            sm4.hexString = true;
            String cipherText = sm4.encryptData_ECB(plainText);
            System.out.println(cipherText);
            count = i;
        }
        Date endTime = new Date();
        String ecbEndTime = DateFormatUtils.getDatetime(endTime);
        long diff = (endTime.getTime() - startTime.getTime());
        System.out.println("===========ECB模式加密结束===========" + ecbEndTime + "======共加密"+String.valueOf(count)+"组内容=====");
        System.out.println("**********ECB模式加密花费时间" + diff +"毫秒*********");

        Date startTime2 = new Date();
        String cbcStartTime = DateFormatUtils.getDatetime(startTime2);
        int count2 = 0;
        System.out.println("===========CBC模式加密开始===========" + cbcStartTime + "===========");
        for(int i=0;i<a.length;i++){
            String plainText = a[i];
            String s = SecurityUtils.byteToHex(plainText.getBytes());
            SM4Utils sm4 = new SM4Utils();
            sm4.secretKey = "64EC7C763AB7BF64E2D75FF83A319918";
            sm4.hexString = true;
            sm4.iv = "12345678901234567890123456789012";
            String cipherText2 = sm4.encryptData_CBC(plainText);
            System.out.println(cipherText2);
            count2 = i;
        }
        Date endTime2 = new Date();
        String cbcEndTime = DateFormatUtils.getDatetime(endTime2);
        long diff2 = (endTime2.getTime() - startTime2.getTime());
        System.out.println("===========CBC模式加密结束===========" + cbcEndTime + "======共加密"+String.valueOf(count2)+"组内容=====");
        System.out.println("**********CBC模式加密花费时间" + diff2 +"毫秒*********");
    }
}
