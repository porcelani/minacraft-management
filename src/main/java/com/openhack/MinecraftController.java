package com.openhack;

import com.openhack.dto.Minecraft;
import com.openhack.repository.MinecraftRepository;
import io.kubernetes.client.ApiException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/minecrafts")
public class MinecraftController {


    @RequestMapping(method = RequestMethod.GET)
    List<Minecraft> getAllManicrafts() throws IOException, ApiException {
        return MinecraftRepository.find();
    }


    @RequestMapping(value = "/{size}", method = RequestMethod.GET)
    List<Minecraft> addManicraft(@PathVariable Integer size) throws IOException, ApiException {
        MinecraftRepository.resize(size);
        return MinecraftRepository.find();
    }

}