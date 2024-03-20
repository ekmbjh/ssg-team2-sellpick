package com.ssg.wsmt.smOrders.mapper;

import com.ssg.wsmt.inventory.domain.Inventory;
import com.ssg.wsmt.smOrders.domain.ShoppingMall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ShoppingMallMapper {
//    @Select("SELECT * FROM shopping_mall")
    List<ShoppingMall> findAll();

    List<Inventory> selectAll();
}
