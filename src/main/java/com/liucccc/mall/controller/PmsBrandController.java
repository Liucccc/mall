package com.liucccc.mall.controller;

import com.liucccc.mall.common.api.CommonPage;
import com.liucccc.mall.common.api.CommonResult;
import com.liucccc.mall.mbg.entity.PmsBrand;
import com.liucccc.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Liucccc
 * @date 2019/11/10 0:23
 */
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService brandService;

    @ApiOperation("添加品牌")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody PmsBrand brand) {
        CommonResult commonResult;
        int count = brandService.create(brand);
        if (count == 1) {
            commonResult = CommonResult.success(brand);
        } else {
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }

    @ApiOperation("修改指定品牌信息")
    @PostMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id, @RequestBody PmsBrand brand) {
        CommonResult commonResult;
        int count = brandService.update(id, brand);
        if (count == 1) {
            commonResult = CommonResult.success(brand);
        } else {
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }

    @ApiOperation("删除指定品牌")
    @PostMapping(value = "/delete/{id}")
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = brandService.delete(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("获取指定品牌详情")
    @GetMapping(value = "/{id}")
    public CommonResult<PmsBrand> detail(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.detail(id));
    }

    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("分页查询品牌列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<PmsBrand>> list(@RequestParam(value = "pageNum", defaultValue = "1")
                                                   @ApiParam("页码") Integer pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "10")
                                                   @ApiParam("每页数量") Integer pageSize,
                                                   @RequestParam(value = "name",required = false)
                                                   @ApiParam("品牌名称") String name) {
        List<PmsBrand> brandList = brandService.list(pageNum, pageSize,name);
        return CommonResult.success(CommonPage.restPage(brandList));
    }
}
