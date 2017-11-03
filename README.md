# Spring WebSockets and RabbitMQ Demo

Configure Spring WebSockets to use RabbitMQ message broker.

## What for?

When working on a multi-instance web application, messaging service may be a problem when hosted by application containers, such as: [Wildfly](http://wildfly.org/) or [Tomcat](http://tomcat.apache.org/). That is because you may want that all connected web sockets are knowledgeable by any application container and not only by the one it was first registered. So when a message needs to be broadcasted it can truly reach all connected web sockets.

One option to solve this situation is to enable a message broker that will host our channels and operate incoming and routing of messages. In here I use RabbitMQ as message broker.

## Setup

Before running this demo, make sure you have RabbitMQ server running and accessible. You may either [install](https://www.rabbitmq.com/download.html) it or run on [Docker](https://hub.docker.com/_/rabbitmq/).

Default connection information, which is used in this demo:

`127.0.0.1:61613`

Admin interface, if [management plugin](https://www.rabbitmq.com/management.html) is enabled:

`127.0.0.1:15672`

Default user and password are: `guest/guest`

## Run

- Clone
- Run SpringWebsocketsRabbitmqDemoApplication.java

## Play

- Go to *http://localhost:8080*
- Cick *Connect*
- On a new tab go to same address and *Connect*
- Fill in a message and click *Send*
- Message should be delivered to WebSockets on both tabs

Great! We have Spring WebSockets working with RabbitMQ as a message broker relay :D