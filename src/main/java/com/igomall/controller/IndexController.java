package com.igomall.controller;

import com.igomall.Demo;
import com.igomall.Results;
import com.igomall.controller.admin.BaseController;
import com.igomall.entity.*;
import com.igomall.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/init")
public class IndexController extends BaseController {

    @Inject
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Inject
    private SkuService skuService;
    @Autowired
    private SnService snService;
    @Autowired
    private StoreService storeService;

    @GetMapping("/page")
    public ResponseEntity<?> parse(String type, Integer page, Long productCategoryId,Integer start) throws IOException {
        if(start==null){
            start = 1;
        }
        Store currentStore = storeService.find(10001L);
        ProductCategory productCategory = productCategoryService.find(productCategoryId);
        for (int i=start;i<=page;i++) {
            String url="https://www.suibianlu.com/"+type+"_"+i+"/";
            List<Product> products = Demo.parsePage(url);
            for (Product product:products) {
                if(StringUtils.isBlank(product.getSn())){
                    product.setSn(snService.generate(Sn.Type.PRODUCT));
                }

                if (productCategory == null) {
                    return Results.UNPROCESSABLE_ENTITY;
                }
                // 设置图片
                List<ProductImage> productImages = new ArrayList<>();
                ProductImage productImage = new ProductImage();
                productImage.setLarge(product.getAttributeValue1());;
                productImage.setMedium(product.getAttributeValue1());
                productImage.setSource(product.getAttributeValue1());
                productImage.setThumbnail(product.getAttributeValue1());
                productImage.setOrder(1);
                productImages.add(productImage);
                product.setProductImages(productImages);
                product.setStore(currentStore);
                product.setProductCategory(productCategory);
                product.removeAttributeValue();

                if (!isValid(product, BaseEntity.Save.class)) {
                    return Results.UNPROCESSABLE_ENTITY;
                }
                if (StringUtils.isNotEmpty(product.getSn()) && productService.snExists(product.getSn())) {
                    return Results.UNPROCESSABLE_ENTITY;
                }
                System.out.println(product.getSkus());
                List<Sku> collect = product.getSkus().stream().collect(Collectors.toList());
                Sku sku = collect.get(0);
                if (sku == null || !isValid(sku, getValidationGroup(product.getType()), BaseEntity.Save.class)) {
                    return Results.UNPROCESSABLE_ENTITY;
                }
                productService.create(product, sku);
            }
        }
        return Results.OK;
    }

    @PostMapping("/category")
    public ResponseEntity<?> save(ProductCategory productCategory, Long parentId) {
        productCategory.setParent(productCategoryService.find(parentId));
        if (!isValid(productCategory)) {
            return Results.UNPROCESSABLE_ENTITY;
        }
        String[] names = productCategory.getName().split(";");
        for (String name:names) {
            if(StringUtils.isNotBlank(name)){
                ProductCategory productCategory1 = new ProductCategory();
                productCategory1.setName(name);
                productCategory1.setGeneralRate(0.0);
                productCategory1.setSelfRate(0.0);
                productCategory1.setSeoDescription(productCategory1.getName());
                productCategory1.setSeoKeywords(productCategory1.getName());
                productCategory1.setSeoTitle(productCategory1.getName());
                productCategory1.setTreePath(null);
                productCategory1.setGrade(null);
                productCategory1.setChildren(null);
                productCategory1.setProducts(null);
                productCategory1.setParameters(null);
                productCategory1.setAttributes(null);
                productCategory1.setSpecifications(null);
                productCategory1.setStores(null);
                productCategory1.setCategoryApplications(null);
                productCategoryService.save(productCategory1);
            }
        }
        return Results.OK;
    }

    /**
     * 根据类型获取验证组
     *
     * @param type
     *            类型
     * @return 验证组
     */
    private Class<?> getValidationGroup(Product.Type type) {
        Assert.notNull(type, "[Assertion failed] - type is required; it must not be null");

        switch (type) {
            case GENERAL:
                return Sku.General.class;
            case EXCHANGE:
                return Sku.Exchange.class;
            case GIFT:
                return Sku.Gift.class;
            case VIRTUAL:
                return Sku.Virtual.class;
        }
        return null;
    }
}
