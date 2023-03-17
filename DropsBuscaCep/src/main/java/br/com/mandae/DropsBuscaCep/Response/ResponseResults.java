package br.com.mandae.DropsBuscaCep.Response;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ResponseResults {

    private String adress;
    private String number;
    private  String complement;
    private String district;
    private String line;
    private String city;
    private String state;
    private String id;
    private String name;
    @JsonAlias({"postal_code", "postalcode"}) String postalcode;
    @JsonAlias({"social_name", "socialName"}) String socialName;
    @JsonAlias ({"reference_point", "referencepoint"}) String referencepoint;
}
