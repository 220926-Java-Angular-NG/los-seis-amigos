package com.losAmigos.magiczon.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChangePassword {
    String username;
    String password;
    String newPassword;
}
