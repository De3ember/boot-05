package com.zwy.boot05.Service.Impl;

import com.zwy.boot05.Service.AccountService;
import com.zwy.boot05.bean.Account;
import com.zwy.boot05.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    public Account getById(Integer id){
        return  accountMapper.getAccount(id);

    }
}
