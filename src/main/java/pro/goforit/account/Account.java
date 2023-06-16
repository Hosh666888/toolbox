package pro.goforit.account;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;

import java.io.Serial;
import java.io.Serializable;
import java.lang.annotation.Documented;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2023/6/16 9:43
 * @desc:
 **/
@Table(name = "log_account")
@Data
@Entity
public class Account implements Serializable {
    @Serial
    private static final long serialVersionUID = -2021083281576043367L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String app;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "super_pwd")
    private String superPwd;

}
