package com.ngari.ucenter.common;

import com.ngari.ucenter.common.utils.RandomUtils;
import org.junit.Test;

import java.util.Random;

/**
 * Created by win on 2019/8/18.
 */
public class RandomUtilsTests {
    @Test
    public void getRandomMobileTest() {
        Random random=new Random();
        for(int i=0;i<10;i++) {
            int number = random.nextInt(3);
            System.out.print(number);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<8;i++){
            int number=random.nextInt(8);
            sb.append(String.valueOf(number));
        }
        System.out.println("\n"+sb);
        System.out.println(RandomUtils.getRandomMobile(0));
        System.out.println(RandomUtils.getRandomMobile(1));
        System.out.println(RandomUtils.getRandomMobile(2));
        System.out.println(RandomUtils.getRandomMobile(3));
    }
    @Test
    public void getRandomIDTest() {
        System.out.println(RandomUtils.getRandomID());
    }
}
