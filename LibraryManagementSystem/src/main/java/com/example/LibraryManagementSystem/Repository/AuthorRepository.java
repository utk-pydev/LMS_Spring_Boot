package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    /*
    * Spring data JPA provides @Query to write our own queries
    *
    * Native Query
    * JPQL - Java persistence query language
    * */


    Author findByEmail(String email);
    List<Author> findByAgeGreaterThanEqualAndCountryAndNameStartingWith(int age, String country, String prefix);

    @Query(value = "select * from author where email=?1", nativeQuery = true)
    public Author getAuthorGivenEmailId(String author_email);

   // @Query("select * from Author where email=?1")
   // public Author getAuthorGivenEmailIdJPQL(String author_email);


    @Query(value = "select * from author where land = ?1", nativeQuery = true)
    public Author getByCountryNameNative(String name);

 //   @Query(value = "select * from Author where country = ?1")
   // public List<Author> getByCountryNameJPQL(String country);
}
