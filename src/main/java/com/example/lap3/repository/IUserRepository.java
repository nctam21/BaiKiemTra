//package com.example.lap3.repository;
//
//import com.example.lap3.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface IUserRepository extends JpaRepository<User, Long> {
//    @Query("Select u from User u Where u.username = ?1")
//    User findByUsername (String username);
//}
