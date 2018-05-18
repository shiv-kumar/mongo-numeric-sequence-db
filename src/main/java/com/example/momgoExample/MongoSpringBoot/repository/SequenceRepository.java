package com.example.momgoExample.MongoSpringBoot.repository;

import com.example.momgoExample.MongoSpringBoot.exception.SequenceException;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SequenceRepository {

    BigInteger getNextSequenceId(String key) throws SequenceException;
}
