package com.openhack;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manicrafts")
public class ManicraftController {


    @RequestMapping(method = RequestMethod.GET)
    List<Manicraft> getAllManicrafts() {
        ArrayList arrays = new ArrayList();
        arrays.add(new Manicraft("name1", "10.10.10.10"));
        return arrays;
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