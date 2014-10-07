# restart zebra server
kill -- -$(cat zebra.pid)

#sleep 2

sudo zebrasrv -p zebra.pid -l log/log.txt -u jboss -D tcp:@:210
