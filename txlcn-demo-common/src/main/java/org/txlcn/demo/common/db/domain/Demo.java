package org.txlcn.demo.common.db.domain;

import com.codingapi.txlcn.common.util.id.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;

/**
 * Description:
 * Date: 2018/12/25
 *
 * @author ujued
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demo {
    private String id=UUID.randomUUID().toString().replaceAll("-","");
    private String kid = RandomUtils.randomKey();
    private String demoField;
    private String groupId;
    private Date createTime;
    private String appName;

}
