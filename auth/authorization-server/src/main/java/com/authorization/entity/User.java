package com.authorization.entity;

import com.springcloud.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午12:43.
 */

@Data
@EqualsAndHashCode(callSuper = false )
@NoArgsConstructor
public class User extends BasePo {
    private String name;
    private String mobile;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
}
