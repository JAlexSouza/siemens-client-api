package com.siemens_energy.siemens_client_api.domain.entity;

import com.siemens_energy.siemens_client_api.domain.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @SequenceGenerator(name = "sequence_address" , sequenceName = "SEQ_ADDRESS", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_address")
    @Column(name = "ID_ADDRESS")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "DS_STATE")
    private State state;

    @Column(name = "DS_CITY")
    private String city;
}
