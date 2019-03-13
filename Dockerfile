FROM goodforgod/debian-jdk10-oracle:sid

# Install curl & unzip
RUN apt-get -q update && \
    apt-get -qy install curl && \
    apt-get -qy install unzip

# Download project, build it, remove installed stuff
RUN cd / && \
    curl -LOk https://github.com/GoodforGod/oracle-aggregator/archive/master.zip && \
    unzip -q master.zip && \
    cd oracle-aggregator* && \
    ./gradlew && \
    apt-get -y remove curl && \
    apt-get -y remove unzip && \
    apt-get -y autoremove

ENTRYPOINT ["java", "-jar", "/oracle-aggregator/build/libs/oracle-aggregator-all-1.0.0.jar"]