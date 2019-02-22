FROM noelalonso1/spring-boot-app-builder-web:2.1.3
MAINTAINER Noel Alonso Hernández <nalonsoh@viewnext.com>

# Copiar funetes
COPY . /tmp/src

# Construir aplicacion a partir de las fuentes
USER root
RUN /usr/local/s2i/assemble
USER 1001

EXPOSE 8080
ENTRYPOINT ["/usr/local/s2i/run"]