# Assigmnets - Design Decisions 

# Requirement

The requirments of the assignment is as a follows

          a. A survey to be conducted , where survey will contains some questions.
          b. Each Question has multiple possible answers.
          c. User respond to the survey by sending his/her preferred answers.
 Based on the above condition design REST inetraced to create /update / delete / get / get all questions and answers. User should able to responde to survey and calculate number of response to a question of a survey and distribution of its answers.
 
 # Design Principle 
 
 The project is developed based on the microservice principles and basic domain model is below . 
 
 
 # Domain Driven Principle and Microservice Identification 
 
 Application is decomposed into two basic domains 
            a. Question Domain 
            b. Survey Domain 
            
  Figure below describes detail domain design .
 
 
 # Application Architecture  and Technology Selection
 
 Spring boot and JPA is used for developing Microservices as Spring-boot is preferred framework as per given requirement.  
 Application architecture follows Hexagonal architecture or Ports and Adapter pattern. Core to which is domain which is insulated from 
 any database specific or vendor soecific locking . It is accessed by a Repository and top of which a spring service layer. 
 All Rest services are exposed using Spring Rest Controller and accept request using HTTP protocol . Optionally it can be extended to  support HTTPS also. 
 
 Figure below describes Hexagonal Architecture for Question Microservice.
 
 ![Hexagonal Architecture](https://github.com/sougatamaitragit/marketlogic/images/PortsAndAdapter-QuestionService.jpg)

 
 
 # Component Interaction diagram for  
 
 
 # Exposed REST API's
 
 # Testability 
 All Rest Services are tested using Integration test script using RestAssured Testing framework . In current test cases exception paths are not covered
 
 # Build and Execution 
 
 # Deployability and Pre-requisite 
 
 As per pre-requisite jdk 1.8.x is required to be installed in the m/c where these services will run .
 It can be deployed in any OS where jdk 1.8.x is istalled . It is tested in windows 10. 
 
 # Assumption
 1. There will not be any hard delete for Question Entity . A deleteYN flag is used for mark the resource deletion.
 2. In memory databased is used.
 
 
 # Area of Improvement
1.  Open API Specification documentation can be used to describe APIs.
2.  Security and Logging are not implemented and can be augmented later. 

