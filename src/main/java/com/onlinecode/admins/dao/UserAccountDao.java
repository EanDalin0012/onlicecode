package com.onlinecode.admins.dao;

import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountDao {
    int updateUserAccount(MMap param);

    MultiMap getList(MMap param);

    int count();
}
