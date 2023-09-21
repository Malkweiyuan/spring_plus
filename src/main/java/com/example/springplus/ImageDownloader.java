package com.example.springplus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
/**
 * @Author wei
 * @Date 2023/9/13 9:42
 * @Version 1.0
 */
public class ImageDownloader {
    public static void main(String[] args) {
        String url = "https://img.alicdn.com/imgextra/i3/2215627909864/O1CN01gwy1Hy2MjleUnymld_!!2215627909864.png";

//
//        try {
//            Document document = Jsoup.connect(url).get();
//            Elements imageElements = document.select("img");
//
//            for (Element element : imageElements) {
//                String imageUrl = element.attr("src");
//                downloadImage(imageUrl, "path/to/save");
//            }
//
//            System.out.println("图片下载完成！");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
            String savePath = "path/to/save/image.jpg";

            try {
                downloadImage(url, savePath);
                System.out.println("图片下载完成！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    private static void downloadImage(String imageUrl, String savePath) throws IOException {
        URL url = new URL(imageUrl);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(savePath);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }

        fileOutputStream.close();
        bufferedInputStream.close();
        inputStream.close();
    }
}
