package com.mt.portalcms.service;

import com.mt.portalcms.pojo.Items;

import java.util.List;

public interface ItemsService {
    List<Items> list();

    Integer insert(Items items);

    Integer update(Items items);

    Integer delete(Long id);

    Items findById(Long id);

    List<Items> select();

}
