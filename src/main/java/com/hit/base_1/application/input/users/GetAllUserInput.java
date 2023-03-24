package com.hit.base_1.application.input.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUserInput {

    private Integer page;
    private Integer size;
    private String name;

}
