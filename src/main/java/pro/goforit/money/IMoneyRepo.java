package pro.goforit.money;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2023/6/16 10:18
 * @desc:
 **/
public interface IMoneyRepo extends JpaRepository<Money, Long>, JpaSpecificationExecutor<Money> {
}
