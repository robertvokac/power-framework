SERVER_CONF=mailer-conf.properties
TO=$1
SUBJECT=$2
TEXT=$3
ATTACHMENT=$4

if [ -n "$TO" ]; then
  echo "Info: Var TO was supplied! TO=$TO"
else
  echo "Fatal: Var TO was not supplied. Exiting"
  exit
fi

if [ -n "$SUBJECT" ]; then
  echo "Info: Var SUBJECT was supplied! SUBJECT=$SUBJECT"
else
  echo "Fatal: Var SUBJECT was not supplied. Exiting"
  exit
fi

if [ -n "$TEXT" ]; then
  echo "Info: Var TEXT was supplied! TEXT=$TEXT"
else
  echo "Fatal: Var TEXT was not supplied. Exiting"
  exit
fi

if [ -n "$ATTACHMENT" ]; then
  echo "Info: Var ATTACHMENT was supplied! ATTACHMENT=$ATTACHMENT"
else
  echo "Info: Var ATTACHMENT was not supplied."
fi


export JAVA_HOME=/home/robertvokac/\.jdks/openjdk-16.0.1


$JAVA_HOME/bin/java -jar mailer.jar \
serverconf=$SERVER_CONF \
to=$TO \
"subject=$SUBJECT" \
"text=$TEXT" \
attachment=$ATTACHMENT
#>> ./mailer.log


