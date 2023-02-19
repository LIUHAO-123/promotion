
package com.bishe.promotion.entities;



import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String province;
    private String city;
    private String district;
    private String detail;
    private String consigneeName;
    private String mobile;
    private int  userId;

}
