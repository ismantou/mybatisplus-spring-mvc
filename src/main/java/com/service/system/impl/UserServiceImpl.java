package com.service.system.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mapper.system.UserMapper;
import com.model.system.User;
import com.service.system.IUserService;

/**
 *
 * User 表数据服务层接口实现类
 *
 * @author huang
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}