package com.scl.tibcoreplacement.configpoc.utils.x509CerReader;

import java.io.FileInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class X509CertificationReader {
    public static String readCerFromFile(String filePath) throws Throwable {
        //  String keyStorePath = "E:/mpay_public_key/client_02.cer";
            String keyStorePath = filePath;
           CertificateFactory cf = CertificateFactory.getInstance("X.509");
           X509Certificate cert = (X509Certificate) cf.generateCertificate(new FileInputStream(keyStorePath));
          PublicKey publicKey = cert.getPublicKey();

          String publicKeyString =new String( Base64.getEncoder().encode(publicKey.getEncoded()));
         return publicKeyString;

    }
}
