package org.goodfood2.utils;

import java.util.Collections;
import javax.json.Json;
import javax.json.JsonObject;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import org.eclipse.microprofile.jwt.Claims;
import java.util.Arrays;
import java.util.HashSet;
public class TokenUtils {

    public static String generateTokenSmallRye(Long duration, String email, int id, String role) throws Exception {
        String token =
            Jwt.issuer("https://localhost:8080/issuer") 
                .upn(email) 
                .groups(new HashSet<>(Arrays.asList(role))) 
                .claim("duration", duration) 
                .claim("email", email) 
                .claim("id", id) 
                .claim("role", role) 
            .sign();
        return token;
    }

    public static String generateToken(Long duration, String email, int id, String role) throws Exception {
        String privateKeyLocation = "/META-INF/resources/privateKey.pem";
        PrivateKey privateKey = readPrivateKey(privateKeyLocation);
        JwtClaimsBuilder claimsBuilder = Jwt.claims();
        long currentTimeInSecs = currentTimeInSecs();
        claimsBuilder.claim("email",email);
        claimsBuilder.claim("id",id);
        claimsBuilder.claim("role", role);
        claimsBuilder.issuedAt(currentTimeInSecs);
        claimsBuilder.expiresAt(currentTimeInSecs + duration);
        return claimsBuilder.jws().sign(privateKey);
    }

    public static PrivateKey readPrivateKey(final String pemResName) throws Exception {
        try (InputStream contentIS = TokenUtils.class.getResourceAsStream(pemResName)) {
            byte[] tmp = new byte[4096];
            int length = contentIS.read(tmp);
            return decodePrivateKey(new String(tmp, 0, length, "UTF-8"));
        }
    }

    public static PrivateKey decodePrivateKey(final String pemEncoded) throws Exception {
        byte[] encodedBytes = toEncodedBytes(pemEncoded);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);
    }

    public static byte[] toEncodedBytes(final String pemEncoded) {
        final String normalizedPem = removeBeginEnd(pemEncoded);
        return Base64.getDecoder().decode(normalizedPem);
    }

    public static String removeBeginEnd(String pem) {
        pem = pem.replaceAll("-----BEGIN (.*)-----", "");
        pem = pem.replaceAll("-----END (.*)----", "");
        pem = pem.replaceAll("\r\n", "");
        pem = pem.replaceAll("\n", "");
        return pem.trim();
    }

    public static int currentTimeInSecs() {
        long currentTimeMS = System.currentTimeMillis();
        return (int) (currentTimeMS / 1000);
    }
    

}
