package com.zy.utils;

import com.zy.accessory.ConfigBean;
import com.zy.service.impl.RedisService;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Title: ToolUtil.java Description
 *
 * @author
 * @version 1.0
 * @date 2015年6月17日
 */

public class ToolUtil {

    private static Logger log = Logger.getLogger(ToolUtil.class);

    @Autowired
    private static ConfigBean configBean;

    /**
     * 隐藏手机号中间4位
     */
    public static String hideTel(String str) {
        StringBuilder result = new StringBuilder();
        result.append(str.substring(0, 3)).append("****").append(str.substring(7, str.length()));
        return result.toString();
    }

    public static String replace(String str, int start, int end) {
        char c = '*';
        if (str == null) {
            return null;
        }
        StringBuffer strbf = new StringBuffer(str);
        for (int i = start; i < str.length() - end; i++) {
            strbf.setCharAt(i, c);
        }
        return strbf.toString();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param firstdate  第一个时间
     * @param seconddate 第二个时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date firstdate, Date seconddate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        seconddate = sdf.parse(sdf.format(seconddate));
        firstdate = sdf.parse(sdf.format(firstdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(seconddate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(firstdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String getHideIdCard(String idCard) {
        if (idCard == null || idCard.equals("")) {
            return "";
        } else {
            return idCard.substring(0, 6) + "**********" + idCard.substring(16);
        }
    }

    /**
     * 随机数
     * @param instance
     * @return
     */
    public static String generatorId(RedisService instance) {
        final String order_id_prefix = "JJD_order";
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String tm = df.format(dt);
        long temp = instance.increase(order_id_prefix);
        int random = (int) (Math.random() * 9 + 1);
        int tail = (int) (temp % 1000);

        int tail_000 = tail / 100;
        int tail_00 = (tail % 100) / 10;
        int tail_0 = tail % 10;
        String str = "" + tail_000 + random + tail_00 + tail_0;
        return tm + str;
    }

    /**
     * 图片直接上传不用下载（ 单张图片）
     *
     * @param imgBase64 图片base64
     * @param instance  redis
     * @return key
     * @throws Exception
     */
    public static String uploadAppPicture(String imgBase64, RedisService instance) throws Exception {
        String key = ToolUtil.generatorId(instance);
        byte[] data = convertImageBase64(imgBase64);
        QiniuApi.uploadFile(key, data);
        return key;
    }

    /**
     * 把图像数据转换为byte数组 【信用中心】
     */
    public static byte[] convertImageBase64(String imgStr) throws Exception {
        if (imgStr == null) // 图像数据为空
            return null;
        // 去掉 data:image/jpeg;base64,
        int nIndex = imgStr.indexOf(",");
        imgStr = imgStr.substring(nIndex + 1);
        Base64 decoder = new Base64();
        byte[] b = decoder.decode(imgStr);// Base64解码 decodeBuffer(imgStr)
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {// 调整异常数据
                b[i] += 256;
            }
        }
        return b;
    }

    /**
     * 生成二维码（BASE64字符串）
     *
     * @param content
     * @param width
     * @param height
     * @param imageFormat
     * @return
     * @throws Exception
     */
//    public static String createQrCode(String content, int width, int height, String imageFormat) throws Exception {
//        Hashtable hints = new Hashtable();
//        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//        BitMatrix bitMatrix = null;
//        try {
//            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
//        ByteArrayOutputStream os = new ByteArrayOutputStream();//新建流。
//        ImageIO.write(image, imageFormat, os);//利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
//        byte b[] = os.toByteArray();//从流中获取数据数组。
//        String base64Str = new BASE64Encoder().encode(b);
//        return "data:image/png;base64," + base64Str;
//    }


}