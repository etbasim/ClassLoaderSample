FROM open-liberty:full
EXPOSE 9080
EXPOSE 9443
ENV HTTP_ENDPOINT true
RUN configure.sh