FROM openjdk:8
ADD target/product.jar product.jar
EXPOSE 8002
ENTRYPOINT ["java","-jar","product.jar"]