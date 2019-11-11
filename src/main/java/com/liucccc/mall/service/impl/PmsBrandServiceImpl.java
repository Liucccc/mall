package com.liucccc.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.liucccc.mall.mbg.entity.PmsBrand;
import com.liucccc.mall.mbg.entity.PmsBrandExample;
import com.liucccc.mall.mbg.mapper.PmsBrandMapper;
import com.liucccc.mall.service.PmsBrandService;
import com.liucccc.mall.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liucccc
 * @date 2019/11/10 0:26
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public int create(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int update(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int delete(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> list(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        PmsBrandExample example = new PmsBrandExample();
        if(StringUtil.isNotEmpty(name)){
            example.createCriteria().andNameLike("%"+name+"%");
        }
        redisService.set("a","abc");
        return brandMapper.selectByExample(example);
    }

    @Override
    public PmsBrand detail(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
