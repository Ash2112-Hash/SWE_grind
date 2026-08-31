
# API Design


### What is an API?

Application programming interface, basically an interface that allows interactions with another app/service. Specifically, we want to give the user/application specific access to another app/service through api methods. You can use this to communicate to another API/service or between backend and frontend within the same product. 

We are basically exposing capabilities to our app for external systems/services


## Types of APIs

### REST
Restful APIs which stand for representable state transfer APIs. They transfer state between apps. They use HTTP communication protocol and have JSON body for response and request. 

### SOAP
An alternative to REST, these are used for legacy and enterprise systems. These use XML as their format for request and response. When you build a new system within a old product, you may need to integrate with SOAP if it is used for interactions. 

### GraphQL
This version, instead of exposing multiple endpoints (like REST). In this case, there is one graphql backend endpoint and the frontend queries what is needed (not all data, just what is required). This reduces the size of response bodies. 

### gRPC
Google's remote procedure call that uses protocol buffers to serialize data to reduce its size and allow for fast data transfer. Very common in microservices that need fast data transfer for cross app communications. In this case, you will have files such as proto type that will define the structure for data that is needed between microservices within the application.

### Websocket
A bidirectional channel that is used to communicate between BE and FE via a two way system. This is done by the backend opening a connection and sustaining that connection for communication. This is done for real time systems such as chat apps and notification systems.



## RESTful APIs

These APIs will have methods since its build on top of the HTTP protocol

### HTTP Methods

- GET: retrieve a resource/entity/record (i.e user record, a posted comment)
- POST: create a resource (adding new data)

### Endpoints
A combination of the method and the path (url describing what resource to access).

Sample URL structure:
- mysite.com/api/v1/resource/id
- posts/{id}/comments

URLs structure the ways/interfaces to interact with the application's backend.

Example:
For a social media site, you wont work with a endpoint as "comments" but rather "posts/{id}/comments", by bucketing comments within another resource. 


#### Sample Endpoints
- GET: /posts/{id}/comments - getting the comments from a specific post denoted by its id. Ex. posts/123/comments,
- POST: /post/{id}/comments - creating a new comment for a specific post. The url is the same but the method is different. In this case, since its POST, you have to attach the new comment data to the url body (JSON body). 
- GET: /comments/{id}: get a specific comment data
- PUT: /comments/{id}: replace/update a specific comment
- PATCH: /comments/{id}: partially update a specific comment
- DELETE: /comments/{id}: remove/delete the comment
- POST: /comments/{id}/reply: create a reply to a parent comment
- GET: /comments/{id}/replies: get the replies of a specific comment 
- GET: /user/{id}/comments: get the comments of a specific user

**PATCH vs PUT**:
For PUT, you need to change/update the entire resource. With PATCH, you can do a partial update and only change a specific portion/attribute. 

Updates should be idempotent: the operation can be applied multiple times and end result is the same. This is important for accidental resubmissions and frequent updates. A POST should not be idempotent since you will either get a error or be creating duplicating a resource. 

**Nested data vs. filtering**:

- Nested data: /posts/{id}/comments - nesting the comments data with the posts data
- Filtering: /comments?post_id={id} - filtering the comments data using a specific post id
- 


### Response Format
JSON: javascript object notation, contained within curly brackets with the name/id of the object/data, and some attributes. Usuaully contains all types of data types (int, flioat, bool, arr, null) and other objects as well. 

However, date, function and undefined are unsupported. 



