package com.wxf.user.provider;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


/**
 * 用户对象
 */
@Data
@Builder
public class UserDo implements Serializable {

    private Long id;

    private String name;
}
