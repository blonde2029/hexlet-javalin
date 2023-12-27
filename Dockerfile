FROM gradle:8.2.1-jdk17

WORKDIR /HexletJavalin

COPY ./ .

RUN gradle clean install

CMD ./build/install/HexletJavalin/bin/HexletJavalin