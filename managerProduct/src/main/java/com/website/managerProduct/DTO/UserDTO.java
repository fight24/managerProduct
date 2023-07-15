package com.website.managerProduct.DTO;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO implements Serializable {
    private String UserName;
    private List<RoleDTO> roles;
}
