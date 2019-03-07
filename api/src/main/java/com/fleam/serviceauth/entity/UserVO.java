package com.fleam.serviceauth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzd
 * @since 2018-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    //{"oldPassword":"123","newPassword":"123","rePassword":"123","id":1}
    private Integer id;
    private String oldPassword;
    private String newPassword;
    private String rePassword;


}
