package com.company.hiringapp.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDTOwithPhoto extends AbstractDTO{
    private String username;
    @Null
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    //    private List<ParcelDTO> parcels;
    private Integer blocked;
    private MultipartFile avatar;
    private String avatarName;
}
