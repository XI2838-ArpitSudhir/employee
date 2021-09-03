package com.example.employee.sevices;

import com.example.employee.models.CustomSequences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;


import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class NextSequenceService {

    @Autowired
    MongoOperations operations;

    public long getNextSequence(String seqName){
        CustomSequences customSequences = operations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                CustomSequences.class);
        return !Objects.isNull(customSequences) ? customSequences.getSeq() : 1;
    }
}
