fileToBackup=$1

if [ -n "$fileToBackup" ]; then
  echo "Info: Var fileToBackup was supplied! fileToBackup=$fileToBackup"
else
  echo "Fatal: Var fileToBackup was not supplied. Exiting"
  exit
fi
echo "Sending backup of file $fileToBackup."

./mailerrv.sh "Sending backup of file $fileToBackup" "Hello, <br /> <br /> I send you the backup file: $fileToBackup. <br /> <br /> With regards, Robert Vokac." $fileToBackup
#>> ./mailer.log
