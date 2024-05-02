package com.multiplierwebapp.multiplier.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="multiplier_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiplierData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long num;
    private long multiplyBy2;
    private long multiplyBy2Square;
}
