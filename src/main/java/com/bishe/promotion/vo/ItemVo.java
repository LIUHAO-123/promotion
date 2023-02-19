package com.bishe.promotion.vo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVo {
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String beginDate;
    private String endTime;
    private String imgUrl;

}
