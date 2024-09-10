package com.teambuilding.utils;

import cn.hutool.json.JSON;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * jwt工具类
 */
public class JwtUtils {

    // 私钥
    public final static    String privatejson  = "{\"kty\":\"RSA\",\"n\":\"5RJECddtOc2zxUsW3DCSwPCYigNfzX-23akdkfy_CkoDVJJOkCuWBAqqlG1HUHU_Q8Uu-05-5OtofgEP5IOhxy-t0FSduJYej_U3yKFNgkATl9aPeDiPF0so7xaM3C9C-E7b1s5WCKZJmIWaXWqxuY7qVMvt3cdprI-zCRACzwzy9f-9ZJD5jzUM2stnHUbTPdN3YAPcGOS4LywQXq5-JpSprauZ6puZM3Ldrz8QBgynC4mw55jzROJ8XWRwVsXE3Moobbyk7ePHRKVgVoE-VFodI_q4g5jz8yjybX0pB9jhJY8KduxW7HOmWbdki45ZzOmJwrHCf9-rk6soTwqECQ\",\"e\":\"AQAB\",\"d\":\"B7e10x8O7wOfKuZ8vq5kQ1vXx86VS7ch0hYAiQqa5R3ZPuAvBWxygXBajuWfoXZRy1a5Xn4miE_mFViz0F8e9DcHBB3VsoJcRT1dw8Srd9fw0QzJiKNfLsm5d1SrKj_tYbBGd9Y7z87Ka_kUWlFd64KFIpY8TVyKkuXEgmmnrpIQxgYkmCwc6cebNf8tk_dvSnFHqIb5G27Pd9Nafz77QJdtHvAeGcwW5fFkl2XDmVu8RnPIHU2Yg3MSw1hRG4-5JwLkaNVKFtw86po4z4OuZm8n1w_nsXgmfXjzmZwvN6PajdBK7YIWT2f--9_SpmzOuuOX42XmIQOV11C8qVKsgQ\",\"p\":\"_6y-jO7U1uHAvg2QrHWeNjXf92lJDlUISVqBx3XOyppqiFtyjsZUE8o2_Qca9RMNeYXno3QrxYyBs1Eqeq4o5Efpbi9aOi7J-VIathSHBvl2KebRL2vzry_G57oOWfqiAGnEHdqiE3pZArnoNZOeyfKT9HTXzobQ23QBaj5NFf8\",\"q\":\"5VzbyMVrxxiGR6jHTNdPMTgd7EaoEETMVBce4pRL7vWX2DxIOjlb2KdYVly8zSNOSvMTYM2puLq-rHo_AjHKtSJSavifS6gbOL-gh7zRpXyQrAZ3l8YKX-_4LaZ46m8tWR61gUVyoeGa02hLpPf_qO54gfFatBlSp-c_is_jtfc\",\"dp\":\"XegNyOfDxvT9_RAwbhd5N8IL8-x4x8nVlFOozSDpBiM3M8QazHPt16LzFXZxoUgRL-xNywxVM2bLEJikOJEVNdtv0meUBUDAMFHGu8_IVHh1vSgo9vj4dQTgUqZUtRnIPMycGrb9xpeub8DmmB8TOGtfim8MALAlsCTojCQ73fM\",\"dq\":\"kYek0LQrGY2_DdLSejgXQGSZ3-RJGOF-QFDXQO7Va06bRRGixobEdyhfTZTUGtkvATFQd1inOtYKy8dZGVxcgSfA4azU7h1BAHXeNqIg536tEOmdkkiPJqZNczGwgRd_z49DnT1iacKLCV6guJC-wAJnphNs-N8kafK5h6s2kas\",\"qi\":\"LZ6yHGQMUBqLEUWzqgO4imZVtDIMkPJUUgKoe3YGlLW99dknPmpfA3Z39NRpj3EAHchOIKByyAmlM3LUDUi8W2OEX6TmmS_Q4y02_m-O1eDWCMcyQVNMmtUfqqJl7gWzxbIyvKtoiQVLWBhS0VnUUsgEHzMe75bZYMNwVyG9MDA\"}";
    // 公钥
    public final static    String publicjson  = "{\"kty\":\"RSA\",\"n\":\"5RJECddtOc2zxUsW3DCSwPCYigNfzX-23akdkfy_CkoDVJJOkCuWBAqqlG1HUHU_Q8Uu-05-5OtofgEP5IOhxy-t0FSduJYej_U3yKFNgkATl9aPeDiPF0so7xaM3C9C-E7b1s5WCKZJmIWaXWqxuY7qVMvt3cdprI-zCRACzwzy9f-9ZJD5jzUM2stnHUbTPdN3YAPcGOS4LywQXq5-JpSprauZ6puZM3Ldrz8QBgynC4mw55jzROJ8XWRwVsXE3Moobbyk7ePHRKVgVoE-VFodI_q4g5jz8yjybX0pB9jhJY8KduxW7HOmWbdki45ZzOmJwrHCf9-rk6soTwqECQ\",\"e\":\"AQAB\"}";

    /**
     * 生成token
     * @param userId 用户id
     * @param username 用户名字
     * @return
     */
    public static String sign(Long userId,String username)  {

        try {
            // 1、 创建jwtclaims  jwt内容载荷部分
            JwtClaims claims = new JwtClaims();
            // 是谁创建了令牌并且签署了它
            claims.setIssuer("abcd");
            // 令牌将被发送给谁
            claims.setAudience("audience");
            // 失效时间长 （从现在开始10分钟）
            claims.setExpirationTimeMinutesInTheFuture(10000);
            // 令牌唯一标识符
            claims.setGeneratedJwtId();
            // 当令牌被发布或者创建现在
            claims.setIssuedAtToNow();
            // 再次之前令牌无效
            claims.setNotBeforeMinutesInThePast(2);
            // 主题
            claims.setSubject("subject");
            // 可以添加关于这个主题得声明属性
            claims.setClaim("userId",userId);
            claims.setClaim("username",username);

            // 2、签名
            JsonWebSignature jws = new JsonWebSignature();
            //赋值载荷
            jws.setPayload(claims.toJson());

            // 3、jwt使用私钥签署
            PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(privatejson)).getPrivateKey();
            jws.setKey(privateKey);

            // 4、设置关键 kid
            jws.setKeyIdHeaderValue("keyId");

            // 5、设置签名算法
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
            // 6、生成jwt
            String jwt = jws.getCompactSerialization();

            return jwt;
        } catch (JoseException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * 解密token
     *
     * @param token
     */
    public static void checkJwt(String token) throws JoseException {

        // 1、引入公钥
        PublicKey publicKey = new RsaJsonWebKey(JsonUtil.parseJson(publicjson)).getPublicKey();

        // 2、使用jwtcoonsumer  验证和处理jwt
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime() //过期时间
                .setAllowedClockSkewInSeconds(30) //允许在验证得时候留有一些余地 计算时钟偏差  秒
                .setRequireSubject() // 主题生命
                .setExpectedIssuer("abcd") // jwt需要知道谁发布得 用来验证发布人
                .setExpectedAudience("audience") //jwt目的是谁 用来验证观众
                .setVerificationKey(publicKey) // 用公钥验证签名  验证密钥
                .setJwsAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST, AlgorithmIdentifiers.RSA_USING_SHA256))
                .build();
        try {
            // 3、验证jwt 并将其处理为 claims
            JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
            System.out.println(jwtClaims);
        } catch (InvalidJwtException e) {
            throw new RuntimeException(e);
        }


    }


    public static void main(String[] args) throws JoseException {
        //生成公钥和私钥
//        RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
//        // 生成公钥
//        String publicjson = rsaJsonWebKey.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY);
//        // 生成私钥
//        String privatejson = rsaJsonWebKey.toJson(JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
//        System.out.println(publicjson);
//        System.out.println(privatejson);
        //{"kty":"RSA","n":"5RJECddtOc2zxUsW3DCSwPCYigNfzX-23akdkfy_CkoDVJJOkCuWBAqqlG1HUHU_Q8Uu-05-5OtofgEP5IOhxy-t0FSduJYej_U3yKFNgkATl9aPeDiPF0so7xaM3C9C-E7b1s5WCKZJmIWaXWqxuY7qVMvt3cdprI-zCRACzwzy9f-9ZJD5jzUM2stnHUbTPdN3YAPcGOS4LywQXq5-JpSprauZ6puZM3Ldrz8QBgynC4mw55jzROJ8XWRwVsXE3Moobbyk7ePHRKVgVoE-VFodI_q4g5jz8yjybX0pB9jhJY8KduxW7HOmWbdki45ZzOmJwrHCf9-rk6soTwqECQ","e":"AQAB"}
        //{"kty":"RSA","n":"5RJECddtOc2zxUsW3DCSwPCYigNfzX-23akdkfy_CkoDVJJOkCuWBAqqlG1HUHU_Q8Uu-05-5OtofgEP5IOhxy-t0FSduJYej_U3yKFNgkATl9aPeDiPF0so7xaM3C9C-E7b1s5WCKZJmIWaXWqxuY7qVMvt3cdprI-zCRACzwzy9f-9ZJD5jzUM2stnHUbTPdN3YAPcGOS4LywQXq5-JpSprauZ6puZM3Ldrz8QBgynC4mw55jzROJ8XWRwVsXE3Moobbyk7ePHRKVgVoE-VFodI_q4g5jz8yjybX0pB9jhJY8KduxW7HOmWbdki45ZzOmJwrHCf9-rk6soTwqECQ","e":"AQAB","d":"B7e10x8O7wOfKuZ8vq5kQ1vXx86VS7ch0hYAiQqa5R3ZPuAvBWxygXBajuWfoXZRy1a5Xn4miE_mFViz0F8e9DcHBB3VsoJcRT1dw8Srd9fw0QzJiKNfLsm5d1SrKj_tYbBGd9Y7z87Ka_kUWlFd64KFIpY8TVyKkuXEgmmnrpIQxgYkmCwc6cebNf8tk_dvSnFHqIb5G27Pd9Nafz77QJdtHvAeGcwW5fFkl2XDmVu8RnPIHU2Yg3MSw1hRG4-5JwLkaNVKFtw86po4z4OuZm8n1w_nsXgmfXjzmZwvN6PajdBK7YIWT2f--9_SpmzOuuOX42XmIQOV11C8qVKsgQ","p":"_6y-jO7U1uHAvg2QrHWeNjXf92lJDlUISVqBx3XOyppqiFtyjsZUE8o2_Qca9RMNeYXno3QrxYyBs1Eqeq4o5Efpbi9aOi7J-VIathSHBvl2KebRL2vzry_G57oOWfqiAGnEHdqiE3pZArnoNZOeyfKT9HTXzobQ23QBaj5NFf8","q":"5VzbyMVrxxiGR6jHTNdPMTgd7EaoEETMVBce4pRL7vWX2DxIOjlb2KdYVly8zSNOSvMTYM2puLq-rHo_AjHKtSJSavifS6gbOL-gh7zRpXyQrAZ3l8YKX-_4LaZ46m8tWR61gUVyoeGa02hLpPf_qO54gfFatBlSp-c_is_jtfc","dp":"XegNyOfDxvT9_RAwbhd5N8IL8-x4x8nVlFOozSDpBiM3M8QazHPt16LzFXZxoUgRL-xNywxVM2bLEJikOJEVNdtv0meUBUDAMFHGu8_IVHh1vSgo9vj4dQTgUqZUtRnIPMycGrb9xpeub8DmmB8TOGtfim8MALAlsCTojCQ73fM","dq":"kYek0LQrGY2_DdLSejgXQGSZ3-RJGOF-QFDXQO7Va06bRRGixobEdyhfTZTUGtkvATFQd1inOtYKy8dZGVxcgSfA4azU7h1BAHXeNqIg536tEOmdkkiPJqZNczGwgRd_z49DnT1iacKLCV6guJC-wAJnphNs-N8kafK5h6s2kas","qi":"LZ6yHGQMUBqLEUWzqgO4imZVtDIMkPJUUgKoe3YGlLW99dknPmpfA3Z39NRpj3EAHchOIKByyAmlM3LUDUi8W2OEX6TmmS_Q4y02_m-O1eDWCMcyQVNMmtUfqqJl7gWzxbIyvKtoiQVLWBhS0VnUUsgEHzMe75bZYMNwVyG9MDA"}


        String token = sign(1L, "jinken");
        System.out.println("token = " + token);
        checkJwt(token);


    }


}
