package com.dq.dao;

import com.dq.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    @Select("select o.*,p.productname,p.departuretime from orders o,product p where o.productid=p.id")
    @Results(
            value = {
                    @Result(column = "productname",property = "product.productName"),
                    @Result(column = "departuretime",property = "product.departureTime")
            }
    )
    List<Orders> list();
    @SelectKey(statement = "SELECT orders_seq.nextval from dual",
            keyProperty ="id",
            before = true,
            resultType = Long.class)
    @Insert("insert into" +
            " orders(id,orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,PRODUCTID) " +
            "values(#{id},#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    int add(Orders orders);



}
