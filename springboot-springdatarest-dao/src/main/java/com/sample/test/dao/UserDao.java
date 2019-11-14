package com.sample.test.dao;

import com.sample.test.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "people")
public interface UserDao extends JpaRepository<User,Integer> {

    @Modifying
    @Query(value = "update test_user set user_name = :username where id = :userId",nativeQuery = true)
    public Integer updateUsernameById(String username, @Param("userId") int id);

    @RestResource(path = "userNameStartingWith", rel = "userNameStartingWith")
    public User findByUserNameStartingWith(String userName);
}
