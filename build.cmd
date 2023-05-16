@ECHO OFF
set java_home=C:\data\tools\jdk\jdk-11.0.17+8

IF "%~1" == "" (
 set _build=compile
) else (
 if "%~1" == "springpackage" ( 
   set _build=package spring-boot:repackage -DskipTests
 ) else (
   if "%~1" == "sonar" ( 
     set _build=clean verify sonar:sonar
   ) else (
     set _build=%1 -DskipTests
   )
 )
)
IF "%~3" == "" (
 set _proxy='noproxy'
) else (
 set _proxy='%3'
)

if %_proxy% == 'proxy' (
set PROXY_CMD=-Dhttp.nonProxyHosts=bavsl036064.tally-weijl.ch -Dhttp.proxyHost=zrh1-2.sme.zscloud.net -Dhttp.proxyPort=9480 -Dhttps.proxyHost=zrh1-2.sme.zscloud.net -Dhttps.proxyPort=9480
) else (
set proxy_cmd=
)


echo "PL: %2"
echo "PROXY: %PROXY_CMD%"
echo "BUILD: %_build%"



IF "%~2" == "" (
   mvnw.cmd clean %_build% -am  %PROXY_CMD%
) else (
   mvnw.cmd clean %_build% -pl %2 -am %PROXY_CMD%
)
