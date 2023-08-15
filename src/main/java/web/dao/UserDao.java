package web.dao;

import java.util.List;
import web.models.User;

public interface UserDao {
  List<User> list();
  void add(User user);
  void update(User user);
  void remove(Long id);
  User find(Long id);

}
