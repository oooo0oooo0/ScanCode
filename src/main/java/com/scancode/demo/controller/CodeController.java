package com.scancode.demo.controller;

import com.scancode.demo.entity.QRCode;
import com.scancode.demo.mapper.QRCodeMapper;
import com.scancode.demo.utils.QrCodeUtils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/code")
public class CodeController {
    @Autowired
    private QRCodeMapper qrCodeMapper;

    @RequestMapping(value = "/getCode")
    public String code() {
        try {
            String code = UUID.randomUUID().toString();
            QRCode newCode = new QRCode();
            newCode.setCode(code);
            newCode.setCreateTime(new Date());
            qrCodeMapper.insertQrcode(newCode);

            BufferedImage codeImg = QrCodeUtils.createImage("http://010-1024.com/checkCode/" + code, null, false);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(codeImg, "JPG", outputStream);
            String encode = Base64.encode(outputStream.toByteArray());
            return encode;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //todo 接受参数未解决
    @RequestMapping("/checkCode")
    public String checkCode(String code) {
        return code;
    }
}
