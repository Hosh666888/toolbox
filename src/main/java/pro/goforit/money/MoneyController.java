package pro.goforit.money;

import jakarta.annotation.Resource;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2023/6/16 10:20
 * @desc:
 **/
@Controller
@RequestMapping("m")
public class MoneyController {
    @Resource
    private IMoneyRepo moneyRepo;

    @PostMapping
    @ResponseBody
    public String addOrUpdate(Money money) {
        moneyRepo.save(money);
        return "成功";
    }


    @DeleteMapping("id")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        moneyRepo.deleteById(id);
        return "删除成功";
    }


    @GetMapping
    @ResponseBody
    public List<Money> get(@PathVariable(required = false) String category) {
        final List<Money> data = moneyRepo.findAll((Specification<Money>) (root, query, criteriaBuilder) -> {
            if (StringUtils.hasText(category)) {
                return query.where(criteriaBuilder.like(root.get("category"), "%" + category + "%")).getRestriction();
            }
            return query.getRestriction();
        });
        return CollectionUtils.isEmpty(data) ? Collections.emptyList() : data;
    }


}
