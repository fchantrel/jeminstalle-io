express = require 'express'
path = require 'path'
http = require 'http'

app = express()
        
## all environments
app.set 'port', process.env.PORT || 3000
#app.use express.logger 'dev'
#app.use express.json()
#app.use express.urlencoded()
#app.use express.methodOverride()
#app.use app.Router
app.use express.static(path.join(__dirname, 'public'))
        
## development only
#if 'development' is app.get('env')
#        app.use express.errorHandler()
        
        
http.createServer(app).listen(app.get('port'), ->
        console.log 'Express server listening on port ' + app.get('port'))
