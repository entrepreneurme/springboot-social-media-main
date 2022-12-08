package com.socialmedia.persistence;

import com.socialmedia.domain.PostNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends Neo4jRepository<PostNode,Long> {

}
