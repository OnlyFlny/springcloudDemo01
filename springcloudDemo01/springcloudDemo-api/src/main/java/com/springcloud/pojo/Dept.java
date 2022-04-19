package com.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept  implements Serializable {

    private Long deptno;
    private String deptname;
    private String db_source;// 同一个数据可能存在不同的应用数据库

    public Dept(Long deptno, String deptname, String db_source) {
        this.deptno = deptno;
        this.deptname = deptname;
        this.db_source = db_source;
    }

}
