package com.novasoft.springbootconsultsales.application.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PagedResponse<T> extends BaseResponse<T> {
    private int page;
    private int size;
}
