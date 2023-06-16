package pro.goforit.account;

import jakarta.annotation.Resource;
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
 * @editTime: 2023/6/16 9:39
 * @desc:
 **/
@Controller
@RequestMapping("a")
public class AccountController {
    @Resource
    private IAccountRepo accountRepo;

    @PostMapping
    @ResponseBody
    public String addOrUpDate(@RequestBody Account account) {
        accountRepo.save(account);
        return "成功";
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        accountRepo.deleteById(id);
        return "删除成功";
    }

    @GetMapping
    public List<Account> find(@RequestParam(required = false) String app) {
        final List<Account> data = accountRepo.findAll((Specification<Account>) (root, query, criteriaBuilder) -> {
            if (StringUtils.hasText(app)) {
                return query.where(criteriaBuilder.like(root.get("app"), "%" + app + "%")).getRestriction();
            }
            return query.where().getRestriction();
        });
        return CollectionUtils.isEmpty(data) ? Collections.emptyList() : data;
    }

}
