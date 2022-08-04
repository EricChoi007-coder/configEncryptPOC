package com.scl.tibcoreplacement.configpoc.controller;


import com.scl.tibcoreplacement.configpoc.domain.EncryptDto;
import com.scl.tibcoreplacement.configpoc.utils.JsonData;
import com.scl.tibcoreplacement.configpoc.utils.rsa.GenerateKeyPairUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rsa")
@PropertySource({"classpath:application.properties"})
public class RsaController {

    @Autowired
    GenerateKeyPairUtil keyPairUtil;

    @Value("${test.password}")
    private String testPassword ;

    @PostMapping("generatekeys")
    //@RequestBody is a must for JSON Format
    public JsonData generateKeys() {
        Map<String, String> keyPairMap = keyPairUtil.initKeyPair();
        String publicKey = keyPairMap.get("publicKey");
        String privateKey = keyPairMap.get("privateKey");
        System.out.println("public_key：");
        System.out.println(publicKey);
        System.out.println();

        System.out.println("private_key：");
        System.out.println(privateKey);
        System.out.println();
       return JsonData.buildSuccess("success");
    }

    @PostMapping("getEncryptValue")
    public JsonData getEncryptValue(@RequestBody EncryptDto encryptDto){
        return JsonData.buildSuccess(keyPairUtil.encrypt(encryptDto.getEncryptValue()));
    }

    @GetMapping("decryptValue")
    public JsonData getEncryptValue(){
        return JsonData.buildSuccess(testPassword);
    }

}
