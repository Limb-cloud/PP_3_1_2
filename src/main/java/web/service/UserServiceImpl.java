package web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;

@Service
public class UserServiceImpl implements UserService{

  private final UserDao dao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    dao = userDao;
  }

  @Override
  public List<User> listUsers() {
    return dao.list();
  }

  @Override
  public void addUser(User user) {
    dao.add(user);
  }

  @Override
  public void updateUser(User user) {
    dao.update(user);
  }

  @Override
  public void removeUser(Long id) {
    dao.remove(id);
  }

  @Override
  public User getUserById(Long id) {
    return dao.find(id);
  }
}
