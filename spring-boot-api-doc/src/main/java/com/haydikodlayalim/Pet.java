package com.haydikodlayalim;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet Modelim", description = "Pet Description")
public class Pet {

    @ApiModelProperty(value = "Pet nesnesinin id alani")
    private int id;
    @ApiModelProperty(value = "Pet nesnesinin ad alani")
    private String name;
    @ApiModelProperty(value = "Pet nesnesinin tarih alani")
    private Date date;
}
