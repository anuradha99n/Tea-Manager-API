package com.my_projects.Tea_Manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "price_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String priceTypeId;
    private String priceTypeName;

}
