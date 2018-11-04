package com.lzit.sprintboot2test.test;

import com.lzit.sprintboot2test.configure.InterceptorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * @author:wenfan
 * @description:
 * @data: 2018/10/31
 */
@RestController
public class UploadFileController {
    private static final Logger log = LoggerFactory.getLogger(UploadFileController.class);

    @RequestMapping("/index")
    public String demo3(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        session.setAttribute("userName",1);
        log.info("userName已经写入session");
        return "index";//地址指向demo3.html
    }

    //指定路径
    @Value("${file.path}")
    private String filepath;

    @PostMapping("/form")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte buffer[]=file.getBytes();
            File targetFile=new File(filepath+file.getOriginalFilename());
            FileOutputStream outputStream=new FileOutputStream(targetFile);
            outputStream.write(buffer);
            outputStream.close();
            return "上传成功";

        } else {
            return "上传失败，因为文件是空的.";
        }

    }

    @GetMapping("api/api")
    public String register(HttpServletRequest request,HttpServletResponse response){

        return "success";
    }
}
