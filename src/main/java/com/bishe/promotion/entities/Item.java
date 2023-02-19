package com.bishe.promotion.entities;




import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private LocalDate beginDate;
    private LocalDate endTime;
    private String imgUrl;

}
