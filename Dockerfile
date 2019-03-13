FROM goodforgod/debian-jdk10-oracle:sid

# Install curl & unzip
RUN apt-get -q update && \
    apt-get -qy install wget && \
    apt-get -qy install curl && \
    apt-get -qy install unzip

# Download project, build it, remove installed stuff
RUN cd / && \
    curl -LOk https://github.com/GoodforGod/oracle-aggregator/archive/master.zip && \
    unzip -q master.zip && \
    cd oracle-aggregator* && \
    wget -U "Chrome/68.0.3210.118" https://github.com/lazaronixon/ojdbc7/raw/master/com/heuristica/ojdbc7/12.1.0.2/ojdbc7-12.1.0.2.jar && \
    mkdir driver && \
    mv ojdbc7-12.1.0.2.jar driver/ && \
    chmod u+x gradlew && \
    ./gradlew bootJar && \
    apt-get -y remove curl && \
    apt-get -y remove unzip && \
    apt-get -y remove wget && \
    apt-get -y autoremove && \
    mv build/libs/oracle-aggregator-1.0.0.jar /

ENTRYPOINT ["java", "-jar", "/oracle-aggregator-1.0.0.jar"]
