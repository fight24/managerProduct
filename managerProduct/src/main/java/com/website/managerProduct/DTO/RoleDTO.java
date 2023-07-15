package com.website.managerProduct.DTO;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoleDTO implements Serializable {
    private long idRole;
    private String nameRole;
}
