package com.scancode.demo.mapper;

import com.scancode.demo.entity.QRCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface QRCodeMapper {
    QRCode selectQrcode(String code);

    void insertQrcode(QRCode code);
}
