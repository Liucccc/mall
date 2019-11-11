package com.liucccc.mall.service;

import com.liucccc.mall.mbg.entity.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liucccc
 * @date 2019/11/10 0:26
 */
public interface PmsBrandService {
    int create(PmsBrand brand);

    int update(Long id, PmsBrand brand);

    int delete(Long id);

    List<PmsBrand> list(int pageNum, int pageSize, String name);

    PmsBrand detail(Long id);
}
