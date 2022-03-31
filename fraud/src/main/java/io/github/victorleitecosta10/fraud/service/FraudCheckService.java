package io.github.victorleitecosta10.fraud.service;

import io.github.victorleitecosta10.fraud.model.entity.FraudCheckHistory;
import io.github.victorleitecosta10.fraud.model.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(now())
                .build());

        return false;
    }
}
