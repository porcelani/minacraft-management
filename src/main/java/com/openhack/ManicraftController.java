package com.openhack;

import io.kubernetes.client.ApiException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manicrafts")
public class ManicraftController {


    @RequestMapping(method = RequestMethod.GET)
    List<Minecraft> getAllManicrafts() throws IOException, ApiException {
        return  ManicraftRepository.find();
    }


    @RequestMapping(value="/{size}", method=RequestMethod.GET)
    List<Minecraft> addManicraft(@PathVariable Integer size) {
        System.out.print(size);


        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

}