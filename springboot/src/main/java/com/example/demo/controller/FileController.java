package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    String port;

    public static final String IP = "http://localhost";

    @PostMapping("/upload")
    public Result<?> upLoad(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String flag = IdUtil.fastSimpleUUID();
        String filePath = System.getProperty("user.dir") + "/springboot/src/main/resources/files/" + flag + "_" + originalFilename;
        File bytes = FileUtil.writeBytes(file.getBytes(), filePath);
        System.out.println(bytes);
        return Result.success(IP + ":" + port + "/files/" + flag);
    }

    @GetMapping("{flag}")
    public Result<?> downLoad(HttpServletResponse response, @PathVariable String flag) {
        String basePath = System.getProperty("user.dir") + "/springboot/src/main/resources/files/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        try {
            if (StrUtil.isNotBlank(fileName)) {
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("applicatiion/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件下载失败");
        }
            return Result.success();
    }
}
