package com.zwy.boot05.mapper;

import com.zwy.boot05.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public Account getAccount(Integer id);
}
