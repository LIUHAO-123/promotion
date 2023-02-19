package com.bishe.promotion.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVo {
    private String province;
    private String city;
    private String district;
    private String detail;
    private String consigneeName;
    private String mobile;


}
