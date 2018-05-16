package com.openhack;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1LoadBalancerIngress;
import io.kubernetes.client.models.V1Service;
import io.kubernetes.client.models.V1ServiceList;
import io.kubernetes.client.util.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManicraftRepository {

    public static List<Manicraft> find() throws IOException, ApiException {
        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();

        V1ServiceList v1ServiceList = api.listNamespacedService("default", null, null, null, null, null, null, null, null, null);


        List<V1Service> items = v1ServiceList.getItems();

        V1Service minecraftService = items.stream()
                .filter(v1Service -> v1Service.getMetadata().getName().equals("minecraft-service"))
                .collect(Collectors.toList())
                .get(0);

        List<Manicraft> list = new ArrayList<>();


        List<V1LoadBalancerIngress> ingress = minecraftService.getStatus().getLoadBalancer().getIngress();
        if(ingress == null){
            return list;
        }

        for (V1LoadBalancerIngress ingres : ingress) {
            Manicraft manicraft = new Manicraft(ingres.getHostname(), ingres.getIp());
            list.add(manicraft);
        }
        return list;
    }
}
