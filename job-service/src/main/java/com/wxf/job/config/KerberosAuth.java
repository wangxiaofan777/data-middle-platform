package com.wxf.job.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName KerberosAuth
 * @Description TODO
 * @Author baochengjie
 * @Date 2023/5/15 16:35
 * @Version 1.0
 */
@Slf4j
@Data
@Component
public class KerberosAuth {

    @Value("${spring.hadoop.kerberos.krb5:}")
    private String krb5;
    @Value("${spring.hadoop.kerberos.keytab.user}")
    private String kerberosUser;
    @Value("${spring.hadoop.kerberos.keytab.path}")
    private String keytabPath;

}
