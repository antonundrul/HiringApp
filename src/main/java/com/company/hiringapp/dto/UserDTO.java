package com.company.hiringapp.dto;

import com.company.hiringapp.entity.Vacancy;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDTO extends AbstractDTO {

    private String username;
    @Null
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    //    private List<ParcelDTO> parcels;
    private Integer blocked;
//    private String avatar;
//    private List<VacancyDTO> vacancies;

/*
    private MultipartFile imageUpdate;
    @Null
    private byte[] image;
*/

    @Null
    private Set<RoleDTO> roles;

}
