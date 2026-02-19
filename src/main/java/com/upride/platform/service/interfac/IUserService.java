package com.upride.platform.service.interfac;

import com.upride.platform.dto.LoginRequest;
import com.upride.platform.dto.Response;
import com.upride.platform.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
