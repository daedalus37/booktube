package com.odyssey.booktube.models.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    /**
     * The item being returned
     */
    T item;

    /**
     * The status code of the integer
     */
    Integer status_code;

    /**
     * The message for the response
     */
    String message;
}
