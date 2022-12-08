package com.socialmedia.persistence;

import com.socialmedia.domain.PersonNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepository extends Neo4jRepository<PersonNode,Long> {

    @Query("MATCH (n:Person) RETURN n")
    List<PersonNode> findAllPeople();

    PersonNode findByUsername(String username);

    Optional<PersonNode> findOneByUsername(String username);

    Optional<PersonNode> findOneByEmail(String email);

    @Query("MATCH (n:Person {username: $username}) RETURN n")
    PersonNode findByUsernameCustom(String username);

    void deleteById(Long id);

    void deleteByUsername(String username);
}
