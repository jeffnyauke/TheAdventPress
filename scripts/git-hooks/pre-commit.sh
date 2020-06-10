#!/bin/bash
echo "Running static analysis..."

JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
export JAVA_HOME

#set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_32
#set PATH=%PATH%;%JAVA_HOME%\bin

OUTPUT="/tmp/analysis-result"
./gradlew detekt ktlint lintDevDebug spotlessCheck --daemon > ${OUTPUT}
EXIT_CODE=$?
if [ ${EXIT_CODE} -ne 0 ]; then
    cat ${OUTPUT}
    rm ${OUTPUT}
    echo "*********************************************"
    echo "            Static Analysis Failed           "
    echo "Please fix the above issues before committing"
    echo "*********************************************"
    exit ${EXIT_CODE}
else
    rm ${OUTPUT}
    echo "*********************************************"
    echo "      Static analysis no problems found      "
    echo "*********************************************"
fi
