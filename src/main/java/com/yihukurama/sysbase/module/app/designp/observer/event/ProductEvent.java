package com.yihukurama.sysbase.module.app.designp.observer.event;

import com.yihukurama.sysbase.common.utils.NumberUtil;
import com.yihukurama.sysbase.mapper.ProductMapper;
import com.yihukurama.sysbase.model.AppuserProductEntity;
import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.module.archives.domain.AppuserProduct;
import com.yihukurama.sysbase.module.archives.domain.Product;
import com.yihukurama.sysbase.module.archives.service.domainservice.ProductService;
import com.yihukurama.tkmybatisplus.app.component.SpringBeanTools;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import org.springframework.context.ApplicationEvent;

/**
 * 说明： 商品事件
 * @author yihukurama
 * @date Created in 16:50 2020/4/19
 *       Modified by yihukurama in 16:50 2020/4/19
 */
public class ProductEvent extends ApplicationEvent {
    /**
     * 收藏商品事件
     */
    public final static int TYPE_10 = 10;
    /**
     * 取消收藏商品事件
     */
    public final static int TYPE_20 = 20;

    /**
     * 出售商品事件
     */
    public final static int TYPE_30 = 30;


    /**
     * 更新商品事件
     */
    public final static int TYPE_40 = 40;


    /**
     * 事件类型 10收藏商品   20取消收藏商品
     */
    private Integer type;

    public ProductEvent(Object source) {
        super(source);
    }


    public ProductEvent(Object source, Integer type) {
        super(source);
        this.type = type;
    }


    public void handleEvent(){
        switch (type){
            case TYPE_10:
                LogUtil.debugLog(this,"收藏商品事件");
                storeProduct();
                break;
            case TYPE_20:
                unStoreProduct();
                break;
            case TYPE_30:
                soldProduct();
                break;

            case TYPE_40:
                updateProduct();
                break;

            default:
        }
    }

    private void updateProduct() {
        if (!(source instanceof Product)) {
            LogUtil.errorLog(this,"处理更新事件出错，事件源不是 Product");
            return;
        }
        Product product = (Product) source;
        ProductMapper productMapper = (ProductMapper) SpringBeanTools.getBean(ProductMapper.class);
        ProductEntity productEntity = productMapper.selectByPrimaryKey(product.getId());

        AppuserProductEntity appuserProductEntity = new AppuserProductEntity();
        appuserProductEntity.setProductId(product.getId());


    }

    /**
     * 出售商品事件
     */
    private void soldProduct() {
        if (!(source instanceof AppuserProductEntity)) {
            LogUtil.errorLog(this,"处理收藏事件出错，事件源不是 AppuserProductEntity");
            return;
        }

        //商品销量+1
        AppuserProductEntity appuserProductEntity = (AppuserProductEntity) source;
        ProductMapper productMapper = (ProductMapper) SpringBeanTools.getBean(ProductMapper.class);
        ProductEntity productEntity = productMapper.selectByPrimaryKey(appuserProductEntity.getProductId());
        ProductEntity updateProductEntity = new ProductEntity();
        updateProductEntity.setId(productEntity.getId());
        updateProductEntity.setSalesVolume(NumberUtil.NullPlus(productEntity.getSalesVolume(),1));
        updateProductEntity.setOrderCount(NumberUtil.NullPlus(productEntity.getOrderCount(),1));
        //商品库存减一
        updateProductEntity.setStock(NumberUtil.NullSub(productEntity.getStock(),1));
        productMapper.updateByPrimaryKeySelective(updateProductEntity);

    }

    /**
     * 说明： 收藏商品事件
     * @author yihukurama
     * @date Created in 16:52 2020/4/19
     *       Modified by yihukurama in 16:52 2020/4/19
     */
    public void storeProduct(){
        if (!(source instanceof AppuserProductEntity)) {
            LogUtil.errorLog(this,"处理收藏事件出错，事件源不是 AppuserProductEntity");
            return;
        }

        LogUtil.debugLog(this,"收藏商品事件");

        //商品收藏数+1
        AppuserProductEntity appuserProductEntity = (AppuserProductEntity) source;
        ProductMapper productMapper = (ProductMapper) SpringBeanTools.getBean(ProductMapper.class);
        ProductEntity productEntity = productMapper.selectByPrimaryKey(appuserProductEntity.getProductId());
        ProductEntity updateProductEntity = new ProductEntity();
        updateProductEntity.setId(productEntity.getId());
        updateProductEntity.setFavoriteNumber(NumberUtil.NullPlus(productEntity.getFavoriteNumber(),1));
        updateProductEntity.setOrderCount(NumberUtil.NullPlus(productEntity.getOrderCount(),1));
        productMapper.updateByPrimaryKeySelective(updateProductEntity);

    }

    /**
     * 说明： 取消商品收藏事件
     * @author yihukurama
     * @date Created in 16:52 2020/4/19
     *       Modified by yihukurama in 16:52 2020/4/19
     */
    public void unStoreProduct(){

        if (!(source instanceof AppuserProductEntity)) {
            LogUtil.errorLog(this,"处理收藏事件出错，事件源不是 AppuserProductEntity");
            return;
        }

        //商品收藏数-1
        AppuserProductEntity appuserProductEntity = (AppuserProductEntity) source;
        ProductMapper productMapper = (ProductMapper) SpringBeanTools.getBean(ProductMapper.class);
        ProductEntity productEntity = productMapper.selectByPrimaryKey(appuserProductEntity.getProductId());
        ProductEntity updateProductEntity = new ProductEntity();
        updateProductEntity.setId(productEntity.getId());
        updateProductEntity.setFavoriteNumber(NumberUtil.NullSub(updateProductEntity.getFavoriteNumber(),1));
        productMapper.updateByPrimaryKeySelective(updateProductEntity);

    }
}
