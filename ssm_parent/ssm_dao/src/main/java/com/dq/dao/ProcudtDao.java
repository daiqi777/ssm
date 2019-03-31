package com.dq.dao;


import com.dq.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProcudtDao {
    @Select("select * from product")
    List<Product> list();

    @SelectKey(statement = "SELECT PRODUCT_SEQ.NEXTVAL FROM dual",
               keyProperty = "id",
               before = true,
               resultType =Integer.class)
    @Insert("insert into" +
            " product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            " values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int add(Product product);


    @Select("select * from product where id=#{id}")
    Product getById(Long id);

    @Update("update product set productNum = #{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    int update(Product product);

    @Delete("delete from product where id=#{id}")
    int deleteById(Integer id);

}
