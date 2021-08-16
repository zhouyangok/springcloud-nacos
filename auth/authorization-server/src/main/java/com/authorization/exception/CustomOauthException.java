package com.authorization.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springcloud.result.CommonResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import javax.xml.transform.Result;

/**
 * @ClassName CustomOauthException
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午1:06.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {

    private final CommonResult result;

    CustomOauthException(OAuth2Exception oAuth2Exception) {
        super(oAuth2Exception.getSummary(), oAuth2Exception);
        this.result = CommonResult.fail(AuthErrorType.valueOf(oAuth2Exception.getOAuth2ErrorCode().toUpperCase()), oAuth2Exception);
    }
}
