package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public void create(User user);

    public void delete(Long id);

    public void update(User user);

    public User findOne(Long id);
}