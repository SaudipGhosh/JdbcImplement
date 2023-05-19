package com.SpringDataJdbc.JdbcImplement.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmptyInputException extends RuntimeException{
    String ErrorCode;
    String ErrorMessage;
}
