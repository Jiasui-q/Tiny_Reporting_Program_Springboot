package utils;

import model.Person;

import java.util.*;

public class RandomPersonGenerator {
    private static Random random = new Random();

    // ～～～～～～～～～～～～～～～～～公有方法～～～～～～～～～～～～～～～～～～～～
    /**
     * 生成单个person以及它的随机信息
     * @return Person
     */
    public Person createSingleRandomPerson(){
        Person newPerson = new Person();
        newPerson.setId(setRandomId());
        newPerson.setName(setRandomName());
        newPerson.setSex(setRandomSex());
        int newAge = setRandomAge();
        newPerson.setAge(newAge);
        newPerson.setDesc(setRandomDesc());
        newPerson.setBizDate(setRandomBizDate(newAge));
        newPerson.setNation(setRandomNation());
        newPerson.setPhone(setRandomPhone());
        newPerson.setEmail(setRandomEmail());
        newPerson.setHobbies(setRandomHobbies());
        return newPerson;
    }

    /**
     * 生成一组随机person
     * @param personNum 指定生成人数
     * @return List<Person>
     */
    public List<Person> createListRandomPerson(int personNum){
        List<Person> listRandomPerson = new ArrayList<>();
        for(int i = 0; i < personNum; i++){
            listRandomPerson.add(createSingleRandomPerson());
        }
        return listRandomPerson;
    }

    // ～～～～～～～～～～～～～～～～～私有方法～～～～～～～～～～～～～～～～～～～～
    /**
     * 随机生成10个字符的Id
     * @return String
     */
    private String setRandomId(){
        return getRandomString(10, true);
    }

    /**
     * 随机生成姓名，可以重复2-4位
     * @return String
     */
    private String setRandomName(){
        StringBuffer sb = new StringBuffer();
        String surName[] = {
                "赵","钱","孙","李","周","吴","郑","王","冯","陈","楮","卫","蒋","沈","韩","杨",
                "朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜",
                "戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎",
                "鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐",
                "费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常",
                "乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄",
                "和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧",
                "计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁",
                "杜","阮","蓝","闽","席","季","麻","强","贾","路","娄","危","江","童","颜","郭",
                "梅","盛","林","刁","锺","徐","丘","骆","高","夏","蔡","田","樊","胡","凌","霍",
                "虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗",
                "丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚",
                "程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠","甄","麹","家","封",
                "芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓",
                "牧","隗","山","谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫",
                "宁","仇","栾","暴","甘","斜","厉","戎","祖","武","符","刘","景","詹","束","龙",
                "叶","幸","司","韶","郜","黎","蓟","薄","印","宿","白","怀","蒲","邰","从","鄂",
                "索","咸","籍","赖","卓","蔺","屠","蒙","池","乔","阴","郁","胥","能","苍","双",
                "闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍",
                "郤","璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","郏","浦","尚","农",
                "温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习","宦","艾","鱼","容",
                "向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘",
                "匡","国","文","寇","广","禄","阙","东","欧","殳","沃","利","蔚","越","夔","隆",
                "师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空",
                "曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红",
                "游","竺","权","逑","盖","益","桓","公","晋","楚","阎","法","汝","鄢","涂","钦",
                "岳","帅","缑","亢","况","后","有","琴","商","牟","佘","佴","伯","赏","墨","哈",
                "谯","笪","年","爱","阳","佟"};
        int len = random.nextInt(3)+1;
        for (int i = 0; i < len; i++){
            int delta = 0x9fa5 - 0x4e00 + 1;
            sb.append((char)(0x4e00 + random.nextInt(delta)));
        }
        return surName[random.nextInt(surName.length)]+sb.toString();
    }

    /**
     * 随机生成性别，男/女
     * @return String
     */
    private String setRandomSex(){
        int s_num = random.nextInt(2);
        if (s_num==0){
            return "男";
        }else{
            return "女";
        }
    }

    /**
     * 随机生成年龄，0-100之间
     * @return int
     */
    private int setRandomAge(){
        return random.nextInt(101);
    }

    /**
     * 随机生成20个字符的desc
     * @return String
     */
    private String setRandomDesc(){
        return getRandomString(20, true);
    }

    /**
     * 根据年龄随机生成生日
     * @return String
     */
    private String setRandomBizDate(int randomAge) {
        int month = random.nextInt(12)+1;
        int day = random.nextInt(30)+1;
        int year = 2021-randomAge;
        if ((month>5) || (month==5 && day>=7)){
            year -= 1;
        }
        String date = String.valueOf(year);
        if(month<10){
            date+="0";
        }
        date += String.valueOf(month);
        if(day<10){
            date+="0";
        }
        date += String.valueOf(day);
        return date;
    }

    /**
     * 随机生成民族
     * @return String
     */
    private String setRandomNation() {
        String[] allNations = new String[]{"汉族", "蒙古族", "回族", "藏族", "苗族", "维吾尔族", "彝族",
                "壮族", "布依族", "白族", "朝鲜族", "侗族", "哈尼族", "哈萨克族", "满族", "土家族", "瑶族",
                "达斡尔族", "东乡族", "高山族", "景颇族", "柯尔克孜族", "拉祜族", "纳西族", "畲族", "傣族黎族",
                "傈僳族", "仫佬族", "羌族", "水族", "土族", "佤族", "阿昌族", "布朗族", "毛南族", "普米族",
                "撒拉族", "塔吉克族", "锡伯族", "仡佬族", "保安族", "德昂族", "俄罗斯族", "鄂温克族", "京族",
                "怒族", "乌孜别克族", "裕固族", "独龙族", "鄂伦春族", "赫哲族", "基诺族", "珞巴族", "门巴族", "塔塔尔族"};
        return allNations[random.nextInt(allNations.length)];
    }

    /**
     * 随机生成手机号，以1开头的11位数字
     * @return String
     */
    private String setRandomPhone() {
        return "1" + getRandomString(10, false);
    }

    /**
     * 随机生成10位的qq邮箱号
     * @return String
     */
    private String setRandomEmail() {
        return getRandomString(10, false)+"@qq.com";
    }

    /**
     * 随机生成一组兴趣爱好
     * @return Set<String>
     */
    private Set<String> setRandomHobbies() {
        Set<String> hobbies = new HashSet<>();
        String[] allHobbies = new String[]{"电影","旅游","唱歌","烘焙","绘画","烹饪","摄影","看书","麻将"};
        for(int i = 0; i < 3; i ++){
            String choice = allHobbies[random.nextInt(allHobbies.length)];
            if(!hobbies.contains(choice)){
                hobbies.add(choice);
            }
        }
        return hobbies;
    }

    /**
     * 根据特定length长度以及是否包含字母生成随机字符串
     * @param length：指定字符串的长度
     * @param hasChar：含字符为true，只有数字为false
     * @return String
     */
    private String getRandomString(int length, boolean hasChar) {
        String base = "";
        if (hasChar) {
            base = "abcdefghijklmnopqrstuvwxyz0123456789";
        }else{
            base = "0123456789";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

