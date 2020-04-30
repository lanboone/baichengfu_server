#! /bin/shell

#======================================================================
# mvn package script
# default local profile
#
# author: liyuan
# date: 2020-04-18
#======================================================================

PROFILE=$1
if [[ -z "$PROFILE" ]]; then
    PROFILE=local
fi
echo "profile:${PROFILE}"
mvn clean package -P${PROFILE} -DskipTests
echo "profile:${PROFILE}"