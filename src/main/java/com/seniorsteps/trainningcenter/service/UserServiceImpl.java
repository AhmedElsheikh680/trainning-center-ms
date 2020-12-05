package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dao.UserDao;
import com.seniorsteps.trainningcenter.model.User;
import com.seniorsteps.trainningcenter.model.UserRole;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User save(User user) {
        if (user.getPassword() != null) {
            String newPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(newPassword);
        }
        User addedUser = userDao.insert(user);
        if (addedUser != null) {
            if (user.getUserRoles() != null && !user.getUserRoles().isEmpty()) {
                Set<UserRole> userRoles = user.getUserRoles();
                for (UserRole userRole : userRoles) {
                    userRole.setUser(addedUser);
                    userRoleService.save(userRole);
                }
            }
        }
        return addedUser;
    }

    @Override
    public User update(User user) {
        if (user.getPassword() == null) {
            User oldUser = userDao.getById(user.getId());
            user.setPassword(oldUser.getPassword());
        } else {
            String newPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(newPassword);
        }
        return userDao.edit(user);
    }

    @Override
    public boolean delete(User user) {
        return userDao.remove(user);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
