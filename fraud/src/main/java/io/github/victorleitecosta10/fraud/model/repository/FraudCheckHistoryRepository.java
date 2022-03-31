package io.github.victorleitecosta10.fraud.model.repository;

import io.github.victorleitecosta10.fraud.model.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
