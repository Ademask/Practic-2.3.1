package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();

    public void create(User user);

    public void delete(Long id);

    public void update(User user, Long id);

    public User findOne(Long id);
}
