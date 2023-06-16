package pro.goforit.money;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2023/6/16 10:16
 * @desc:
 **/
@Data
@Table(name = "log_money")
@Entity
public class Money implements Serializable {
    @Serial
    private static final long serialVersionUID = 8297180563518828221L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String category;

    @Column
    private String detail;

    @Column
    private double money;

    @Column
    private String remark;

    @Column(name = "log_time")
    private LocalDateTime logTime;

}
