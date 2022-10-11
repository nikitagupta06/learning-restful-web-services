package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/Person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/Person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonByRequestParameter(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    @GetMapping(path = "/person/header" , headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonByRequestHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header" , headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonByRequestHeader(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    @GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonByMediaType(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/accept" , produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonByMediaType(){
        return new PersonV2(new Name("Bob","Charlie"));
    }
}
