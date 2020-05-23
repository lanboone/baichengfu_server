package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.ProductCommentEntity;
import com.yihukurama.sysbase.model.ProductCommentEntity;
import com.yihukurama.sysbase.model.ProductEntity;
import com.yihukurama.sysbase.module.app.designp.observer.AppEventPublisher;
import com.yihukurama.sysbase.module.app.designp.observer.event.CommentEvent;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.LogUtil;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentService extends CrudService<ProductCommentEntity> {

    @Autowired
    ProductService productService;

    @Autowired
    AppEventPublisher appEventPublisher;

    @Override
    public ProductCommentEntity create(ProductCommentEntity productCommentEntity) throws TipsException {
        if (EmptyUtil.isEmpty(productCommentEntity.getCommentName())
                || EmptyUtil.isEmpty(productCommentEntity.getCreaterId())
                || EmptyUtil.isEmpty(productCommentEntity.getCommentContent())
                || EmptyUtil.isEmpty(productCommentEntity.getProductId())
                || EmptyUtil.isEmpty(productCommentEntity.getCParentId())
        ) {
            throw new TipsException("发表评论时昵称、创建人id、商品id、评论内容、父评论id不可为空");
        }

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productCommentEntity.getProductId());
        productEntity = productService.load(productEntity);
        productCommentEntity.setProductName(productEntity.getProductName());
        productCommentEntity = super.create(productCommentEntity);


        //创建评论时如果是评论的回复，则需要写入父评论的reply_path
        if(productCommentEntity.getCParentId().length() == 32){
            LogUtil.debugLog(this,"into comment event");
            appEventPublisher.publishEvent(new CommentEvent(productCommentEntity,CommentEvent.TYPE_20));
        }
        return productCommentEntity;
    }


}
