
# Integration problem

This program was tested on Tomcat with stand-alone versions of RabbitMQ and ActiveMQ.

MQ servers were provided with docker.

ActiveMQ Server was started with   

	docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
And RabbitMQ was sarted with   

	docker run -d -p 5672:5672 -p 15672:15672 dockerfile/rabbitmq  

For RabbitMQ it was necessary to create queue messageGatewayQueue before sending messages.

Program is divided into two modules, gateway and processor. Those two modules can be run on same Tomcat or on separate servers.

Properties files are located in `/src/main/resources` directories for both modules.

Choosing what messaging technology to use can be done in classes ProcessorWebAppInitializer and GatewayWebAppInitializer in method addActiveProfiles. By default application is configured to use ActiveMQ.

There is also helper class MessageProcessorRunner which can run processor module as stand-alone application (outside web container) 