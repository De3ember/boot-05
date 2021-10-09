package com.zwy.boot05.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwy.boot05.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
