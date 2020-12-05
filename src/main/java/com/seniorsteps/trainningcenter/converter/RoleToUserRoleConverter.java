package com.seniorsteps.trainningcenter.converter;

import com.seniorsteps.trainningcenter.model.Role;
import com.seniorsteps.trainningcenter.model.UserRole;
import com.seniorsteps.trainningcenter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserRoleConverter implements Converter<String, UserRole> {

    @Autowired
    private RoleService roleService;

    @Override
    public UserRole convert(String idString) {
        UserRole userRole = null;
        if (idString != null && !idString.isEmpty()) {
            Integer id = Integer.parseInt(idString);

            Role role = roleService.getById(id);

            userRole = new UserRole();
            userRole.setRole(role);
        }
        return userRole;
    }

}
