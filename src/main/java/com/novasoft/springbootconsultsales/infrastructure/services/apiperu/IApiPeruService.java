package com.novasoft.springbootconsultsales.infrastructure.services.apiperu;


public interface IApiPeruService {

    ApiPeruResponseModel<ApiPeruPersonModel> getPerson(String numberDocument);

}
