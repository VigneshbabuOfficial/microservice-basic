# microservice-basic

In this project we can learn spring cloud basics like how to create a basic web services and how to use spring cloud convert them as microservice.
Initially 2 web services were created as eureka client and Server Registry service created with Eureka server.
API Gateway is a service where its by passing the service request to respective services based on the end-points.

![image](https://user-images.githubusercontent.com/70185865/174142144-35d2d31a-f4ab-4541-b5e1-cacb202730fd.png)

Later logs added to trace them. Then Zipkin and Sleuth is configured to the 2 clients and monitored the logs at zipkin dahboard.

![image](https://user-images.githubusercontent.com/70185865/174142374-ec5b8257-e73e-4399-85cd-1c3d72b4817e.png)

ref:
https://www.youtube.com/watch?v=BnknNTN8icw&t=4118s


> api-gateway can be accessed from port:9191
>
> so, if we hit http://localhost:9191/client-service-1, api-gateway will redirect to client-service-1
>
> Trace ID and Span ID can be retrieved from
```JAVA

@Autowired
	private Tracer tracer;
  
  
  Span span = tracer.currentSpan();
  // "Span ID {} = "+ span.context().spanId()+" -- Trace ID {} = " + span.context().traceId()
  
  span ID -> service specific id
  trace ID -> transaction id which is traversed though multiple services
  
  E.g:
  

```

> INFO [client-service-1,be420ca8a8320915,7e88f861d588e01a]ClientService1Application [0;39m ------  FIRSTCLIENTCONTROLLER -  getInfoFromOthers  ------------------Span ID {} = 7e88f861d588e01a -- Trace ID {} = be420ca8a8320915
>
> INFO [client-service-2,be420ca8a8320915,b9085aa5eabbbe26]ClientService2Application [0;39m ------  SECONDCLIENTCONTROLLER -  getInfoForOthers  ------------------Span ID {} = b9085aa5eabbbe26 -- Trace ID {} = be420ca8a8320915



