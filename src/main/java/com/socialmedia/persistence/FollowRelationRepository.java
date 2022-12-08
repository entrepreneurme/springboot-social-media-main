package com.socialmedia.persistence;

import com.socialmedia.domain.FollowRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FollowRelationRepository extends Neo4jRepository<FollowRelation, Long> {
}
