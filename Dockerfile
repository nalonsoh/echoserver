FROM noelalonso1/spring-boot-app-builder-web:2.1.3
MAINTAINER Noel Alonso Hernández <nalonsoh@viewnext.com>

# Copiar funetes
COPY . /tmp/src
USER root
RUN chown -R 1001  /tmp/src
USER 1001

# Construir aplicacion a partir de las fuentes
RUN /usr/local/s2i/assemble

EXPOSE 8080
ENTRYPOINT ["/usr/local/s2i/run"]