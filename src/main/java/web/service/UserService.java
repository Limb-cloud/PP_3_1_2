package web.service;

import java.util.List;
import web.models.User;

public interface UserService {
  List<User> listUsers();
  void addUser(User user);
  void updateUser(User user);
  void removeUser(Long id);
  User getUserById(Long id);
}
