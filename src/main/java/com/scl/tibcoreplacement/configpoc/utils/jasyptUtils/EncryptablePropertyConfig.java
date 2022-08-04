package com.scl.tibcoreplacement.configpoc.utils.jasyptUtils;

import com.scl.tibcoreplacement.configpoc.utils.rsa.GenerateKeyPairUtil;
import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("desencrypt")
class EncryptablePropertyConfig  implements StringEncryptor {

    private static final Logger logger = LoggerFactory.getLogger(EncryptablePropertyConfig.class);
  @Autowired
  GenerateKeyPairUtil keyPairUtil;

    @Override
    public String encrypt(String message) {



            try {

                logger.info("加密前密码："+message);
                message = keyPairUtil.encrypt(message);
                logger.info("加密后密码："+message);
                logger.info("配置信息加密成功!");
            } catch (Exception e) {

                logger.error("配置信息加密失败!");
            }

        return message;
    }

    @Override
    public String decrypt(String encryptedMessage) {



            try {

                logger.info("解密前密码："+encryptedMessage);
                encryptedMessage = keyPairUtil.decrypt(encryptedMessage);
                logger.info("解密后密码："+encryptedMessage);
                logger.info("配置信息解密成功!");
            } catch (Exception e) {

                logger.error("配置信息解密失败!");
            }

        return encryptedMessage;
    }

    }


