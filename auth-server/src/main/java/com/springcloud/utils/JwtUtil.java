package com.springcloud.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName JwtUtil
 * @Description: 实现Jwt
 * @Author zhouyang
 * @Date 2020/9/16 下午10:55.
 */

public class JwtUtil {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecretdemo";
    private static final String ISS = "echisan";

    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;
    // 添加角色的key
    private static final String ROLE_CLAIMS = "rol";

    /**
     * 解析token
     * @return
     */
//    public static Claims parseToken(String jsonWebToken) {
//        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security)).parseClaimsJws(jsonWebToken).getBody();
//        return claims;
//    }
    public static String parseToken(String token, String salt) {
        String subject = null;
        try {
            /*Claims claims = Jwts.parser()
//                    .setSigningKey(salt) // 不使用公钥私钥
                    .setSigningKey(publicKey)
                    .parseClaimsJws(token).getBody();*/
            subject = getTokenBody(token).getSubject();
        } catch (Exception e) {
        }
        return subject;
    }

    /**
     * 新建token
     * @return
     */
//    public static String createToken(String audience, String issuer) {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//
//        // 生成签名密钥
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        // 添加构成JWT的参数
//        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").setIssuer(issuer).setAudience(audience)
//                .signWith(signatureAlgorithm, signingKey);
//
//        // 添加Token签发时间
//        builder.setIssuedAt(now);
//        // 添加Token过期时间
//        if (expiration >= 0) {
//            long expMillis = nowMillis + expiration;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp).setNotBefore(now);
//        }
//
//        // 生成JWT
//        return builder.compact();
//    }

    // 创建token
    public static String createToken(String username, List role, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        HashMap<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, role);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                // 这里要早set一点，放到后面会覆盖别的字段
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    /**
     * 刷新令牌
     *
     * @param
     * @return
     */
//    public static String refreshToken(Claims claims) {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//
//        // 生成签名密钥
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        // 添加构成JWT的参数
//        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
//                .setIssuer((String) claims.get("iss")).setAudience((String) claims.get("aud"))
//                .signWith(signatureAlgorithm, signingKey);
//
//        // 添加Token签发时间
//        builder.setIssuedAt(now);
//        // 添加Token过期时间
//        if (expiration >= 0) {
//            long expMillis = nowMillis + expiration;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp).setNotBefore(now);
//        }
//
//        // 生成Token
//        return builder.compact();
//    }

    // 从token中获取用户名
    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }
    // 获取用户角色
    public static String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }
    // 是否已过期
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
