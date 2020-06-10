#!/bin/sh
echo "Running static analysis for project..."

#JAVA_HOME="C:\Program Files\Java\jdk1.8.0_181"
#export JAVA_HOME

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
    echo "            Static Analysis Success          "
    echo "               No problems found             "
    echo "*********************************************"
fi
