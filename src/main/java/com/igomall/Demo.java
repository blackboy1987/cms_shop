package com.igomall;

import com.igomall.entity.Product;
import com.igomall.entity.Sku;
import com.igomall.util.WebUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {

    public static void main2(String[] args) {
        Map<String,Object> headers = new HashMap<>();
        headers.put("Cookie"," UM_distinctid=1765f3a8c6d3d-04d760afc16ac3-5a301e42-384000-1765f3a8c6e6cd; addinfo=%7B%22chkadmin%22%3A0%2C%22chkarticle%22%3A0%2C%22levelname%22%3A%22%5Cu8bc4%5Cu8bba%5Cu8005%22%2C%22userid%22%3A%2241859%22%2C%22useralias%22%3A%22jhc188%22%7D; __gads=ID=c54ae257ef306856-2299875f32c50048:T=1607915497:RT=1607915497:S=ALNI_Ma_3l6-3LJt6PcRbSRs3r8S_w77_A; bdshare_ty=0x18; username=jhc188; token=e61a988e4e7a8532458c90a3510bd7842a8bbfc869f09a22fb9bdc1b8e15831c1609570814; logintoken=9b61fe2581f1605ec5d55a6d17466536; CNZZDATA1275394954=1726529169-1607914629-%7C1609129862; timezone=8; Hm_lvt_8240cbeafaf2badb36eccc2bb9590a10=1608785299,1608956413,1608971572,1609130313; PHPSESSID=stve5f7dv1ngqk1c57hpijsrh4; DL_referrer=https%3A//www.suibianlu.com/19304.html; Hm_lpvt_8240cbeafaf2badb36eccc2bb9590a10=1609131268");
        String result = WebUtils.get("https://www.suibianlu.com/download/19304.html",null,headers);
        Document document = Jsoup.parse(result);
        Element link = document.getElementsByClass("boxbody").first();
        System.out.println(link.text());

    }

    public static String parseDownloadInfo(String url) {
        String info = "";
        Map<String,Object> headers = new HashMap<>();
        headers.put("Cookie","UM_distinctid=1765f3a8c6d3d-04d760afc16ac3-5a301e42-384000-1765f3a8c6e6cd; addinfo=%7B%22chkadmin%22%3A0%2C%22chkarticle%22%3A0%2C%22levelname%22%3A%22%5Cu8bc4%5Cu8bba%5Cu8005%22%2C%22userid%22%3A%2241859%22%2C%22useralias%22%3A%22jhc188%22%7D; __gads=ID=c54ae257ef306856-2299875f32c50048:T=1607915497:RT=1607915497:S=ALNI_Ma_3l6-3LJt6PcRbSRs3r8S_w77_A; bdshare_ty=0x18; username=jhc188; token=e61a988e4e7a8532458c90a3510bd7842a8bbfc869f09a22fb9bdc1b8e15831c1609570814; logintoken=9b61fe2581f1605ec5d55a6d17466536; CNZZDATA1275394954=1726529169-1607914629-%7C1609213766; Hm_lvt_8240cbeafaf2badb36eccc2bb9590a10=1608956413,1608971572,1609130313,1609216317; timezone=8; PHPSESSID=oo3i32ki8gdhdfpirc85vqjhq2; DL_referrer=https%3A//www.suibianlu.com/3531.html; Hm_lpvt_8240cbeafaf2badb36eccc2bb9590a10=1609217450");
        String result = WebUtils.get(url,null,headers);
        Document document = Jsoup.parse(result);
        Elements elements = document.getElementsByTag("a");
        for (Element a:elements) {
            if(StringUtils.equalsIgnoreCase(a.text(),"点击我下载")){
                info = a.attr("href");
                break;
            }
        }
        if(StringUtils.isBlank(info)){
            Element link = document.getElementsByClass("boxbody").first();
            info = link.text();
        }
        return info;
    }

    public static String parseDownloadInfo1(String url) {
        String info = "";
        Map<String,Object> headers = new HashMap<>();
        headers.put("Cookie","UM_distinctid=1765f3a8c6d3d-04d760afc16ac3-5a301e42-384000-1765f3a8c6e6cd; addinfo=%7B%22chkadmin%22%3A0%2C%22chkarticle%22%3A0%2C%22levelname%22%3A%22%5Cu8bc4%5Cu8bba%5Cu8005%22%2C%22userid%22%3A%2241859%22%2C%22useralias%22%3A%22jhc188%22%7D; __gads=ID=c54ae257ef306856-2299875f32c50048:T=1607915497:RT=1607915497:S=ALNI_Ma_3l6-3LJt6PcRbSRs3r8S_w77_A; bdshare_ty=0x18; username=jhc188; token=e61a988e4e7a8532458c90a3510bd7842a8bbfc869f09a22fb9bdc1b8e15831c1609570814; logintoken=9b61fe2581f1605ec5d55a6d17466536; CNZZDATA1275394954=1726529169-1607914629-%7C1609213766; Hm_lvt_8240cbeafaf2badb36eccc2bb9590a10=1608956413,1608971572,1609130313,1609216317; timezone=8; PHPSESSID=oo3i32ki8gdhdfpirc85vqjhq2; DL_referrer=https%3A//www.suibianlu.com/3531.html; Hm_lpvt_8240cbeafaf2badb36eccc2bb9590a10=1609217450");
        String result = WebUtils.get(url,null,headers);
        Document document = Jsoup.parse(result);
        Elements elements = document.getElementsByTag("a");

        // 百度云的下载地址
        for (Element a:elements) {
            info = a.attr("href");
            if(StringUtils.startsWith(info,"https://pan.baidu.com/")||StringUtils.startsWith(info,"http://pan.baidu.com/")){
                break;
            }
        }
        // 百度云的验证码
        String text = document.text();
        System.out.println(text);
        String[] texts = text.split("提取码：");
        if(texts.length!=2){
            texts = text.split("提取码: ");
        }
        if(texts.length==2){
            String code = texts[1].substring(0,4);
            info = info+"。提取码："+code;
        }
        if(StringUtils.isBlank(info)){
            for (Element a:elements) {
                info = a.text();
                if(StringUtils.startsWith(info,"点击我下载")){
                    break;
                }
            }
        }
        // 解压密码
        Elements pElements = document.getElementsByTag("p");
        for (Element element:pElements) {
            String text1 = element.text();
            if(StringUtils.startsWith(text1,"解压密码：")){
                info = info+"。解压密码："+text1;
                break;
            }
        }
        return info;
    }


    public static void main(String[] args) throws IOException {
        String url="https://www.suibianlu.com/other_3/";
        List<Product> products = parsePage(url);
        System.out.println(products);
    }

    public static List<Product> parsePage(String url) throws IOException {
        final Map<String,Product> productMap = new HashMap<>();
        Document root = Jsoup.parse(new URL(url), 2000);
        Elements elements = root.getElementsByClass("list-down").first().getElementsByTag("li");
        for (Element element:elements) {
            Product product = new Product();
            Set<Sku> skus = new HashSet<>();
            Sku sku = new Sku();
            // 缩略图
            Element imgTagA = element.getElementsByTag("a").first();
            Element imgTag = imgTagA.getElementsByTag("img").first();
            product.setAttributeValue0(imgTagA.attr("href"));
            product.setAttributeValue1(imgTag.attr("src"));
            // 标题
            Element titleTag = element.getElementsByTag("h2").first();
            product.setName(titleTag.text());
            sku.setIsDefault(true);
            // productCategoryId:9951
            product.setType(Product.Type.VIRTUAL);
            product.setCaption(product.getName());
            sku.setPrice(BigDecimal.valueOf(0.99));
            sku.setCost(BigDecimal.valueOf(0.99));
            sku.setMarketPrice(BigDecimal.valueOf(0.99));
            sku.setMaxCommission(BigDecimal.ZERO);
            sku.setStock(10000);
            skus.add(sku);
            product.setSkus(skus);
            product.setIsMarketable(true);
            product.setIsList(true);
            product.setIsTop(true);
            product.setIsDelivery(false);
            product.setMemo(product.getName());
            product.setKeyword(product.getName());
            parseIntroduction(product);


            productMap.put(product.getName(),product);
        }

        return productMap.keySet().stream().map(key -> productMap.get(key)).collect(Collectors.toList());
    }

    private static String parseIntroduction(Product product) throws IOException {
        String url = product.getAttributeValue0();
        Document root = Jsoup.parse(new URL(url), 2000);
        Element element = root.getElementsByClass("info-con").first();
        element.removeClass("dlp");
        product.setIntroduction(element.html());
        Element dlp = element.getElementsByClass("dlp").first();
        if(dlp!=null){
            Element dlpDownload = dlp.getElementsByClass("dlp-btn").first();
            String downloadUrl = dlpDownload.attr("href");
            String downloadInfo = parseDownloadInfo1(downloadUrl);
            System.out.println("downloadInfo:"+url+":"+downloadInfo);
            return downloadInfo;
        }
        return null;
    }
}
