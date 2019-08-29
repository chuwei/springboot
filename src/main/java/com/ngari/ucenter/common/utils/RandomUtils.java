package com.ngari.ucenter.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by win on 2019/8/18.
 */

public class RandomUtils {
    //生成随机字符串
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * show 生成随机电话号码
     * @param type 1: 中国移动 2: 中国联通 3: 中国电信 其他: 随机号码
     */
    public static String getRandomMobile(int type){
        String mobile[] = {"134","135","136","137","138","139","147","150","151","152","157","158","159","172","178","182","183","184","187","188","198"};
        String union[] = {"130","131","132","145","155","156","166","171","175","176","185","186","166"};
        String telecom[] = {"133","149","153","173","177","180","181","189","199"};
        Random random=new Random();
        StringBuffer sb=new StringBuffer();

        switch(type){
            case 1:
                String mobilePrefix=mobile[random.nextInt(mobile.length)];
                sb.append(mobilePrefix);
                break;
            case 2:
                String unionPrefix=union[random.nextInt(union.length)];
                sb.append(unionPrefix);
                break;
            case 3:
                String telecomPrefix=telecom[random.nextInt(telecom.length)];
                sb.append(telecomPrefix);
                break;
            default:
                int randomType=random.nextInt(3)+1;
                return getRandomMobile(randomType);
        }

        for(int i=0;i<8;i++){
            int number=random.nextInt(10);
            sb.append(String.valueOf(number));
        }
        return sb.toString();
    }
    //
    public static String getRandomName(int sex) {
        String name ="";
        try {
            if (sex == 1) {
                name = firstName() + secondName(true);
            } else if (sex == 2) {
                name = firstName() + secondName(false);
            } else {
                Random random = new Random();
                return getRandomName(random.nextInt(2) + 1);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return name;
    }

 /*
 * 随机返回a和b其中一个数
 */
    public static int randomAB(int a, int b){
        return (int)((Math.random()*Math.abs(a-b))+ Math.min(a, b));
    }

    /**
     * 生成姓氏
     * @throws IOException
     */
    private static String firstName() throws IOException{
        List<String> fistNames = loadBaiJiaXing("/asserts/familyName");
        return fistNames.get(randomAB(0,fistNames.size()));
    }

    /**
     * 读取姓氏文件，获取姓氏
     * @return
     * @throws IOException
     */
    private static List<String> loadBaiJiaXing(String path) throws IOException{
        //使用类加载器来加载文件
        InputStream in = RandomUtils.class.getResourceAsStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
        //文件读取
        String line = null;
        //结果集合
        List<String> result = new ArrayList<>(200);
        while((line=br.readLine())!=null){
            line = line.trim();
            //使用空白字符分割
            String[] names = line.split("\\s+");
            result.addAll(Arrays.asList(names));
        }
        return result;
    }

    /**
     * @生成名字
     * @return
     * @throws IOException
     */
    private static String secondName(boolean male) throws IOException{
        if(male){
            List<String> names = loadNames("/asserts/male");
            return names.get(randomAB(0,names.size()));
        }else{
            List<String> names = loadNames("/asserts/female");
            return names.get(randomAB(0,names.size()));
        }
    }
    /**
     * 读取百家姓文件，获取名字
     * @return
     * @throws IOException
     */
    private static List<String> loadNames(String path) throws IOException {
        InputStream in = RandomUtils.class.getResourceAsStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
        //文件读取
        String line = null;
        //结果集合
        List<String> result = new ArrayList<>(200);
        while((line=br.readLine())!=null){
            line = line.trim();
            //使用空白字符分割
            String[] names = line.split("\\s+");
            result.addAll(Arrays.asList(names));
        }
        return result;
    }


    /**
     * 获取随机生成的身份证号码
     *
     * @author
     * @return
     */
    public static String getRandomID() {
        String id = "420222199204179999";
        // 随机生成省、自治区、直辖市代码 1-2
        String provinces[] = { "11", "12", "13", "14", "15", "21", "22", "23",
                "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
                "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
                "63", "64", "65", "71", "81", "82" };
        String province = randomOne(provinces);
        // 随机生成地级市、盟、自治州代码 3-4
        String city = randomCityCode(18);
        // 随机生成县、县级市、区代码 5-6
        String county = randomCityCode(28);
        // 随机生成出生年月 7-14
        String birth = randomBirth(20, 50);
        // 随机生成顺序号 15-17(随机性别)
        String no = new Random().nextInt(10) + ""
                + new Random().nextInt(10) + ""
                + new Random().nextInt(10) + "";

        String cardId = province + city + county + birth + no;

        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(cardId.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];

        // 拼接身份证号码
        id = cardId + strVerifyCode;
        return id;
    }

    /**
     * 从String[] 数组中随机取出其中一个String字符串
     *
     * @author
     * @param s
     * @return
     */
    public static String randomOne(String s[]) {
        return s[new Random().nextInt(s.length - 1)];
    }

    /**
     * 随机生成两位数的字符串（01-max）,不足两位的前面补0
     *
     * @author
     * @param max
     * @return
     */
    public static String randomCityCode(int max) {
        int i = new Random().nextInt(max) + 1;
        return i > 9 ? i + "" : "0" + i;
    }

    /**
     * 随机生成minAge到maxAge年龄段的人的生日日期
     *
     * @author
     * @param minAge
     * @param maxAge
     * @return
     */
    public static String randomBirth(int minAge, int maxAge) {
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());// 设置当前日期
        // 随机设置日期为前maxAge年到前minAge年的任意一天
        int randomDay = 365 * minAge
                + new Random().nextInt(365 * (maxAge - minAge));
        date.set(Calendar.DATE, date.get(Calendar.DATE) - randomDay);
        return DateFormatUtils.getDate(date.getTime());
    }


}
