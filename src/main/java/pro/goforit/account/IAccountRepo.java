package pro.goforit.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2023/6/16 9:50
 * @desc:
 **/
public interface IAccountRepo extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {

}
