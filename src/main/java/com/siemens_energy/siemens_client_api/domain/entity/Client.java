package com.siemens_energy.siemens_client_api.domain.entity;

import com.siemens_energy.siemens_client_api.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @SequenceGenerator(name = "sequence_client" , sequenceName = "SEQ_CLIENT", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_client")
    @Column(name = "ID_CLIENT")
    private Long id;

    @Column(name = "NM_CLIENT")
    private String name;

    @Column(name = "TP_GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "DT_BIRTH_DAY", columnDefinition = "DATE")
    private LocalDate birthDay;

    @OneToOne
    @JoinColumn(name = "ID_ADDRESS")
    private Address address;
}
