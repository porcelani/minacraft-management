package com.openhack;

import io.kubernetes.client.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/manicrafts")
public class ManicraftController {


    @RequestMapping(method = RequestMethod.GET)
    List<Manicraft> getAllManicrafts() throws IOException, ApiException {
        return  ManicraftRepository.find();
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> addManicraft(@RequestBody Manicraft manicraft) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{manicraftName}")
    ResponseEntity<?> deleteManicraft(@PathVariable String manicraftName) {
        return null;
    }

}