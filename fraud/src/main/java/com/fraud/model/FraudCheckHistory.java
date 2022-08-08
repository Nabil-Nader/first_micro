package com.fraud.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {


    @Id
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "fraud_id_sequence")
    private Long id;

    private Long customerId;

    private Boolean isFraudster;

    private LocalDateTime createAt ;

}
