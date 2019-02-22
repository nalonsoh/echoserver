FROM noelalonso1/spring-boot-app-base-web:2.1.3
MAINTAINER Noel Alonso Hernández <nalonsoh@viewnext.com>
RUN git clone https://github.com/nalonsoh/echoserver /tmp/src \
	&& /usr/local/s2i/assemble

EXPOSE 8080
ENTRYPOINT ["/usr/local/s2i/run"]