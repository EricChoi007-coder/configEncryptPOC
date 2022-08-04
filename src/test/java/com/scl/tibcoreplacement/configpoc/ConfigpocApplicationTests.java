package com.scl.tibcoreplacement.configpoc;

import com.scl.tibcoreplacement.configpoc.utils.rsa.GenerateKeyPairUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class ConfigpocApplicationTests {

	@Autowired
	GenerateKeyPairUtil keyPairUtil;
	@Test
	void testRsaUtils() {

		Map<String, String> keyPairMap = keyPairUtil.initKeyPair();
		String publicKey = keyPairMap.get("publicKey");
		String privateKey = keyPairMap.get("privateKey");
		System.out.println("公钥：");
		System.out.println(publicKey);
		System.out.println();

		System.out.println("私钥：");
		System.out.println(privateKey);
		System.out.println();

		String source = "Hello World";
		System.out.println("待加密字符串：" + source);
		System.out.println();

		String strEncrypt = keyPairUtil.encrypt(source);
		System.out.println("加密后的字符串：");
		System.out.println(strEncrypt);
		System.out.println();

		String strDecrypt = keyPairUtil.decrypt(strEncrypt);
		System.out.println("解密后的字符串：");
		System.out.println(strDecrypt);
	}

}
