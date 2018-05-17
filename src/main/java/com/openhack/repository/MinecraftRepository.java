package com.openhack.repository;

import com.openhack.dto.Minecraft;
import com.openhack.util.ExecuteShellCommand;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.*;
import io.kubernetes.client.util.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinecraftRepository {

    public static List<Minecraft> find() throws IOException, ApiException {
        try {
            ApiClient client = Config.defaultClient();
            Configuration.setDefaultApiClient(client);

            CoreV1Api api = new CoreV1Api();

            V1PodList aDefault = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
            List<V1Pod> items = aDefault.getItems();

            List<V1Pod> minecrafts = items.stream()
                    .filter(v1Pod -> v1Pod.getMetadata().getGenerateName().contains("minecraft"))
                    .collect(Collectors.toList());


            ArrayList<Minecraft> list = new ArrayList<>();
            int cont = 1;
            for (V1Pod ingres : minecrafts) {
                V1ObjectMeta metadata = ingres.getMetadata();
                Minecraft minecraft = new Minecraft("minecraft" + cont, ingres.getStatus().getHostIP());
                list.add(minecraft);
                cont++;
            }

            return list;

        } catch (Exception e) {
            return new ArrayList<>();
        }


    }

    public static void resize(Integer size) {
        ExecuteShellCommand com = new ExecuteShellCommand();
        System.out.println(com.executeCommand("kubectl scale statefulsets/minecraft --replicas="+size));
    }
}
