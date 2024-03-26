package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements  UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findOne(id));
    }

    @Override
    public void update(User user, Long id) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    public User findOne(Long id) {
        return entityManager.find(User.class, id);
    }


}
