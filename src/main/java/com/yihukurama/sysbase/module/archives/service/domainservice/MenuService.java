package com.yihukurama.sysbase.module.archives.service.domainservice;

import com.yihukurama.sysbase.model.MenuEntity;
import com.yihukurama.sysbase.model.RoleprivilegeEntity;
import com.yihukurama.sysbase.module.archives.domain.Menu;
import com.yihukurama.sysbase.module.archives.domain.Roleprivilege;
import com.yihukurama.tkmybatisplus.app.exception.TipsException;
import com.yihukurama.tkmybatisplus.app.utils.EmptyUtil;
import com.yihukurama.tkmybatisplus.app.utils.TransferUtils;
import com.yihukurama.tkmybatisplus.framework.service.domainservice.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MenuService extends CrudService<MenuEntity> {
    @Autowired
    RoleprivilegeService roleprivilegeService;
    /**
     * 创建菜单时生成code
     * @param data
     * @return
     * @throws TipsException
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public MenuEntity create(MenuEntity data) throws TipsException {
        data.setCode(UUID.randomUUID().toString().replaceAll("-",""));
        return super.create(data);
    }

    /**
     * 删除菜单时级联删除角色菜单关联
     * @param menuEntity
     * @return
     * @throws TipsException
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int remove(MenuEntity menuEntity) throws TipsException {
        if(EmptyUtil.isEmpty(menuEntity.getId())){
            return 0;
        }
        RoleprivilegeEntity roleprivilegeEntity = new RoleprivilegeEntity();
        roleprivilegeEntity.setPrivilegeId(menuEntity.getId());
        roleprivilegeEntity.setType(Roleprivilege.QXLX_1);
        List<RoleprivilegeEntity> list = roleprivilegeService.list(roleprivilegeEntity);
        for (RoleprivilegeEntity entity : list) {
            roleprivilegeService.remove(entity);
        }
        return super.remove(menuEntity);
    }


    /**
     * 说明：递归遍历菜单子树
     * @author: ChenPeiLong
     * @date: Created in 11:17 2019/3/23
     * @modified: by ChenPeiLong in 11:17 2019/3/23
     */
    public void recursionTreeList(Menu parentMenu, Boolean asyn) throws TipsException {
        String parentId = parentMenu.getId();
        MenuEntity searchMenu = new MenuEntity();
        searchMenu.setParentId(parentId);
        List<Menu> childrenMenu = TransferUtils.transferEntityList2DomainList(this.list(searchMenu),Menu.class);
        if(!EmptyUtil.isEmpty(childrenMenu)){
            parentMenu.setIsLeaf(false);
            parentMenu.setChildren(childrenMenu);
            //同步加载
            if(!asyn){
                //继续加载他的子菜单
                for (Menu children : childrenMenu) {
                    recursionTreeList(children, asyn);
                }
            }
        }else{
            parentMenu.setIsLeaf(true);
            parentMenu.setChildren(new ArrayList<Menu>(0));
        }
    }
}
