print("")
print("Hi Sezayir:)")
print("")
prompt = function() {
    if (typeof db == 'undefined') {
        return '(nodb)> ';
    }
// Check the last db operation
    try {
        db.runCommand({getLastError:1});
    }
    catch (e) {
        print(e);
    }
   return db+"@"+db.serverStatus().host+"> ";
};


d = function d(){
     return db._adminCommand( { listDatabases: 1 } )}
c = function c(){
    return db.getCollectionNames()
	}