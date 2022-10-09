package org.akon.userapp.resource;

import org.akon.userapp.domain.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorResource {

    @RequestMapping("/error")
    public ResponseEntity<HttpResponse> notFound404() {
        HttpResponse httpResponse = new HttpResponse(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.getReasonPhrase().toUpperCase(),
                "There is no mapping for this URL");
        return new ResponseEntity<>(httpResponse, HttpStatus.NOT_FOUND);
    }

}
